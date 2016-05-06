
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Polygon.*;
/**
 * Write a description of class TTT_Frame here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class TTT extends JPanel implements MouseListener, ActionListener {
    private static final long serialVersionUID = 1L;
    private int mX, mY, ctr;
    private Timer timer;
    private int[][] board;
    public TTT() {
        board = new int[3][3];
        init();
    }

    public TTT(int r, int c)
    {
        board = new int[r][c];
        init();
    }

    public void init()
    {
        ctr = 0;
        mX = mY = 3;
        timer = new Timer(40, this);
        timer.start();
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        setBackground(Color.lightGray);
        g.setColor(Color.red);
        int r = 3, c = 3;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                g.fillRect(0, i * (h / 3) - 10, 500, 20);
                g.fillRect(j * (w / 3) - 10, 0, 20, 500);
            }
        }
        g.drawString("" + mX + " " + mY + " " + ctr, 200, 125);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (i == mX && j == mY && board[i][j] == 0){
                    board[i][j] = ctr%2+1;
                    ctr++;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 1){
                    g.setColor(Color.blue);
                    g.fillOval(i*500/3,j*500/3,140,140);
                }
                else if (board[i][j] == 2){
                    g.setColor(Color.red);
                    g.fillRect(i*500/3,j*500/3,140,140);
                }
            }
        }
    }
    

    public void mouseClicked(MouseEvent me) {
        
    }

    public void mousePressed(MouseEvent me) {
        
    }

    public void mouseReleased(MouseEvent me) {
        mX = (int)(me.getX()/500.0*3);
        mY = (int)(me.getY()/500.0*3);
    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }

    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
