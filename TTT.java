import javax.swing.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Write a description of class TTT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TTT //Tic Tac Toe
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
    
//     public static void display()
//     {
//         JFrame f = new JFrame("Tic Tac Toe");
//         f.setSize(500,500);
//         f.setVisible(true);
//         for (int r = 0; r < board.length; r++){
//             for (int c = 0; c < board[0].length; c++){
//                 g.drawRect(500*r,500*c,500/board.length,500/board[0].length);
//             }
//         }
//     }
    
    public void paint(Graphics g)
    {
        JFrame f = new JFrame("Tic Tac Toe");
        f.setSize(500,500);
        f.setVisible(true);
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                g.drawRect(500*r,500*c,500/board.length,500/board[0].length);
            }
        }
    }
}
