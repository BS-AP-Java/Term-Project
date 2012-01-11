package beta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Backbone extends JPanel implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {
	public static boolean running;
	protected Frame frame;
	private String msg;//string to hold words
	private JFrame f;
	
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
    	msg = "Press Esc to exit";
        //construct screen object
        frame = new Frame(this);
        f = frame.getFrame();
        //set font style, type, and size
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        //set background color to black
        this.setBackground(Color.BLACK);
        //set foreground color to white
        this.setForeground(Color.white);
        f.addKeyListener(this);
        f.addMouseListener(this);
        f.addMouseMotionListener(this);
        f.addMouseWheelListener(this);
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
		//set drawing color to background color
        g.setColor(this.getBackground());
        //draw a filled rectangle starting at position 0,0(upperleft corner) with width and height of screen
        g.fillRect(0, 0, f.getWidth(), f.getHeight());
        //change drawing color to foreground color
        g.setColor(this.getForeground());
        g.drawString(msg, 60, 60);
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(Frame.windowWidth, Frame.windowHeight);
     }
	
	/////////////////////////////////////INPUT METHODS////////////////////////////////////////////////
	
	//method to override keyPressed method in keylistener
    public void keyPressed(KeyEvent e) {
        //stores keycode value of key pressed
        int keyCode = e.getKeyCode();
        //check if the key code is equal to the escape key's keycode
        if(keyCode == KeyEvent.VK_ESCAPE) {
            //call the stop method inherited from the class core
            stop();
        } else if(keyCode == KeyEvent.VK_SPACE) {
        	Frame.fullScreen = !Frame.fullScreen;
    		frame.apply();
        } else {
            //print out what key the user pressed
            msg = "Pressed: " + KeyEvent.getKeyText(keyCode);
            //makes the program not wait for other buttons to be pressed and uses the key
            //example of when the program waits for other buttons is when you do Ctrl+Alt+Delete)
            e.consume();
        }
    }

    //method to override keyReleased method in keylistener
    public void keyReleased(KeyEvent e) {
        //get the key code of the key released
        int keyCode = e.getKeyCode();
        //print out what key the user pressed
        msg = "Released: " + KeyEvent.getKeyText(keyCode);
        //makes the program not wait for other buttons to be pressed and uses the key
        //example of when the program waits for other buttons is when you do Ctrl+Alt+Delete)
        e.consume();
    }

    //method to override keyTyped method in keylistener
    public void keyTyped(KeyEvent e) {
        //makes the program not wait for other buttons to be pressed and uses the key
        //example of when the program waits for other buttons is when you do Ctrl+Alt+Delete)
    	e.consume();
    }

    //mouse listener
    public void mousePressed(MouseEvent e) {
        //display message when mouse is pressed
        msg = "You pressed down the mouse";
    }

    public void mouseReleased(MouseEvent e) {
        //display message when mouse is released
        msg = "You released the mouse";
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    //mouse motion listener
    public void mouseDragged(MouseEvent e) {
        //display message when mouse is dragged
        msg = "You are dragging the mouse";
    }

    public void mouseMoved(MouseEvent e) {
        //display message when the mouse is moved
        msg = "You are moving the mouse";
    }

    //mouse wheel listener
    public void mouseWheelMoved(MouseWheelEvent e) {
        //display message when mouse wheel is moved
        msg = "You are moving the mouse wheel";
    }
	
}
