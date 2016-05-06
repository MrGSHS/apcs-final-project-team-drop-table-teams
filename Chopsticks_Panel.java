 

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class TTT_Frame here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Chopsticks_Panel extends JPanel implements MouseListener, ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int mouseX, mouseY;
    int mouseC = 0;
    boolean win = false;
    int choice1, choice2;
    
    public Chopsticks_Panel() {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        setBackground(Color.lightGray);
        g.setColor(Color.blue);
        
        if( mouseC % 4 == 0 ){
          g.drawString("Player 1 choose your hand", 150, 50);
        }
        else if( mouseC % 4 == 1 ){
          g.drawString("Player 1 choose opponent's hand", 150, 50);
        }
        else if( mouseC % 4 == 2 ){
          g.drawString("Player 2 choose your hand", 150, 50);
        }
        else if( mouseC % 4 == 3 ){
          g.drawString("Player 2 choose oppenent's hand", 150, 50);
        }
        
        
        
    }

    public void mouseClicked(MouseEvent me) {
       
    }

    public void mousePressed(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        if( mouseC % 4 == 0 && mouseY > 250){
           mouseC++;
        }
        else if( mouseC % 4 == 1 && mouseY < 250){
          mouseC++;
        }
        else if( mouseC % 4 == 2 && mouseY < 250){
          mouseC++;
        }
        else if( mouseC % 4 == 3 && mouseY > 250){
          mouseC++;
        }
        //mouseC++;
        repaint();
    }

    public void mouseReleased(MouseEvent me) {

    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }
    
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
