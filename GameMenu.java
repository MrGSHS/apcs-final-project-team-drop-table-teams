
/**
 * Write a description of class GameMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import java.io.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class GameMenu extends JPanel implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static JFrame frame;
    private JButton RPS, Chopsticks, TTT;
    private JPanel buttonPanel, wrapperPanel;
    private static GameMenu game = new GameMenu();

    public static void main(String[] args) {
        game = new GameMenu();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }
    
    public void paintComponent(Graphics g) {
        setBackground(Color.blue);
    }
    
    public GameMenu() {
        
        
        // this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        RPS = new JButton("Rock Paper Scissors");
        // RPS.setAlignmentX(Component.CENTER_ALIGNMENT);
        // RPS.setAlignmentY(Component.CENTER_ALIGNMENT);
        RPS.addActionListener(this);

        Chopsticks = new JButton("Chopsticks");
        // Chopsticks.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Chopsticks.setAlignmentY(Component.CENTER_ALIGNMENT);
        Chopsticks.addActionListener(this);

        TTT = new JButton("Tic Tac Toe");
        // TTT.setAlignmentX(Component.CENTER_ALIGNMENT);
        // TTT.setAlignmentY(Component.CENTER_ALIGNMENT);
        TTT.addActionListener(this);

        buttonPanel = new JPanel(new GridLayout(3, 1));
        // buttonPanel.setLayout();
        buttonPanel.add(RPS);
        // buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Chopsticks);
        // buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(TTT);

        wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setPreferredSize(new Dimension(350, 400));
        wrapperPanel.add(buttonPanel);
        wrapperPanel.setBackground(Color.blue);
        buttonPanel.setBackground(Color.blue);
        this.add(wrapperPanel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(RPS)) {
            frame.remove(game);
            RPS rps = new RPS();
            frame.add(rps);
            frame.pack();
        }
        if (ae.getSource().equals(Chopsticks)) {
            frame.remove(game);
            Chopsticks chopsticks = new Chopsticks();
            frame.add(chopsticks);
            frame.pack();
        }
        if (ae.getSource().equals(TTT)) {
            frame.remove(game);
            TTT ttt = new TTT();
            frame.add(ttt);
            frame.pack();

        }
    }
}
