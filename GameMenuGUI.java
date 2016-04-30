import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// ******************************************************************
//   GameMenuGUI.java
//
//   GUI for the minigames
// ******************************************************************

public class GameMenuGUI extends JPanel
{
    public GameMenuGUI()
    {
        //this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        JButton RPS = new JButton("Rock Paper Scissors");
        RPS.setAlignmentX(Component.CENTER_ALIGNMENT);
        RPS.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        JButton TTT = new JButton("Tic Tac Toe");
        TTT.setAlignmentX(Component.CENTER_ALIGNMENT);
        TTT.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        JButton Chopsticks = new JButton("Chopsticks");
        Chopsticks.setAlignmentX(Component.CENTER_ALIGNMENT);
        Chopsticks.setAlignmentY(Component.CENTER_ALIGNMENT);

        Box buttonPanel = Box.createVerticalBox();
        
       // buttonPanel.setLayout(new BorderLayout());
        
        buttonPanel.add(RPS);
        
        buttonPanel.add(Box.createVerticalStrut(10));
        
        buttonPanel.add(TTT);
        
        buttonPanel.add(Box.createVerticalStrut(10));
        
        buttonPanel.add(Chopsticks);
        
        this.add(buttonPanel);
    }
    
//     public void paintComponent(Graphics g)
//     {
//         super.paintComponent(g);
//         int w= getWidth()/2;
//         int h= getHeight()/2;
//         setBackground(Color.lightGray);
//         g.setColor(Color.green);
//         g.fillRect(w-100/2,h-25/2,100,25);
//         g.setColor(Color.black);
//         g.drawString("Rock Paper Scissors",w-110/2,h+1/2);
//         
//         
//     }
    
    

   
}
