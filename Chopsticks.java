 

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class TTT_Frame here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Chopsticks extends JPanel implements MouseListener, ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int mouseX, mouseY;
    int mouseC = 0;
    boolean win = false;
    int choice1 = 0;
    int p1 = 1;
    int p2 = 1;
    int p3 = 1;
    int p4 = 1;
    
    public Chopsticks() {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        setBackground(Color.lightGray);
        
        g.setColor(Color.blue);
        g.drawString("Player 1", 210, 10);
        g.setColor(Color.red);
        g.drawString("Player 2", 210, 470);
        
        g.setColor(Color.black);
        if( mouseC % 4 == 0 ){
          g.drawString("Player 1 choose your hand", 150, 230);
        }
        else if( mouseC % 4 == 1 ){
          g.drawString("Player 1 choose opponent's hand", 150, 230);
        }
        else if( mouseC % 4 == 2 ){
          g.drawString("Player 2 choose your hand", 150, 230);
        }
        else if( mouseC % 4 == 3 ){
          g.drawString("Player 2 choose oppenent's hand", 150, 230);
        }
        
        g.drawString(""+p1, 120, 370);
        g.drawString(""+p2, 370, 370);
        g.drawString(""+p3, 120, 120);
        g.drawString(""+p4, 370, 120);
    }

    public void mouseClicked(MouseEvent me) {
       
    }

    public void mousePressed(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        if( mouseC % 4 == 0 && mouseY > 250){
           if (mouseX < 250 && p1 != 0){
               choice1 = p1;
               mouseC++;
           }
           else if (mouseX > 250 && p2 != 0){
               choice1 = p2;
               mouseC++;
           }
           
        }
        else if( mouseC % 4 == 1 && mouseY < 250){
           if (mouseX < 250 && p3 != 0){
               p3 = (p3 + choice1)%5;
               mouseC++;
           }
           else if (mouseX > 250 && p4 != 0){
               p4 = (p4 + choice1)%5;
               mouseC++;
           }
        }
        else if( mouseC % 4 == 2 && mouseY < 250){
           if (mouseX < 250 && p3 != 0){
               choice1 = p3;
               mouseC++;
           }
           else if (mouseX > 250 && p4 != 0){
               choice1 = p4;
               mouseC++;
           }
        }
        else if( mouseC % 4 == 3 && mouseY > 250){
           if (mouseX < 250 && p1 != 0){
               p1 = (p1 + choice1)%5;
               mouseC++;
           }
           else if (mouseX > 250 && p2 != 0){
               p2 = (p2 + choice1)%5;
               mouseC++;
           }
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
        
    }
}
