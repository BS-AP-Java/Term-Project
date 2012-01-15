package app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
/**
 *
 * @author Nanyou
 */
public class Look extends Core implements MouseMotionListener, KeyListener {

    public static void main(String[] args) {
        new Look().run();
    }

    private Image bg;//stores background image in bg
    private Robot robot;//robot used to move mouse automatically too look around
    private Point mouse;//location point of the mouse
    private Point center;//location point of center of screen
    private Point image;//location point of image
    private boolean centering;//used to check if mouse is being centered to center of screen

    //init
    public void init() {
        //inherit from init method in core class
        super.init();
        //construct mouse variable as a point
        mouse = new Point();
        //construct center variable as a point
        center = new Point();
        //construct image variable as a point
        image = new Point();
        //set centering to false
        centering = false;

        try {
            //construct the robot
            robot = new Robot();
            //call the recenterMouse method
            recenterMouse();
            //set mouse's x value to screen's center x value
            mouse.x = center.x;
            //set mouse's y value to screen's center y value
            mouse.y = center.y;
        } catch(Exception ex) {
            //print out a message when there is an exception saying it was in exception 1(this excpetion is first so it is 1)
            System.out.println("Exception 1");
        }
        //get full screen window and store in w
        Window w = screen.getFullScreenWindow();
        //add mouse motion listener to the window
        w.addMouseMotionListener(this);
        //add key listener to the window
        w.addKeyListener(this);
        //get and store an image into bg
        bg = new ImageIcon("C:\\Users\\Nanyou\\Desktop\\game\\sprites\\maps\\Nanuk.jpg").getImage();
    }

    //paint method
    public synchronized void paint(Graphics2D g) {
        //construct and store screen width in variable width
        int width = screen.getWidth();
        //construct and store screen height in variable height
        int height = screen.getHeight();
        //calculate how much bigger or smaller the image's width is compared to the screen's width
        //then places the image at the x position value of what ever the remainder of the calculation is
        image.x %= width;
        //calculate how much bigger or smaller the image's height is compared to the screen's height
        //then places the image at the y position value of what ever the remainder of the calculation is
        image.y %= height;
        //check if image's location is negative(offscreen) and then makes it positive(onscreen)
        if(image.x < 0) {
            //change x value to positive so it reappears on the right
            image.x += width;
        }
        //check if image's location is negative(offscreen) and then makes it positive(onscreen)
        if(image.y < 0) {
            //change the y value to positive so it reappears on the bottom
            image.y += height;
        }
        //construct and set x value to image's x postion value
        int x = image.x;
        //construct and set y value to image's y position value
        int y = image.y;
        //draw image on main screen
        g.drawImage(bg, x, y, null);
        //draw a copy of the image to the left of main screen
        g.drawImage(bg, x-width, y, null);
        //draw copy of the image above the main screen
        g.drawImage(bg, x, y-height, null);
        //draw copy of image diagonally(left and above) of main screen
        g.drawImage(bg, x-width, y-height, null);
    }

    //method to recenter the mouse using the robot
    private synchronized void recenterMouse() {
        //get the full screen window and store it in w
        Window w = screen.getFullScreenWindow();
        //check if robot is set to something and if the window is showing
        if(robot != null && w.isShowing()) {
            //set center x value to half of width of screen(a.k.a the center x value)
            center.x = w.getWidth() / 2;
            //set center y value to half of height of screen(a.k.a the center y value)
            center.y = w.getHeight() /2;
            //converts values of a point(center) into coordinates on the screen(w)
            SwingUtilities.convertPointToScreen(center, w);
            //set centering to true
            centering = true;
            //make robot move the mouse to center x and y value
            robot.mouseMove(center.x, center.y);
        }
    }

    //mouse motion listener
    public void mouseDragged(MouseEvent e) {
        //call mouse moved method and pass event e
        mouseMoved(e);
    }

    public synchronized void mouseMoved(MouseEvent e) {
        //check if it is centering and if the center x and y values are equal to mouse x and y values
        if(centering && center.x == e.getX() && center.y == e.getY()) {
            //set centering to false
            centering = false;
        } else {
            //construct, calculate, and store the distance mouse moved from previous x coordinate
            int xDistance = e.getX() - mouse.x;
            //construct, calculate, and store the distance mouse moved from previouse y coordinate
            int yDistance = e.getY() - mouse.y;
            //move image's x position by the amount the mouse moved in the x direction
            image.x += xDistance;
            //move image's y position by the amount the mouse moved in the y direction
            image.y += yDistance;
            //call recenterMouse method
            recenterMouse();
        }
        //set mouse's x value to current x value
        mouse.x = e.getX();
        //set mouse's y value to current y value
        mouse.y = e.getY();
    }
    
    //key listner
    public void keyPressed(KeyEvent e) {
        //check of the escape key is pressed
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            stop();
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}
