 

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Write a description of class TTT_Frame here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class TTT_Panel extends JPanel implements MouseListener, ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel panel;
	int mouseX, mouseY, ctr;
	private Timer timer;
	private ArrayList<Integer> boardXC, boardXX;
	private ArrayList<Integer> boardYC, boardYX;

	public TTT_Panel() {
		ctr = 0;
		mouseX = mouseY = 501;
		boardXC = new ArrayList<>();
		boardYC = new ArrayList<>();
		boardXX = new ArrayList<>();
		boardYX = new ArrayList<>();
		timer = new Timer(40, this);
		timer.start();
		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		setBackground(Color.lightGray);
		g.setColor(Color.red);
		int r = 3, c = 3;
		TTT ttt = new TTT();
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				g.fillRect(0, i * (h / 3) - 10, 500, 20);
				g.fillRect(j * (w / 3) - 10, 0, 20, 500);
			}
		}
		g.drawString("" + mouseX + " " + mouseY + " " + ctr, 200, 125);
		if (mouseX < 156 && mouseY < 146) {
			if (ctr % 2 == 0) {
				boardXC.add(0);
				boardYC.add(0);
			} else {
				boardXX.add(0);
				boardYX.add(0);
			}
		}
		if (mouseX < 500 && mouseX >= 337 && mouseY < 500 && mouseY >= 324) {
			if (ctr % 2 == 0) {
				boardXC.add(337);
				boardYC.add(324);
			} else {
				boardXX.add(337);
				boardYX.add(324);
			}
		}

		for (int i = 0; i < boardXC.size(); i++) {
			g.setColor(Color.blue);
			g.fillOval(boardXC.get(i), boardYC.get(i), 140, 140);

		}
		for (int i = 0; i < boardXX.size(); i++) {
			g.setColor(Color.red);
			g.fillRect(boardXX.get(i), boardYX.get(i), 140, 140);
		}

	}

	public void mouseClicked(MouseEvent me) {
		mouseX = me.getX();
		mouseY = me.getY();
		ctr++;
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {

	}

	public void mouseEntered(MouseEvent me) {

	}

	public void mouseExited(MouseEvent me) {

	}

	public void actionPerformed(ActionEvent ae) {
		repaint();
	}
}
