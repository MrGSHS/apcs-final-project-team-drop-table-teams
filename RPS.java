
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
    private int userScore = 0;
    private int compScore = 0;
    private String result;
    private int iresult = 0;

    //images
    BufferedImage userRock= null;
    BufferedImage userRockHighlight = null;
    BufferedImage userPaper=null;
    BufferedImage userPaperHighlight = null;
    BufferedImage userScissors= null;
    BufferedImage userScissorsHighlight = null;
    BufferedImage compRock = null;
    BufferedImage compPaper = null;
    BufferedImage compScissors = null;

    public RPS() {
        addMouseListener(this);
        addMouseMotionListener(this);
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

    }

    public void paintComponent(Graphics g) {
        int rockLocX;
        int rockLocY;
        int paperLocX;
        int paperLocY;
        int scissorsLocX;
        int scissorsLocy;
        super.paintComponent(g);
        System.out.println("Paint");
        int w = getWidth();
        int h = getHeight();
        setBackground(new Color(0,255,225));
        /*
        BufferedImage userRock= null;
        BufferedImage userRockHighlight = null;
        BufferedImage userPaper=null;
        BufferedImage userPaperHighlight = null;
        BufferedImage userScissors= null;
        BufferedImage userScissorsHighlight = null;
        BufferedImage compRock = null;
        BufferedImage compPaper = null;
        BufferedImage compScissors = null;
         */


 
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
            choiceLogic(g);
        }
        g.setColor(Color.black);
        g.drawString("Player 1", 10, 20);
        g.drawString("Computer", 420, 20);
        g.drawString(""+userScore, 30, 40);
        g.drawString(""+compScore, 450, 40);

    }

    public void choiceLogic(Graphics g)
    {
        compChoice= (int)((Math.random())*3+1);
        if (userChoice == compChoice)
        { 
            result = "DRAW";
            iresult = 1;
        }
        if (userChoice == 1 && compChoice == 2)
        {
            result = "LOSE";
            iresult = 3;
        }
        if (userChoice == 1 && compChoice == 3)
        {
            result = "WIN";
            iresult = 2;
        }
        if (userChoice == 2 && compChoice == 1)
        {
            result = "WIN";
            iresult = 2;
        }
        if (userChoice == 2 && compChoice == 3)
        {
            result = "LOSE";
            iresult = 3;
        }
        if (userChoice == 3 && compChoice == 1)
        {
            result = "LOSE";
            iresult = 3;
        }
        if (userChoice == 3 && compChoice == 2)
        {
            result = "WIN";
            iresult = 2;
        }

        //Second Part
        if (userChoice == 1)
        {
            g.drawImage(userRock, 213 ,105, null);
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

        if (iresult == 1){
            g.drawString(result,235,20);
        }
        else if(iresult == 2){
            g.drawString(result,235,20);
            userScore++;
        }
        else if (iresult == 3){
            g.drawString(result,235, 20);
            compScore++;
        }

        if ( userScore == 2){
            g.drawString("YOU WIN",225, 420);
            g.setColor(Color.lightGray);
            g.fillRect(400,400,100,100);

            g.setColor(Color.red);
            g.drawLine(400,400,400,500);
            g.drawLine(400,400,500,400);
            g.drawString("Menu",430,440);
        }
        else if( compScore == 2){
            g.drawString("YOU LOSE",225, 420);
            g.setColor(Color.lightGray);
            g.fillRect(400,400,100,100);

            g.setColor(Color.red);
            g.drawLine(400,400,400,500);
            g.drawLine(400,400,500,400);
            g.drawString("Menu",430,440);
        }
        else{
            g.setColor(Color.red);
            g.setColor(Color.lightGray);
            g.fillRect(200,400,100,100);
            g.setColor(Color.red);
            g.drawRect(200,400,100,100);
            g.setColor(Color.black);
            g.drawString("Back",235,440);
            //choiceLogic(g);
        }            

        g.setColor(Color.black);
        g.drawString("Player 1", 10, 20);
        g.drawString("Computer", 420, 20);
        g.drawString(""+userScore, 30, 40);
        g.drawString(""+compScore, 450, 40);

    }

    public void highlightEffect()
    {

    }

    public void mouseClicked(MouseEvent me) {

    }

    public void mousePressed(MouseEvent me) {
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
        else if( me.getX() < 300 && me.getX() > 200 && me.getY() > 400){
            choiceMade = false;
            repaint();
        }
        else if(me.getX() > 400 && me.getY() > 400){
            String[]a = new String[0];
            GameMenu.main(a);
        }
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseMoved(MouseEvent me){
        if (!choiceMade){
            isHoveringOverRock = (me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 50 && me.getY() <= 157);
            isHoveringOverPaper = (me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 175 && me.getY() <= 279);
            isHoveringOverScissors  = (me.getX() >= 50 && me.getX() <= 121) && (me.getY() >= 300 && me.getY() <= 405);
            repaint();
        }
    }

    public void mouseDragged(MouseEvent me){
    }

}
