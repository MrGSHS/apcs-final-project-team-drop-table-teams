import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import java.io.*;
/**
 * Write a description of class AnimationsTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimationsTest extends JPanel implements MouseListener, MouseMotionListener, ActionListener
{
    private int rectX = 100;
    private int rectY = 100;
    private boolean animateRect = false;
    public AnimationsTest()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
        Timer timer = new Timer(30, this);
        timer.start();
    }

    public void paintComponent(Graphics g)
    {
        g.drawRect(rectX,rectY,100,100);
    }

    public static void main(String[] args)
    {
        AnimationsTest test = new AnimationsTest();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(test);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    //ActionListener
    public void actionPerformed(ActionEvent ae)
    {
        if (animateRock)
        {
            if (rectX <= 213)
            {
                rectX++;
            }
            if (rectY <= 105)
            {
                rectY++;
            }
            if (rectX == 214 && rectY == 106)
            {
                animateRock = false;
            }
        }
    }

    //MouseListener
    public void mouseClicked(MouseEvent me) 
    {
        if ((me.getX >= rectX && me.getX <= rectX+100) && (me.getY >= rectY && me.getY <= rectY+100))
        {
            animateRock = true;
        }
    }

    public void mousePressed(MouseEvent me)
    {

    }

    public void mouseReleased(MouseEvent me) 
    {

    }

    public void mouseEntered(MouseEvent me) 
    {

    }

    public void mouseExited(MouseEvent me) 
    {

    }

    //MouseMotionListener
    public void mouseMoved(MouseEvent me)
    {

    }

    public void mouseDragged(MouseEvent me)
    {

    }

}

