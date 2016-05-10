
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
    private int mX, mY, ctr, s;
    private Timer timer;
    private int[][] board;
    private boolean win = false;
    public TTT() {
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
        for (int i = 1; i < s; i++) {
            for (int j = 1; j < s; j++) {
                g.fillRect(0, i * (h / 3) - 10, 500, 20);
                g.fillRect(j * (w / 3) - 10, 0, 20, 500);
            }
        }
        g.drawString("" + mX + " " + mY + " " + ctr, 200, 125);
        for (int i = 0; i < s; i++){
            for (int j = 0; j < s; j++){
                if (i == mX && j == mY && board[j][i] == 0){
                    ctr++;
                    board[j][i] = ctr%2+1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                if (board[j][i] == 1){
                    g.setColor(Color.blue);
                    g.fillOval(i*500/3,j*500/3,140,140);
                }
                else if (board[j][i] == 2){
                    g.setColor(Color.red);
                    g.fillRect(i*500/3,j*500/3,140,140);
                }
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println(ctr + "");
        if (checkWinner(ctr%2+1)){
            win = true;
            g.drawString("you are winner",250,250);
        }
    }

    public boolean checkWinner(int w)
    {
        for (int i = 0; i < s; i++)
            if (board[i][0] == w && board[i][1] == w && board[i][2] == w)
                return true;
        for (int j = 0; j < s; j++)
            if (board[0][j] == w && board[1][j] == w && board[2][j] == w)
                return true;
        if (board[0][0] == w && board[1][1] == w && board[2][2] == w)
            return true;
        if (board[0][2] == w && board[1][1] == w && board[2][0] == w)
            return true;
        return false;
    }

    public void mouseClicked(MouseEvent me) {

    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseReleased(MouseEvent me) {
        if (!win){
            mX = (int)(me.getX()/500.0*3);
            mY = (int)(me.getY()/500.0*3);
        }
        else
            System.out.print("");
    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }

    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
