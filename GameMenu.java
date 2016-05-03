
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
    private int game;
    private static boolean showButt;
    public static void main(String[] args)
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        showButt=true;
        frame.getContentPane().add(new GameMenu());
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

        Box buttonPanel = Box.createVerticalBox();
        // buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(RPS);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Chopsticks);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(TTT);
        
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource().equals(RPS)){
            showButt=false;
            game=1;
        }
        if(ae.getSource().equals(Chopsticks)){
            game=2;
        }
        if(ae.getSource().equals(TTT)){
            game=3;
        }
    }

    public void paintComponent(Graphics g)
    {
        if(game==1){
            super.paintComponent(g);
            int w= getWidth()/2;
            int h= getHeight()/2;
            setBackground(Color.lightGray);
            g.setColor(Color.green);
            g.fillRect(w-100/2,h-25/2,100,25);
            g.setColor(Color.black);
            g.drawString("Rock Paper Scissors",w-110/2,h+1/2);
        }

    }
}
