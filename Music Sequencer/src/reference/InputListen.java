package reference;

import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Nanyou
 */
public class InputListen extends Core implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {

    public static void main(String[] args) {
        new InputListen().run();
    }

    private String msg = "";//string to hold words

    //method to call init from superclass(core)
    public void init() {
        //inherit from the core class's init method
        super.init();
        //store full screen window in w
        Window w = screen.getFullScreenWindow();
        //set buttons like tab not function like tab is supposed to but become normal buttons
        FullScreen.frame.setFocusTraversalKeysEnabled(false);
        //add keylistener to this window
        FullScreen.frame.addKeyListener(this);
        msg = "Press escape to exit";
    }

    //method to override keyPressed method in keylistener
    public void keyPressed(KeyEvent e) {
        //stores keycode value of key pressed
        int keyCode = e.getKeyCode();
        //check if the key code is equal to the escape key's keycode
        if(keyCode == KeyEvent.VK_ESCAPE) {
            //call the stop method inherited from the class core
            stop();
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

    //paint graphics(pictures/images)
    //synchronized =  this method can only be run once at the same time
    //and no other methods can run while its running
    public synchronized void paint(Graphics2D g) {
        //get the full screen window and store it in w
        //Window w = screen.getFullScreenWindow();
        //set drawing color to background color
        g.setColor(FullScreen.frame.getBackground());
        //draw a filled rectangle starting at position 0,0(upperleft corner) with width and height of screen
        g.fillRect(0, 0, screen.getWidth(), screen.getHeight());
        //change drawing color to foreground color
        g.setColor(FullScreen.frame.getForeground());
        g.drawString(msg, 60, 60);
    }

}
