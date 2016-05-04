 

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class TTT_Frame here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class RPS_Panel extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int mouseX, mouseY;

	public RPS_Panel() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		setBackground(Color.lightGray);
		g.setColor(Color.red);
		RPS rps = new RPS();
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
