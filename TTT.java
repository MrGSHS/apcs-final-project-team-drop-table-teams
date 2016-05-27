import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import java.io.*;
import java.awt.Font.*;
/**
 * The TTT class contains everything necessary for the tic tac toe game
 * 
 * @author John Armgardt
 * @version 5/26/16
 */
public class TTT extends JPanel implements MouseListener, ActionListener {
    //private static final long serialVersionUID = 1L;
    private boolean end = false, start = false, mega;
    private BufferedImage x, o;
    private int mX, mY, ctr, size = 0;
    private int[][] board;
    private Timer timer;
    private JComboBox<String> cb;
    private JPanel wrapperPanel;
    public TTT() 
    {
        String[] gameOptions = {"Normal","Mega"};
        cb = new JComboBox<>(gameOptions);
        cb.setSelectedIndex(0);
        cb.addActionListener(this);
        this.add(cb);
    }

    //public void normal()
    //{
    //mega = false;
    //this.remove(cb);
    //String[] sizeOptions = { "3", "4", "5", "6", "7", "8", "9"};
    //cb = new JComboBox<>(sizeOptions);
    //cb.setSelectedIndex(0);
    //cb.addActionListener(this);
    //this.add(cb1);
    //}

    public void init()
    {
        board = new int[size][size];
        ctr = 0;
        mX = mY = size+1;
        timer = new Timer(16, this);
        timer.start();
        start = true;
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Font f = new Font("Arial", Font.PLAIN, 48);
        g.setFont(f);
        if (start){
            try {
                x = ImageIO.read(new File("x.png"));
                o = ImageIO.read(new File("o.png"));
            }
            catch (IOException e){
                System.out.println("Image could not be read");
                System.exit(1);
            }
            setBackground(Color.lightGray);
            g.setColor(Color.black);
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    if (i == mX && j == mY && board[j][i] == 0){
                        ctr++;
                        board[j][i] = (ctr-1)%2+1;
                    }
            for (int i = 0; i < size; i++) 
                for (int j = 0; j < size; j++)
                    if (board[j][i] == 2)
                        g.drawImage(x,i*getWidth()/size,j*getHeight()/size,getWidth()/(size+1),getHeight()/(size+1),null);
                    else if (board[j][i] == 1)
                        g.drawImage(o,i*getWidth()/size,j*getHeight()/size,getWidth()/(size+1),getHeight()/(size+1),null);
            for (int i = 1; i < size; i++) 
                for (int j = 1; j < size; j++) {
                    g.fillRect(0, i * (getHeight() / size), 500, 1);
                    g.fillRect(j * (getWidth() / size), 0, 1, 500);
                }
            if (mega)
                for (int i = 1; i < 3; i++) 
                    for (int j = 1; j < 3; j++) {
                        g.fillRect(0, i * (getHeight() / 3), 500, 5);
                        g.fillRect(j * (getWidth() / 3), 0, 5, 500);
                    }
        }
        else{
            g.drawString("Tic Tac Toe",100,100);
        }
        if (mega){
            checkWinnerMega();
        }
        if (ctr > size){
            int w = checkWinner(board);
            if (w != 0){
                end = true;
                g.drawString("Player "+w+" wins",100,100);
            }
            else if (checkTie(board)){
                end = true;
                g.drawString("Tie",225,250);
            }
        }
    }

    public int checkWinner(int[][] b)
    {
        boolean win = true;
        int w = b[0][0];
        for (int i = 0; i < b.length; i++){
            w = b[i][0];
            for (int j = 0; j < b.length; j++)
                if (b[i][j] != w)
                    win = false;
            if (win && b[i][0] != 0)
                return w;
            win = true;
        }
        win = true;
        for (int i = 0; i < b.length; i++){
            w = b[0][i];
            for (int j = 0; j < b.length; j++)
                if (b[j][i] != w)
                    win = false;
            if (win && b[0][i] != 0)
                return w;
            win = true;
        }
        win = true;
        w = b[0][0];
        for (int k = 0; k < b.length; k++)
            if (b[k][k] != w)
                win = false;
        if (win)
            return w;
        win = true;
        w = b[b.length-1][0];
        for (int l = 0; l < b.length; l++)
            if (b[l][b.length-1-l] != w)
                win = false;
        if (win)
            return w;
        return 0;
    }

    public void checkWinnerMega()
    {
        int[][] b = new int[3][3];
        int i = 0, j = 0;
        while (i < 9){
            while (j < 9){
                b[i%3][j%3] = board[i][j];
                if ((i+1)%3 == 0 &&(j+1)%3 == 0){
                    int w = checkWinner(b);
                    if (w != 0){
                        for (int k = i; k > i-3; k--){
                            for (int l = j; l > j-3; l--){
                                board[k][l] = w;
                            }
                        }
                        if (i == 8 && j == 8)
                            return;
                        else if (j == 8){
                            i++;
                            j = 0;
                            b = new int[3][3];
                        }
                        else{
                            i-=2;
                            j++;
                            b = new int[3][3];
                        }
                    }
                    else if (checkTie(b)){
                        for (int k = i; k > i-3; k--){
                            for (int l = j; l > j-3; l--){
                                board[k][l] = 0;
                            }
                        }
                        if (i == 8 && j == 8)
                            return;
                        else if (j == 8){
                            i++;
                            j = 0;
                            b = new int[3][3];
                        }
                        else{
                            i-=2;
                            j++;
                            b = new int[3][3];
                        }
                        return;
                    }
                    else{
                        i-=2;
                        j++;
                    }
                }
                else if ((j+1)%3 == 0){
                    i++;
                    j-=2;
                }
                else
                    j++;
            }
            i+=3;
            j = 0;
        }
    }

    public boolean checkTie(int[][] b)
    {
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++)
                if (b[i][j] == 0)
                    return false;
        return true;
    }

    public void mouseClicked(MouseEvent me) {

    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseReleased(MouseEvent me) {
        if (!end){
            mX = (int)(me.getX()/500.0*size);
            mY = (int)(me.getY()/500.0*size);
        }
        else
            GameMenu.main(new String[0]);
    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }

    public void actionPerformed(ActionEvent ae) {
        if (!start){
            JComboBox cb1 = (JComboBox)ae.getSource();
            String r = (String)cb1.getSelectedItem();
            if (r.equals("Normal")){
                size = 3;
                //normal();
                mega = false;
            }
            else if (r.equals("Mega")){
                size = 9;
                mega = true;
            }
            else
                size = Integer.parseInt(r);
            cb.removeActionListener(this);
            remove(cb);
            init();
        }
        repaint();
    }
}

