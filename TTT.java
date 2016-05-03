import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Write a description of class TTT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TTT extends JFrame//Tic Tac Toe
{
    private int[][] board;
    public TTT()
    {
        board = new int[3][3];
        display();
    }

    public TTT(int r, int c)
    {
        board = new int[r][c];
        display();
    }

    public void display() {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
//         for (int r = 0; r < board.length; r++){
//             for (int c = 0; c < board[0].length; c++){
//                 g.drawRect(500*r,500*c,500/board.length,500/board[0].length);
//             }
//         }
g.setColor(Color.black);
g.drawRect(0,0,100,100);
    }
}
