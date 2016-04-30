
/**
 * Write a description of class GameMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;
public class GameMenu
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));

        frame.getContentPane().add(new GameMenuGUI());

        frame.pack();
        frame.setVisible(true);
    }
}
