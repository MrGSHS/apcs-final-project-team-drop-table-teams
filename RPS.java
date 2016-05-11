
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

public class RPS extends JPanel implements MouseListener, MouseMotionListener{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int mouseX, mouseY;

    private boolean isHoveringOverRock = false;
    private boolean isHoveringOverPaper = false;
    private boolean isHoveringOverScissors = false;
    private boolean choiceMade = false;
    private int userChoice;

    public RPS() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        setBackground(Color.blue);
        g.setColor(Color.red);
        BufferedImage userRock= null;
        BufferedImage userRockHighlight = null;
        BufferedImage userPaper=null;
        BufferedImage userPaperHighlight = null;
        BufferedImage userScissors= null;
        BufferedImage userScissorsHighlight = null;
        BufferedImage compRock = null;
        BufferedImage compPaper = null;
        BufferedImage compScissors = null;

        try 
        {
            userRock = ImageIO.read(new File("Rock.png"));
            userRockHighlight = ImageIO.read(new File("highlightedRock.png"));
            userPaper = ImageIO.read(new File("Paper.png"));
            userPaperHighlight = ImageIO.read(new File("highlightedPaper.png"));
            userScissors = ImageIO.read(new File("Scissors.png"));
            userScissorsHighlight = ImageIO.read(new File("highlightedScissors.png"));
            compRock = ImageIO.read(new File("Rock.png"));
            compPaper = ImageIO.read(new File("Paper.png"));
            compScissors = ImageIO.read(new File("Scissors.png"));
        }
        catch (IOException e)
        {
            System.out.println("Image could not be read");
            System.exit(1);
        }
        if (!isHoveringOverRock)
            g.drawImage(userRock,50,50,null); //userRock
        else
            g.drawImage(userRockHighlight,50,50,null);
        if (!isHoveringOverPaper)
            g.drawImage(userPaper,50,175,null); 
        else
            g.drawImage(userPaperHighlight,50,175,null);
        if (!isHoveringOverScissors)
            g.drawImage(userScissors,50,300,null); //userScissors
        else
            g.drawImage(userScissorsHighlight,50,300,null);

        g.drawImage(compRock,375,50,null); //compRock
        g.drawImage(compPaper,375,175,null); //compPaper
        g.drawImage(compScissors,375,300,null); //compScissors
        
        //choice 1 is rock
        //choice 2 is paper
        //choice 3 is scissors
        if (choiceMade)
        {
            System.out.println("User choice: " + userChoice);
            int compChoice= (int)((Math.random())*3+1);
            System.out.println("Computer choice: " + compChoice);
            choiceMade = false;
            if (userChoice == compChoice)
            { 
            }
            if (userChoice == 1 && compChoice == 2)
            {
                System.out.println("LOSE");
            }
            if (userChoice == 1 && compChoice == 3)
            {
                System.out.println("WIN");
            }
            if (userChoice == 2 && compChoice == 1)
            {
                System.out.println("WIN");
            }
            if (userChoice == 2 && compChoice == 3)
            {
                System.out.println("LOSE");
            }
            if (userChoice == 3 && compChoice == 1)
            {
                System.out.println("LOSE");
            }
            if (userChoice == 3 && compChoice == 2)
            {
                System.out.println("WIN");
            }
                
                
            
        }
        
    }

    public void mouseClicked(MouseEvent me) {
        if (!choiceMade)
        {
            if ((me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 50 && me.getY() <= 157))
            {
                userChoice = 1;
                choiceMade = true;
            }
            if ((me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 175 && me.getY() <= 279))
            {
                userChoice = 2;
                choiceMade = true;
            }
            if ((me.getX() >= 50 && me.getX() <= 121) && (me.getY() >= 300 && me.getY() <= 405))
            {
                userChoice = 3;
                choiceMade = true;
            }
            repaint();
        }
    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseReleased(MouseEvent me) {

    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }

    public void mouseMoved(MouseEvent me){
        isHoveringOverRock = (me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 50 && me.getY() <= 157);
        isHoveringOverPaper = (me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 175 && me.getY() <= 279);
        isHoveringOverScissors  = (me.getX() >= 50 && me.getX() <= 121) && (me.getY() >= 300 && me.getY() <= 405);
        repaint();
    }

    public void mouseDragged(MouseEvent me){
    }

}
