
/**
 * Write a description of class GameMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameMenu extends JPanel implements ActionListener
{
    private static JFrame frame;
    private JButton RPS, Chopsticks, TTT;
    private int game, mouseX, mouseY;
    Box buttonPanel;
    public static void main(String[] args)
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.add(new GameMenu());
        frame.pack();
        frame.setVisible(true);
        
    }

    public GameMenu()
    {
        //this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        game = 0;
        RPS = new JButton("Rock Paper Scissors");
        RPS.setAlignmentX(Component.CENTER_ALIGNMENT);
        RPS.setAlignmentY(Component.CENTER_ALIGNMENT);
        RPS.addActionListener(this);

        Chopsticks = new JButton("Chopsticks");
        Chopsticks.setAlignmentX(Component.CENTER_ALIGNMENT);
        Chopsticks.setAlignmentY(Component.CENTER_ALIGNMENT);
        Chopsticks.addActionListener(this);

        TTT = new JButton("Tic Tac Toe");
        TTT.setAlignmentX(Component.CENTER_ALIGNMENT);
        TTT.setAlignmentY(Component.CENTER_ALIGNMENT);
        TTT.addActionListener(this);

        buttonPanel = Box.createVerticalBox();
        //buttonPanel.setLayout();
        buttonPanel.add(RPS);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Chopsticks);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(TTT);
        this.add(buttonPanel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource().equals(RPS)){
            this.remove(buttonPanel);
            RPS_Panel rps = new RPS_Panel();
        }
        if(ae.getSource().equals(Chopsticks)){
            this.remove(buttonPanel);
            Chopsticks_Panel chopsticks = new Chopsticks_Panel();
        }
        if(ae.getSource().equals(TTT)){
            this.remove(buttonPanel);
            frame.remove(buttonPanel);
            TTT_Panel ttt = new TTT_Panel(frame);
        }
    } 
}
