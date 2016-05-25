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
    private boolean animateRect= false;
    private int initialRectX = 100;
    private int initialRectY = 100;
    public AnimationsTest()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
        Timer timer = new Timer(40, this);
        timer.start();
    }

    public void paintComponent(Graphics g)
    {
        g.fillRect(rectX,rectY,100,100);
        repaint();
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
        if (animateRect)
        {
            if (initialRectX == 100 && initialRectY == 100)
            {
                if (rectX < 300)
                {
                    rectX+=5;
                }

                if (rectX == 300)
                {
                    animateRect = false;

                }
            }
            if (initialRectX == 300 && initialRectY == 100)
            {
                if (rectY < 300)
                {
                    rectY+=5;
                }
                if (rectY == 300)
                {
                    animateRect = false;

                }

            }
            if (initialRectX == 300 && initialRectY == 300)
            {
                if (rectX > 100)
                {
                    rectX-=5;
                }
                if (rectX == 100)
                {
                    animateRect = false;

                }
            }
            if (initialRectX == 100 && initialRectY == 300)
            {
                if (rectY > 100)
                {
                    rectY-=5;
                }
                if (rectY == 100)
                {
                    animateRect = false;
                }
            }
        }
    }

    //MouseListener
    public void mouseClicked(MouseEvent me) 
    {
        if (!animateRect)
        {
            if ((me.getX() >= rectX && me.getX() <= rectX+100) && (me.getY() >= rectY && me.getY() <= rectY+100))
            {
                initialRectX = rectX;
                initialRectY = rectY;
                animateRect = true;

            }
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

