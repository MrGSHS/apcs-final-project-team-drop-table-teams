 

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
public class RPS extends JPanel implements MouseListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int mouseX, mouseY;

    public RPS() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        setBackground(Color.blue);
        g.setColor(Color.red);
        BufferedImage userRock= null;
        BufferedImage userPaper=null;
        BufferedImage userScissors= null;
        BufferedImage compRock = null;
        BufferedImage compPaper = null;
        BufferedImage compScissors = null;
        try 
        {
            userRock = ImageIO.read(new File("Rock.png"));
            userPaper = ImageIO.read(new File("Paper.png"));
            userScissors = ImageIO.read(new File("Scissors.png"));
            compRock = ImageIO.read(new File("Rock.png"));
            compPaper = ImageIO.read(new File("Paper.png"));
            compScissors = ImageIO.read(new File("Scissors.png"));
        }
        catch (IOException e)
        {
            System.out.println("Image could not be read");
            System.exit(1);
        }
        g.drawImage(userRock,50,50,null); //userRock
        g.drawImage(userPaper,50,175,null); //userPaper
        g.drawImage(userScissors,50,300,null); //userScissors
        g.drawImage(compRock,375,50,null); //compRock
        g.drawImage(compPaper,375,175,null); //compPaper
        g.drawImage(compScissors,375,300,null); //compScissors
        
    }

    public void mouseClicked(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseReleased(MouseEvent me) {

    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }
}
