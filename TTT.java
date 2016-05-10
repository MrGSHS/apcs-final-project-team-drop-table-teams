
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
    private static final long serialVersionUID = 1L;
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
        mX = mY = 3;
        timer = new Timer(16, this);
        timer.start();
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
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
        for (int i = 1; i < s; i++) 
            for (int j = 1; j < s; j++) {
                g.fillRect(0, i * (getHeight() / 3) - 10, 500, 20);
                g.fillRect(j * (getWidth() / 3) - 10, 0, 20, 500);
            }
        for (int i = 0; i < s; i++)
            for (int j = 0; j < s; j++)
                if (i == mX && j == mY && board[j][i] == 0){
                    ctr++;
                    board[j][i] = ctr%2+1;
                }
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[0].length; j++)
                if (board[j][i] == 1)
                    g.drawImage(x,i*500/3,j*500/3,null);
                else if (board[j][i] == 2)
                    g.drawImage(o,i*500/3,j*500/3,null);
        int w = checkWinner();
        if (w != 0){
            end = true;
            g.drawString("Player "+w+" wins",225,250);
        }
        else if (checkTie()){
            end = true;
            g.drawString("Tie",225,250);
        }
    }

    public int checkWinner()
    {
        for (int i = 0; i < s; i++)
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
        for (int j = 0; j < s; j++)
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j])
                return board[0][j];
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];
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
            mX = (int)(me.getX()/500.0*3);
            mY = (int)(me.getY()/500.0*3);
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
