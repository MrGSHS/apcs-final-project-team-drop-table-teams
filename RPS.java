import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import java.io.*;

/**
 * The RPS class contains everything necessary for the RPS game
 *
 * @author (Danny Attia
 * @version 5/26/16
 */

public class RPS extends JPanel implements MouseListener, MouseMotionListener, ActionListener{

    /**
     *
     */
    
    //coordinates of the user rock, paper, and scissors (left side)
    private double userRockX = 50;
    private double userRockY = 50;
    private double userPaperX = 50;
    private double userPaperY = 175;
    private double userScissorsX = 50;
    private double userScissorsY = 300;

    //coordinates of the computer rock, paper, and scissors (right side)
    private double compRockX = 375;
    private double compRockY = 50;
    private double compPaperX = 375;
    private double compPaperY = 175;
    private double compScissorsX = 375;
    private double compScissorsY = 300;

    //booleans for hover highlight effect
    private boolean isHoveringOverRock = false;
    private boolean isHoveringOverPaper = false;
    private boolean isHoveringOverScissors = false;
    
    //choice variables 
    private int userChoice = 0;
    private int compChoice = 0;
    
    //scores
    private int userScore = 0;
    private int compScore = 0;
    
    //result (win, loss, or draw) in string form and in int form
    private String result;
    private int iresult = 0;
    
    //progression booleans
    private boolean choiceMade = false;
    private boolean scoreUpdated = false;
    private boolean userAnimationFinished = false;
    private boolean compAnimationFinished = false;

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

        //listeners
        addMouseListener(this);
        addMouseMotionListener(this);

        //images
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
        
