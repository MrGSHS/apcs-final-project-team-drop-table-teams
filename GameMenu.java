
/**
 * Write a description of class GameMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameMenu extends JPanel implements ActionListener, MouseListener
{
    private static JFrame frame;
    private JButton RPS, Chopsticks, TTT;
    private int game, mouseX, mouseY;
    JPanel buttonPanel;
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
        //RPS.setAlignmentX(Component.CENTER_ALIGNMENT);
        //RPS.setAlignmentY(Component.CENTER_ALIGNMENT);
        RPS.addActionListener(this);

        Chopsticks = new JButton("Chopsticks");
        //Chopsticks.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Chopsticks.setAlignmentY(Component.CENTER_ALIGNMENT);
        Chopsticks.addActionListener(this);

        TTT = new JButton("Tic Tac Toe");
        //TTT.setAlignmentX(Component.CENTER_ALIGNMENT);
        //TTT.setAlignmentY(Component.CENTER_ALIGNMENT);
        TTT.addActionListener(this);

        buttonPanel = new JPanel(new GridLayout(3,1));
        //buttonPanel.setLayout();
        buttonPanel.add(RPS);
        //buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Chopsticks);
        //buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(TTT);
        
        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setPreferredSize(new Dimension(350,400));
        wrapperPanel.add(buttonPanel);
        
        this.add(wrapperPanel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource().equals(RPS)){
            game = 1;
        }
        if(ae.getSource().equals(Chopsticks)){
            game = 2;
        }
        if(ae.getSource().equals(TTT)){
            game = 3;
        }
    }

    public void paintComponent(Graphics g)
    {
        addMouseListener(this);
        if (game == 1){
            super.paintComponent(g);
            int w= getWidth();
            int h= getHeight();
            setBackground(Color.lightGray);
            this.remove(buttonPanel);
        }
        
        if (game == 2){
            super.paintComponent(g);
            int w= getWidth();
            int h= getHeight();
            setBackground(Color.lightGray);
            this.remove(buttonPanel);
        }
        
        if (game == 3){
            super.paintComponent(g);
            int w= getWidth();
            int h= getHeight();
            setBackground(Color.lightGray);
            g.setColor(Color.red);
            this.remove(buttonPanel);
            int r = 3, c = 3;
            TTT tic = new TTT();
            for (int i = 1; i < r; i++){
                for (int j = 1; j < c; j++){
                    g.fillRect(0,i*(h/3)-10,500,20);
                    g.fillRect(j*(w/3)-10,0,20,500);
                }
            }
            g.drawString(""+mouseX+" "+mouseY,200,150);
        }
    }
    
    public void mouseClicked(MouseEvent me)
    {
        mouseX = me.getX();
        mouseY = me.getY();
    }
    
    public void mousePressed(MouseEvent me)
    {
        
    }
    
    public void mouseReleased(MouseEvent me)
    {
        
    }
    
    public void mouseEntered(MouseEvent me)
    {
        
    }
    
    public void mouseExited(MouseEvent me)
    {
        
    }
}
