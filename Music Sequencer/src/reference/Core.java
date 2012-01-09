package reference;

import java.awt.*;
import javax.swing.*;
/**
 * class that has commonly used methods/functions
 * @author Nanyou
 */
public abstract class Core {

    //array of displaymodes
    public static DisplayMode modes[] = {
        new DisplayMode(800, 600, 32, 0),
        new DisplayMode(800, 600, 24, 0),
        new DisplayMode(800, 600, 16, 0),
        new DisplayMode(640, 480, 32, 0),
        new DisplayMode(640, 480, 24, 0),
        new DisplayMode(640, 480, 16, 0),
    };

    //boolean used for checking if game is running
    private boolean running;
    //screen object
    protected FullScreen screen;

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
            //call the gameLoop method
            mainLoop();
        } finally {
            //removes full screen and restores screen back to normal
            //screen.restoreScreen();
        	System.exit(0);
        }
    }

    //sets up screen
    public void init() {
        //construct screen object
        screen = new FullScreen();
        //find compatible screen mode and store it in dm
        DisplayMode dm = screen.findFirstCompatibleMode(modes);
        //set to full screen
        screen.setFullScreen(dm);
        //gets the full screen window and stores it in w
        //Window w = screen.getFullScreenWindow();
        //set font style, type, and size
        FullScreen.frame.setFont(new Font("Arial", Font.PLAIN, 20));
        //set background color to black
        FullScreen.frame.setBackground(Color.BLACK);
        //set foreground color to white
        FullScreen.frame.setForeground(Color.white);
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
            Graphics2D g = screen.getGraphics();
            //paint graphics
            paint(g);
            //dispose of graphic object
            g.dispose();
            //update screen
            screen.update();
            try {
                Thread.sleep(20);
            } catch(Exception ex) {

            }
        }
    }

    //update animation
    public void update(long timePassed) {

    }

    //paints graphics(pictures/images)
    public void paint(Graphics2D g) {

    }

}
