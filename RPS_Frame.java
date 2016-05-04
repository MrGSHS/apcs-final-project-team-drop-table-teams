import javax.swing.*;

/**
 * Write a description of class RPS_Frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RPS_Frame
{
    private int x;
 
    public RPS_Frame()
    {
        JFrame f = new JFrame("Rock, Paper, Scissors");
        f.setSize(600, 600);
        JButton rock = new JButton("Hi");
        JButton paper = new JButton();
        JButton scissors = new JButton();
        f.setLayout(null);
        f.setVisible(true);
        
        f.add(rock);
        f.add(paper);
        f.add(scissors);
        
        rock.setLocation(100,0);
    }

    
    public static void sampleMethod()
    {
        
    }
    // instance variables - replace the example below with your own
    
}
