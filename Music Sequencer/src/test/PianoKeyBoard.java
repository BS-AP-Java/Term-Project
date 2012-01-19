package test;
import javax.swing.*;
import java.awt.Color;

public class PianoKeyBoard {
	public static void main(String[] args) {

	    JFrame frame = new JFrame("Test");

	    JLayeredPane panel = new JLayeredPane();
	    frame.add(panel);

	    int maxKeys = 8;

	    int width = 60;
	    int height = 240;
	    
	    int width2 = 48;
	    int height2 = 140;
	    for (int i = 0; i < maxKeys; i++) {
	        int j = i % 7;
	        if (j == 2 || j == 6)
	            continue;

	        JButton b = new JButton();
	        b.setBackground(Color.BLACK);
	        b.setLocation(i*(width) + (width2*3/4), 0);
	        b.setSize(width2, height2);

	        panel.add(b, 1, -1);
	    }

	    for (int i = 0; i < maxKeys; i++) {
	        JButton b = new JButton();
	        b.setBackground(Color.WHITE);
	        b.setLocation(i * width, 0);
	        b.setSize(width, height);

	        panel.add(b, 0, -1);
	    }

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500,280);
	    frame.setVisible(true);
	    }

}
