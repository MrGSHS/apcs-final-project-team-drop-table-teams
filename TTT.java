import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
/**
 * Write a description of class TTT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TTT extends JPanel//Tic Tac Toe
{
    private int[][] board;
    JPanel panel;
    public TTT()
    {
        board = new int[3][3];
    }

    public TTT(int r, int c)
    {
        board = new int[r][c];
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0,0,100,100);
    }
}
