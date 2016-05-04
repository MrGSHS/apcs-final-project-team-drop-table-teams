import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class TTT_Frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chopsticks_Panel extends JPanel implements MouseListener
{
    int mouseX, mouseY;
    public Chopsticks_Panel()
    {

    }

    public void paintComponent(Graphics g)
    {
        addMouseListener(this);

        super.paintComponent(g);
        int w= getWidth();
        int h= getHeight();
        setBackground(Color.lightGray);
        g.setColor(Color.red);
        
        int r = 3, c = 3;
        TTT tic = new TTT();
        for (int i = 1; i < r; i++){
            for (int j = 1; j < c; j++){
                g.fillRect(0,i*(h/3)-10,500,20);
                g.fillRect(j*(w/3)-10,0,20,500);
            }
        }
        g.drawString(""+mouseX+" "+mouseY,200,150);
    }

    public void mouseClicked(MouseEvent me)
    {
        mouseX = me.getX();
        mouseY = me.getY();
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
}
