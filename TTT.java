
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
    private JComboBox<String> cb;
    private megaTTT mTTT;
    public TTT() 
    {
        String[] versionOptions = {"Normal","Mega"};
        cb = new JComboBox<>(versionOptions);
        cb.setSelectedIndex(0);
        cb.addActionListener(this);
        this.add(cb);
    }

    public TTT(int size)
    {
        s = size;
    }
    
    public void initn()
    {
        String[] sizeOptions = { "3", "4", "5", "6", "7" };
        cb = new JComboBox<>(sizeOptions);
        cb.setSelectedIndex(0);
        cb.addActionListener(this);
        this.add(cb);
    }

    public void init()
    {
        board = new int[s][s];
        this.s = s;
        ctr = 0;
        mX = mY = s+1;
        timer = new Timer(16, this);
        timer.start();
        start = true;
        addMouseListener(this);
    }

    public void initm()
    {
        mTTT = new megaTTT();
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Font f = new Font("Arial", Font.PLAIN, 48);
        g.setFont(f);
        if (start){ // normal TTT gameplay
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
        else{ // intro of normal
            g.drawString("Tic Tac Toe",100,300);
        }
        if (ctr > s){ //general winning check
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
        if (!start){
            JComboBox cb1 = (JComboBox)ae.getSource();
            String result = (String)cb1.getSelectedItem();
            cb.removeActionListener(this);
            remove(cb);
            if (result.equals("Normal"))
                initn();
            else if (result.equals("Mega"))
                initm();
            else
                s = Integer.parseInt(result);
            init();
        }
        repaint();
    }

}
class megaTTT extends JPanel implements MouseListener, ActionListener
{
    private TTT[][] board;
    public megaTTT()
    {
        board = new TTT[3][3];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = new TTT(3);
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
    }

    public void mouseClicked(MouseEvent me) {

    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseReleased(MouseEvent me) {
      
    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }

    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
