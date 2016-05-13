
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
    private int compChoice;

    public RPS() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        setBackground(new Color(0,255,225));
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
        if (!choiceMade)
        {
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
        }
        else
        {
            if (userChoice == 1)
            {
                int x = 50;
                int y = 50;
                while (x<=213 && y<=105)
                {
                    g.drawImage(userRock, x , y, null);
                    x++;
                    y++;
                }
            }
            if (userChoice == 2)
            {
                g.drawImage(userPaper, 213 ,105, null);
            }
            if (userChoice == 3)
            {
                g.drawImage(userScissors, 213 ,105, null);
            }
            if (compChoice == 1)
            {
                g.drawImage(userRock, 213, 250, null);
            }
            if (compChoice == 2)
            {
                g.drawImage(userPaper, 213, 250, null);
            }
            if (compChoice == 3)
            {
                g.drawImage(userScissors, 213, 250, null);
            }

        }

    }
    public void choiceLogic()
    {
        //choice 1 is rock
        //choice 2 is paper
        //choice 3 is scissors

        System.out.println("User choice: " + userChoice);
        compChoice= (int)((Math.random())*3+1);
        System.out.println("Computer choice: " + compChoice);

        if (userChoice == compChoice)
        { 
            System.out.println("DRAW");
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

        repaint();

    }

    public void highlightEffect()
    {

    }

    public void mouseClicked(MouseEvent me) {
        if (!choiceMade)
        {
            if ((me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 50 && me.getY() <= 157))
            {
                userChoice = 1;
            }
            if ((me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 175 && me.getY() <= 279))
            {
                userChoice = 2;
            }
            if ((me.getX() >= 50 && me.getX() <= 121) && (me.getY() >= 300 && me.getY() <= 405))
            {
                userChoice = 3;
            }
            choiceMade = true;
            choiceLogic();

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
