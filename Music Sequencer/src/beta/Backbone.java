package beta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Backbone extends JPanel {
	public static boolean running;
	protected Frame frame;
	
	//method to stop the program
    public void stop() {
        //set running to false
        running = false;
    }

    //method that calls init and gameLoop while program is running
    public void run() {
        try {
            //call the init method
            init();
            //call the mainLoop method
            mainLoop();
        } finally {
        	if(Frame.fullScreen == true) {
            //removes full screen and restores screen back to normal
            frame.restoreScreen();
        	} else {
        		
        	}
        }
    }

    //sets up screen
    public void init() {
        //construct screen object
        frame = new Frame(this);
        //find compatible screen mode and store it in dm
        //DisplayMode dm = frame.getCurrentDisplayMode();
        //set to full screen
        //frame.setFullScreen(dm);
        //gets the full screen window and stores it in w
        JFrame f = frame.getFrame();
        //set font style, type, and size
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        //set background color to black
        this.setBackground(Color.BLACK);
        //set foreground color to white
        this.setForeground(Color.white);
        running = true;
    }

    //main loop that keeps program running
    public void mainLoop() {
        //get the current time when program starts
        long startTime = System.currentTimeMillis();
        //set runTime's starting time to startTime
        long runTime = startTime;
        //check if program is running
        while(running) {
            //calculate amount of time passed since program started
            long timePassed = System.currentTimeMillis() - runTime;
            //add the amount of time passed to runTime
            runTime += timePassed;
            //call update method
            update(timePassed);
            //get graphics object from the screen and store it in g
            //Graphics2D g = (Graphics2D)this.getGraphics();
            //paint graphics
            this.repaint();
            //dispose of graphic object
            //g.dispose();
            //update screen
            //frame.update();
            try {
                Thread.sleep(20);
            } catch(Exception ex) {

            }
        }
    }

    //update animation
    public void update(long timePassed) {
    	
    }

    /**
    //paints graphics(pictures/images)
    public void paint(Graphics2D g) {
    	
    }
    **/
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(Frame.windowWidth, Frame.windowHeight);
     }
	
}
