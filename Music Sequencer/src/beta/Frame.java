package beta;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;


public class Frame {
	public static boolean fullScreen;
	public static int windowWidth, windowHeight, windowX, windowY;
	public static JFrame jframe;
	Toolkit toolkit;
	Dimension dim;
	
	public Frame(JLayeredPane pane) {
		jframe = new JFrame();
		fullScreen = false;
		windowWidth = 967;
		windowHeight = 600;
		toolkit =  Toolkit.getDefaultToolkit();
		dim = toolkit.getScreenSize();
		windowX = (dim.width - windowWidth)/2;
		windowY = (dim.height - windowHeight)/2;
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setTitle("Music Sequencer");
		jframe.setContentPane(pane);
		jframe.pack();
		jframe.setBounds(windowX, windowY, windowWidth, windowHeight);
		jframe.setVisible(true);
		jframe.createBufferStrategy(2);
	}
    
    public JFrame getFrame() {
    	return jframe;
    }

}
