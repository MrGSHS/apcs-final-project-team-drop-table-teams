
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import java.io.*;
import java.awt.Font.*;
/**
 * Write a description of class TTT_Frame here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class TTT extends JPanel implements MouseListener, ActionListener {
    //private static final long serialVersionUID = 1L;
    private boolean end = false, start = false;
    private BufferedImage x, o;
    private int mX, mY, ctr, s = 0;
    private int[][] board;
    private Timer timer;
    private JTextField tf;
    public TTT() 
    {
        tf = new JTextField(1);
        tf.addActionListener(this);
        this.add(tf);
    }

    public void init()
    {
        board = new int[s][s];
        this.s = s;
        ctr = 0;
        mX = mY = s+1;
        timer = new Timer(16, this);
        timer.start();
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
            for (int i = 0; i < s; i++)
                for (int j = 0; j < s; j++)
                    if (i == mX && j == mY && board[j][i] == 0){
                        ctr++;
                        board[j][i] = (ctr-1)%2+1;
                    }
            for (int i = 0; i < s; i++) 
                for (int j = 0; j < s; j++)
                    if (board[j][i] == 2)
                        g.drawImage(x,i*getWidth()/s,j*getHeight()/s,getWidth()/(s+1),getHeight()/(s+1),null);
                    else if (board[j][i] == 1)
                        g.drawImage(o,i*getWidth()/s,j*getHeight()/s,getWidth()/(s+1),getHeight()/(s+1),null);
            for (int i = 1; i < s; i++) 
                for (int j = 1; j < s; j++) {
                    g.fillRect(0, i * (getHeight() / s), 500, 1);
                    g.fillRect(j * (getWidth() / s), 0, 1, 500);
                }
        }
        else{
            g.drawString("Tic Tac Toe",100,20);
        }
        if (ctr > s){
            int w = checkWinner();
            if (w != 0){
                end = true;
                g.drawString("Player "+w+" wins",100,100);
            }
            else if (checkTie()){
                end = true;
                g.drawString("Tie",225,250);
            }
        }
    }

    public int checkWinner()
    {
        boolean win = true;
        int w = board[0][0];
        for (int i = 0; i < s; i++){
            w = board[i][0];
            for (int j = 0; j < s; j++)
                if (board[i][j] != w)
                    win = false;
            if (win)
                return w;
            win = true;
        }
        win = true;
        for (int i = 0; i < s; i++){
            w = board[0][i];
            for (int j = 0; j < s; j++)
                if (board[j][i] != w)
                    win = false;
            if (win)
                return w;
            win = true;
        }
        win = true;
        w = board[0][0];
        for (int k = 0; k < s; k++)
            if (board[k][k] != w)
                win = false;
        if (win)
            return w;
        win = true;
        w = board[s-1][0];
        for (int l = 0; l < s; l++)
            if (board[l][s-1-l] != w)
                win = false;
        if (win)
            return w;
        return 0;
    }

    public boolean checkTie()
    {
        for (int i = 0; i < s; i++)
            for (int j = 0; j < s; j++)
                if (board[i][j] == 0)
                    return false;
        return true;
    }

    public void mouseClicked(MouseEvent me) {

    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseReleased(MouseEvent me) {
        if (!end){
            mX = (int)(me.getX()/500.0*s);
            mY = (int)(me.getY()/500.0*s);
        }
        else
            GameMenu.main(new String[0]);
    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }

    public void actionPerformed(ActionEvent ae) {
        if (s == 0){
            String text = tf.getText();
            try{
                s = Integer.parseInt(text);
            }
            catch (NumberFormatException e){
                return; 
            }
            tf.removeActionListener(this);
            this.remove(tf);
            init();
        }
        repaint();
    }
}
