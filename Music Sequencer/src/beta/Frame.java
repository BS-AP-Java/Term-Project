//********************************************************************
//Frame.java      
//Author: Kwun Chan and Nanyou Guan
// Creates the frame for the GUI
// 
//********************************************************************
package beta;

//import necessary classes
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;


public class Frame {
	//declare the instance variables for the class
	public static boolean fullScreen;
	public static int windowWidth, windowHeight, windowX, windowY;
	public static JFrame jframe;
	Toolkit toolkit;
	Dimension dim;
	
	//the constructor for a Frame object
	public Frame(JLayeredPane pane) {
		//Create a new JFrame
		jframe = new JFrame();
		//set the window width to be 967 pixels
		windowWidth = 967;
		//set the window height to be 600 pixels
		windowHeight = 600;
		toolkit =  Toolkit.getDefaultToolkit();
		//get the size of the computer screen
		dim = toolkit.getScreenSize();
		//set the x coordinate of the top left corner of the window 
		//to the width of the computer screen minus the width of the frame and then divide by 2 
		windowX = (dim.width - windowWidth)/2;
		//set the y corodinate of the top left corner of the window to
		//the height of the computer screen minus the height of the frame and then divide by 2
		windowY = (dim.height - windowHeight)/2;
		//set the frame so it can not be resized
		jframe.setResizable(false);
		//when the frame is closed, the program stops running
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set the title of the frame to Music Sequencer
		jframe.setTitle("Music Sequencer");
		//set the content pane to a JLayeredPane
		jframe.setContentPane(pane);
		//sets the window to be sized to fit the preferred size and layouts
		jframe.pack();
		//set the size of the frame and the x,y coordinates of the top left corner
		jframe.setBounds(windowX, windowY, windowWidth, windowHeight);
		//set the frame so it can be seen
		jframe.setVisible(true);
		//Allow for double buffering
		jframe.createBufferStrategy(2);
	}
    
	/**********************************
    //Method Name: public JFrame getFrame()
    //Returns the current jFrame
    //
    *********************************/
    public JFrame getFrame() {
    	return jframe;
    }

}
