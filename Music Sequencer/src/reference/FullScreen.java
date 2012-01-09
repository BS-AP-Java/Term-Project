package reference;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
/**
 *
 * @author Nanyou
 * display mode = resolution height, resolution width, bit depth, refresh rate
 */
public class FullScreen {

    //creates an interface to access computer's video card
    private GraphicsDevice videoCard;
    public static JFrame frame = new JFrame();

    //method that gives the GraphicsDevice access to the monitor screen
    public FullScreen() {

        //get the computer's graphics card
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

        /**
         * set the the graphics interface to the default screen device
         * a.k.a the monitor screen
         */
        videoCard = env.getDefaultScreenDevice();
    }

    //function that gets all display modes of the user's graphics card
    public DisplayMode[] getCompatibleDisplayModes() {
        return videoCard.getDisplayModes();
    }

    /**
     * function that compares display modes of graphics card to program
     * @param modes = list of display modes we defined
     * @return = returns matching display modes
     */
    public DisplayMode findFirstCompatibleMode(DisplayMode modes[]) {
        //create a new list to hold all of the good graphics card display modes
        DisplayMode goodModes[] = videoCard.getDisplayModes();
        //loop through all the modes passed in
        for(int x = 0; x < modes.length; x++) {
            //loop through graphics card modes
            for(int y = 0; y < goodModes.length; y++) {
                //check if graphics card display modes match the ones we defined
                if(displayModesMatch(modes[x], goodModes[y])) {
                    //return the matching display mode
                    return modes[x];
                }
            }
        }
        //return null if there are no matching display modes
        return null;
    }

    //function to get and return current display mode
    public DisplayMode getCurrentDisplayMode() {
        return videoCard.getDisplayMode();
    }

    //function taht checks if two display modes match each other
    public boolean displayModesMatch(DisplayMode m1, DisplayMode m2) {
        //check if the the display mode resolution width and height matches
        if(m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()) {
            //if they don't match, return false
            return false;
        }
        //check if the display mode bit depth matches
        if(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()) {
            //if they don't match, return false
            return false;
        }
        //check if the display mode refresh rate matches
        if(m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()) {
            //if they don't match, return false
            return false;
        }
        //if the modes match, return true
        return true;
    }

    /**
     * Makes a full screen JFrame
     * @param dm = monitor settings & it takes 4 parameters
     * -2 for resolution represented by x,y
     * -bitDepth(how many colors it can store)
     * -refresh rate(rate of screen refresh)
     * @param window =  window converted into a full screen
     */
    public void setFullScreen(DisplayMode dm) {

        //create a new frame
        //JFrame frame = new JFrame();
        
        /**
         * gets rid of title bars, scroll bars, etc.
         * leaving just the window
         */
        //frame.setUndecorated(true);

        //make window unresizable
        //frame.setResizable(false);

        //frame.setIgnoreRepaint(true);

        /**
         * the graphic interface sets the specified JFrame to full screen
         * in this case it is the JFrame named frame
         */
        //videoCard.setFullScreenWindow(frame);

        /**
         * check if the monitor has settings
         * and if the computer's video card can change display
         * then it sets the display mode settings
         */
        //if(dm != null && videoCard.isDisplayChangeSupported()) {
            //try {
                //videoCard.setDisplayMode(dm);
            //} catch(Exception ex) {

            //}
        //}
        
        frame.setUndecorated(false);
        frame.setResizable(true);
        frame.setIgnoreRepaint(true);
        frame.setSize(800, 600);
        frame.setVisible(true);
        //create two seperate buffers to draw on
        frame.createBufferStrategy(2);
    }

    //this function will set the graphics object to equal to whatever this method returns
    public Graphics2D getGraphics() {
        /**
    	Window w = videoCard.getFullScreenWindow();
        //check if there is a full screen window
        if(w != null) {
            //set BufferStrategy object s to the buffer strategy of the full screen window
            BufferStrategy s = w.getBufferStrategy();
            //set the object drawing the graphics in s and return it as a Graphics2D object
            return(Graphics2D)s.getDrawGraphics();
        } else {
            return null;
        }
        **/
    	BufferStrategy s = frame.getBufferStrategy();
    	return(Graphics2D)s.getDrawGraphics();
    }

    //method to update display
    public void update() {
    	/**
        Window w = videoCard.getFullScreenWindow();
        //check if there is a full screen window
        if(w != null) {
            //set BufferStrategy object s to the buffer strategy of the full screen window
            BufferStrategy s = w.getBufferStrategy();
            //check if the there is content in the full screen window
            if(!s.contentsLost()) {
                //if there is content, show it on the full screen window
                s.show();
            }
        }
        **/
    	BufferStrategy s = FullScreen.frame.getBufferStrategy();
        //check if the there is content in the full screen window
        if(!s.contentsLost()) {
            //if there is content, show it on the full screen window
            s.show();
        }
    }

    /**
     * function to return the full screen window
     * @return
     */
    public Window getFullScreenWindow() {
        return videoCard.getFullScreenWindow();
    }

    //method to get width of window
    public int getWidth() {
    	/**
        //set window object w to the full screen window
        Window w = videoCard.getFullScreenWindow();
        //check if there is a full screen window
        if(w != null) {
            //return the width of the window
            return w.getWidth();
        } else {
            //return 0 if there is nothing
            return 0;
        }
        **/
    	return FullScreen.frame.getWidth();
    }

    //method to get hieght of window
    public int getHeight() {
    	/**
        //set window object w to the full screen window
        Window w = videoCard.getFullScreenWindow();
        //check if there is a full screen window
        if(w != null) {
            //return the width of the window
            return w.getHeight();
        } else {
            //return 0 if there is nothing
            return 0;
        }
        **/
    	return FullScreen.frame.getHeight();
    }

    /**
     * method to set screen back to normal
     */
    public void restoreScreen() {

        //gets the full screen window
        Window w = videoCard.getFullScreenWindow();
        //check if there is a full screen window
        if(w != null) {
            //dispose the window(freezes resources for garbage collecting)
            w.dispose();
        }
        //makes the window not full screen
        videoCard.setFullScreenWindow(null);
    }

    //function to create image that is compatible with monitor settings
    public BufferedImage createCompatibleImage(int width, int height, int transparency) {
        //gets the full screen window and store it in window
        Window window = videoCard.getFullScreenWindow();
        //check if there is a full screen window
        if(window != null) {
            //gets the graphics configuration of the window and store it in gc
            GraphicsConfiguration gc = window.getGraphicsConfiguration();
            //returns a compatible image based on graphics settings
            return gc.createCompatibleImage(width, height, transparency);
        }
        //return null if there is nothing
        return null;
    }
}
