
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import java.io.*;
import java.util.*;


/**
 * The Hangman class contains everything necessary for the Hangman game - CURRENTLY IN BETA
 * 
 * @author Sanketh Bhaskar
 * @version 5/26/16
 */
public class Hangman extends JPanel implements MouseListener, ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int mouseX, mouseY;
    private boolean win = false;
    private int wrongL = 0;
    private String word = "Apple Tree";
    private String Wrongs = "";
    
    BufferedImage BackGround = null;
    public Hangman() {
        addMouseListener(this);
        try 
        {
            BackGround = ImageIO.read(new File("bg.jpg"));
        }
        catch (IOException e)
        {
            System.out.println("Image could not be read");
            System.exit(1);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        
        g.setColor(Color.black);
        
        g.drawLine(0,417,500,417);
        int ctr = 0;
        for(int i = 3; i < 500; i += 38){
            g.drawLine(i,350,i,500);
            
            
            
        }
        
        g.drawLine(10,210,60,210);
        g.drawLine(35,210,35,10);
        g.drawLine(35,10,105,10);
        g.drawLine(105,10,105,35);
        
        
        if(wrongL == 1){
            g.drawOval(80,35,50,50);
        }
        if(wrongL == 2){
            g.drawLine(105,85,105,135);
        }
        if(wrongL == 3){
            g.drawLine(105,90,85,120);
        }
        if(wrongL == 4){
            g.drawLine(105,90,125,120);
        }
        if(wrongL == 5){
            g.drawLine(105,135,125,165);
        }
        if(wrongL == 6){
            g.drawLine(105,135,85,165);
        }
    }

    public void mouseClicked(MouseEvent me) {
       
    }

    public void mousePressed(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        
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