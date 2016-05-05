
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
    TTT ttt;
    public TTT_Panel() {
        ctr = 0;
        mouseX = mouseY = 501;
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
        ttt = new TTT();
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                g.fillRect(0, i * (h / 3) - 10, 500, 20);
                g.fillRect(j * (w / 3) - 10, 0, 20, 500);
            }
        }
        g.drawString("" + mouseX + " " + mouseY + " " + ctr, 200, 125);
        int[][] board = ttt.getBoard();
        if (mouseX < 156 && mouseY < 146) {
            if (ttt.getBoard(0,0) == 0 && ctr % 2 == 0) {
                ttt.setBoard(0,0,1);
            } 
            else {
                ttt.setBoard(0,0,2);
            }
        }
        if (ttt.getBoard(2,2) == 0 && mouseX < 500 && mouseX >= 337 && mouseY < 500 && mouseY >= 324) {
            if (ctr % 2 == 0) {
                ttt.setBoard(2,2,1);
            } else {
                ttt.setBoard(2,2,2);
            }
        }
        board = ttt.getBoard();
        for (int i = 0; i < ttt.getBoard().length; i++) {
            for (int j = 0; j < ttt.getBoard()[0].length; j++){
                if (ttt.getBoard(i,j) == 1){
                    g.setColor(Color.blue);
                    g.fillOval(i*500/3,j*500/3,140,140);
                }
                else if (ttt.getBoard(i,j) == 2){
                    g.setColor(Color.red);
                    g.fillRect(i*500/3,j*500/3,140,140);
                }
                System.out.print(ttt.getBoard(i,j) + " ");
            }
            System.out.println("");
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
