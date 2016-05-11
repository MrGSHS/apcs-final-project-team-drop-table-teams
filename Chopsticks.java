 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import java.io.*;


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
        setBackground(Color.white);
        
        BufferedImage ChopUp = null;
        BufferedImage ChopDown = null;
        try 
        {
            ChopUp = ImageIO.read(new File("image1.png"));
            ChopDown = ImageIO.read(new File("image2.png"));
           
        }
        catch (IOException e)
        {
            System.out.println("Image could not be read");
            System.exit(1);
        }
        
        if((p1 == 0 && p2 == 0) || (p3 == 0 && p4 == 0)){
            setBackground(Color.orange);
            g.setColor(Color.blue);
            g.drawString("Player 1 is the winner! Congratulations!", 120, 220);
            g.setColor(Color.red);
            g.drawLine(400,400,400,500);
            g.drawLine(400,400,500,400);
            g.drawString("Menu",430,440);
            win = true;
        } 
        
        if (win == false){
            g.setColor(Color.blue);
            g.drawString("Player 1", 210, 15);
            g.setColor(Color.red);
            g.drawString("Player 2", 210, 473);
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
            
            for (int i = 1; i <= p1; i++){
                if (i == 1){
                    g.drawImage(ChopUp,100,300,null);
                }
                if (i == 2){
                    g.drawImage(ChopUp,140,300,null);
                }
                if (i == 3){
                    g.drawImage(ChopUp,60,300,null);
                }
                if (i == 4){
                    g.drawImage(ChopUp,20,300,null);
                }
            }
            
            for (int i = 1; i <= p2; i++){
                if (i == 1){
                    g.drawImage(ChopUp,100 +250,300,null);
                }
                if (i == 2){
                    g.drawImage(ChopUp,140 +250,300,null);
                }
                if (i == 3){
                    g.drawImage(ChopUp,60 +250,300,null);
                }
                if (i == 4){
                    g.drawImage(ChopUp,20 +250,300,null);
                }
            }
            
            for (int i = 1; i <= p3; i++){
                if (i == 1){
                    g.drawImage(ChopDown,100,-200,null);
                }
                if (i == 2){
                    g.drawImage(ChopDown,140,-200,null);
                }
                if (i == 3){
                    g.drawImage(ChopDown,60,-200,null);
                }
                if (i == 4){
                    g.drawImage(ChopDown,20,-200,null);
                }
            }
            
            for (int i = 1; i <= p4; i++){
                if (i == 1){
                    g.drawImage(ChopDown,100 +250,-200,null);
                }
                if (i == 2){
                    g.drawImage(ChopDown,140 +250,-200,null);
                }
                if (i == 3){
                    g.drawImage(ChopDown,60 +250,-200,null);
                }
                if (i == 4){
                    g.drawImage(ChopDown,20 +250,-200,null);
                }
            }
            
        }
    }

    public void mouseClicked(MouseEvent me) {
       
    }

    public void mousePressed(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        if( win == false ){
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
            else if( mouseC % 4 == 1 && mouseY > 250){
                if (choice1 == p1 && mouseX > 250 && p2 == 0){
                    int t = p1 / 2;
                    p2 = t;
                    p1 = p1-t;
                    mouseC++;
                }
                else if(choice1 == p2 && mouseX < 250 && p1 == 0){
                    int t = p2 / 2;
                    p1 = t;
                    p2 = p2-t;
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
            else if( mouseC % 4 == 3 && mouseY < 250){
                if (choice1 == p3 && mouseX > 250 && p4 == 0){
                    int t = p3 / 2;
                    p4 = t;
                    p3 = p3-t;
                    mouseC++;
                }
                else if(choice1 == p4 && mouseX < 250 && p3 == 0){
                    int t = p4 / 2;
                    p3 = t;
                    p4 = p4-t;
                    mouseC++;
                }
            }
            repaint();
        }
        else if (win == true){
            if ( mouseX > 400 && mouseY > 400){
                String[]a = new String[0];
                GameMenu.main(a);
            }
        }
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