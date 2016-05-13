
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
    private boolean end = false;
    private BufferedImage x, o;
    private int mX, mY, ctr, s;
    private int[][] board;
    private Timer timer;
    public TTT() 
    {
        board = new int[3][3];
        s = 3;
        init();
    }

    public TTT(int s)
    {
        board = new int[s][s];
        this.s = s;
        init();
    }

    public void init()
    {
        ctr = 0;
        mX = mY = s+1;
        timer = new Timer(16, this);
        timer.start();
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        //if (!end){
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
                        board[j][i] = ctr%2+1;
                    }
            for (int i = 0; i < board.length; i++) 
                for (int j = 0; j < board[0].length; j++)
                    if (board[j][i] == 1)
                        g.drawImage(x,i*500/s,j*500/s,500/s,500/s,null);
                    else if (board[j][i] == 2)
                        g.drawImage(o,i*500/s,j*500/s,500/s,500/s,null);
            for (int i = 1; i < s; i++) 
                for (int j = 1; j < s; j++) {
                    g.fillRect(0, i * (getHeight() / s) - 10, 500, 20);
                    g.fillRect(j * (getWidth() / s) - 10, 0, 20, 500);
                }
        //}
        System.out.print(ctr);
        int w = checkWinner(ctr%2+1);
        if (w != 0){
            Font f = new Font("Arial", Font.PLAIN, 48);
            g.setFont(f);
            end = true;
            g.drawString("Player "+w+" wins",100,100);
        }
        else if (checkTie()){
            end = true;
            g.drawString("Tie",225,250);
        }

    }

    public int checkWinner(int w)
    {
        boolean win = true;
        for (int i = 0; i < s; i++)
            for (int j = 0; j < s; j++)
                if (board[i][j] != w)
                    win = false;
        if (win)
            return w;
        win = true;
        for (int j = 0; j < s; j++)
            for (int i = 0; i < s; i++)
                if (board[i][j] != w)
                    win = false;
        if (win)
            return w;
        win = true;
        for (int k = 0; k < s; k++)
            if (board[k][k] != w)
                win = false;
        if (win)
            return w;
        win = true;
        for (int l = s-1; l >= 0; l--)
            if (board[l][s-l-1] != w)
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
        repaint();
    }
}
