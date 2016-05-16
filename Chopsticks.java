 
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
    private int mouseX, mouseY;
    private int mouseC = 0;
    private boolean win = false;
    private int choice1 = 0;
    private int p1 = 1;
    private int p2 = 1;
    private int p3 = 1;
    private int p4 = 1;  
    public Chopsticks() {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        
        BufferedImage ChopUp = null;
        BufferedImage ChopDown = null;
        BufferedImage ChopWin = null;
        BufferedImage P1Win = null;
        BufferedImage P2Win = null;
        BufferedImage BackGround = null;
        try 
        {
            ChopUp = ImageIO.read(new File("c2.png"));
            ChopDown = ImageIO.read(new File("c1.png"));
            ChopWin = ImageIO.read(new File("chopsticks.png"));
            P1Win = ImageIO.read(new File("p1win.png"));
            P2Win = ImageIO.read(new File("p2win.png"));
            BackGround = ImageIO.read(new File("bg.jpg"));
        }
        catch (IOException e)
        {
            System.out.println("Image could not be read");
            System.exit(1);
        }
        
        g.drawImage(BackGround,0,0, null);
        
        if((p3 == 0 && p4 == 0)){
            g.drawImage(ChopWin,10, 40, null);
            g.setColor(Color.blue);
            g.drawImage(P1Win,-180, 200, null);
            
            g.setColor(Color.lightGray);
            g.fillRect(400,400,100,100);
            
            g.setColor(Color.red);
            g.drawLine(400,400,400,500);
            g.drawLine(400,400,500,400);
            g.drawString("Menu",430,440);
            win = true;
        } 
        else if((p1 == 0 && p2 == 0)){
            g.drawImage(ChopWin,10, 40, null);
            g.setColor(Color.blue);
            g.drawImage(P2Win,-180, 200, null);
            
            g.setColor(Color.white);
            g.fillRect(400,400,100,100);
            
            g.setColor(Color.red);
            g.drawLine(400,400,400,500);
            g.drawLine(400,400,500,400);
            g.drawString("Menu",430,440);
            win = true;
        } 
        
        if (win == false){
            
            
            g.setColor(Color.white);
            g.fillRect(200,10,70,30);
            g.setColor(Color.blue);
            g.drawRect(200,10,70,30);
            g.drawString("Player 1", 210, 30);
            
            g.setColor(Color.white);
            g.fillRect(200,438,70,30);
            g.setColor(Color.red);
            g.drawRect(200,438,70,30);
            g.drawString("Player 2", 210, 458);
            g.setColor(Color.white);
            
            if( mouseC % 4 == 0 ){
                g.fillRect(140,210,190,30);
                g.setColor(Color.black);
                g.drawRect(140,210,190,30);
                g.drawString("Player 1 choose your hand", 150, 230);
            }
            else if( mouseC % 4 == 1 ){
                g.fillRect(140,210,220,30);
                g.setColor(Color.black);
                g.drawRect(140,210,220,30);
                g.drawString("Player 1 choose opponent's hand", 150, 230);
            }
            else if( mouseC % 4 == 2 ){
                g.fillRect(140,210,190,30);
                g.setColor(Color.black);
                g.drawRect(140,210,190,30);
                g.drawString("Player 2 choose your hand", 150, 230);
            }
            else if( mouseC % 4 == 3 ){
                g.fillRect(140,210,220,30);
                g.setColor(Color.black);
                g.drawRect(140,210,220,30);
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