        //timer for animations
        Timer timer = new Timer(5, this);
        timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0,255,225));
     
        //draw user rock, paper, and scissors (left side) and highlight effect
        if(userChoice !=1){
            if (!isHoveringOverRock)
                g.drawImage(userRock,50,50, null); //userRock
            else
                g.drawImage(userRockHighlight,50,50,null);
        }
        if(userChoice != 2) {
            if (!isHoveringOverPaper)
                g.drawImage(userPaper,50,175,null);
            else
                g.drawImage(userPaperHighlight,50,175,null);
        }
        if(userChoice !=3) {
            if (!isHoveringOverScissors)
                g.drawImage(userScissors,50,300,null); //userScissors
            else
                g.drawImage(userScissorsHighlight,50,300,null);
        }
        
        //draw computer rock, paper, and scissors
        if (compChoice !=1)
        {
            g.drawImage(compRock,375,50,null); //compRock
        }
        if (compChoice !=2)
        {
            g.drawImage(compPaper,375,175,null); //compPaper
        }
        if (compChoice !=3)
        {
            g.drawImage(compScissors,375,300,null); //compScissors
        }

        //animations for user rock, paper, and scissors
        if(choiceMade) {
            if (userChoice == 1)
            {
                g.drawImage(userRock,(int)userRockX,(int)userRockY,null);
                if (userRockX < 212 && userRockY < 105)
                {
                    userRockX+=9;
                    userRockY+=3;
                }

                else
                {
                    userAnimationFinished = true;
                }

            }
            if (userChoice == 2)
            {
                g.drawImage(userPaper,(int)userPaperX,(int)userPaperY,null);
                if (userPaperX < 212 && userPaperY > 105)
                {
                    userPaperX+=9;
                    userPaperY-=3.86;
                }

                else
                {
                    userAnimationFinished = true;
                }
            }
            if (userChoice == 3)
            {
                g.drawImage(userScissors,(int)userScissorsX,(int)userScissorsY,null);
                if (userScissorsX < 212 && userPaperY > 105)
                {
                    userScissorsX+=9;
                    userScissorsY-=10.7;
                }
                else
                {
                    userAnimationFinished = true;
                }
            }
            
            //animations for computer rock, paper, and scissors
            if (compChoice == 1)
            {
                g.drawImage(compRock, (int)compRockX, (int)compRockY, null);
                if (compRockX > 212 && compRockY < 247)
                {
                    compRockX-=9;
                    compRockY+=11.04;
                }
                else
                {
                    compAnimationFinished = true;
                }
            }
            if (compChoice == 2)
            {
                g.drawImage(userPaper, (int)compPaperX, (int)compPaperY, null);
                if (compPaperX > 212 && compPaperY < 249)
                {
                    compPaperX-=9;
                    compPaperY+=4.15;
                }
                else
                {
                    compAnimationFinished = true;
                }
            }
            if (compChoice == 3)
            {
                g.drawImage(userScissors, (int)compScissorsX, (int)compScissorsY, null);
                if (compScissorsX > 212 && compScissorsY > 252)
                {
                    compScissorsX-=9;
                    compScissorsY-=2.76;
                }
                else
                {
                    compAnimationFinished = true;
                }
            }

            //determine outcome
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

            //post animations
            if (userAnimationFinished && compAnimationFinished)
            {
                //back button
                g.setColor(Color.lightGray);
                g.fillRect(200,400,100,100);
                g.setColor(Color.red);
                g.drawRect(200,400,100,100);
                g.setColor(Color.black);
                g.drawString("Back",235,440);
                
                //text that displays "WIN", "LOSS", or "DRAW"
                g.drawString(result,230,20);
                
                //update score
                if (!scoreUpdated)
                {
                    if (iresult == 1)
                    {
                    }
                    else if(iresult == 2){
                        userScore++;
                    }
                    else if (iresult == 3){
                        compScore++;
                    }
                    scoreUpdated = true;
                }
            }
        }
        
        //menu button
        g.setColor(Color.lightGray);
        g.fillRect(400,425,100,100);
        g.setColor(Color.red);
        g.drawRect(400,425,100,100);
        g.setColor(Color.black);
        g.drawString("Menu", 430, 450);
        
        
        
        g.setColor(Color.black);
        
        //user's score in upper left
        g.drawString("Player 1", 65, 20);
        g.drawString(""+userScore, 85, 40);
        
        //computer's score in upper right
        g.drawString("Computer", 385, 20);
        g.drawString(""+compScore, 412, 40);
        
        
    }

   
    public void actionPerformed(ActionEvent ae)
    {
       //repaint() needs to be in actionPerformed so it will repaint correspondingly with the timer
       repaint();
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        if (!choiceMade)
        {
            //determining which choice the user clicked on 
            if ((me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 50 && me.getY() <= 157))
            {
                userChoice = 1;
                compChoice= (int)((Math.random())*3+1);
                choiceMade = true;

            }
            if ((me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 175 && me.getY() <= 279))
            {
                userChoice = 2;
                compChoice= (int)((Math.random())*3+1);
                choiceMade = true;
            }
            if ((me.getX() >= 50 && me.getX() <= 121) && (me.getY() >= 300 && me.getY() <= 405))
            {
                userChoice = 3;
                compChoice= (int)((Math.random())*3+1);
                choiceMade = true;
            }
        }
        
        //if back button clicked - a bunch of things get reset because game essentially restarts
        else if( me.getX() < 300 && me.getX() > 200 && me.getY() > 400){
            choiceMade = false;
            scoreUpdated = false;
            userAnimationFinished = false;
            compAnimationFinished = false;
            userChoice = 0;
            compChoice = 0;
            userRockX = 50;
            userRockY = 50;
            userPaperX = 50;
            userPaperY = 175;
            userScissorsX = 50;
            userScissorsY = 300;
            compRockX = 375;
            compRockY = 50;
            compPaperX = 375;
            compPaperY = 175;
            compScissorsX = 375;
            compScissorsY = 300;
        }
        
        //menu button
        if((me.getX() >= 400 && me.getX() <=500) && (me.getY() >= 400 && me.getY() <= 500)){
            GameMenu.main(new String[0]);
        }

    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseMoved(MouseEvent me){
        //assigns booleans that handle the hover effect
        if (!choiceMade){
            isHoveringOverRock = (me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 50 && me.getY() <= 157);
            isHoveringOverPaper = (me.getX() >= 50 && me.getX() <= 125) && (me.getY() >= 175 && me.getY() <= 279);
            isHoveringOverScissors  = (me.getX() >= 50 && me.getX() <= 121) && (me.getY() >= 300 && me.getY() <= 405);

        }
    }

    public void mouseDragged(MouseEvent me){
    }

    //main method - makes it able to be run without game menu
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        RPS rps = new RPS();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(rps);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

}