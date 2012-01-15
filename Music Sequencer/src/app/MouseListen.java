package app;

import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Nanyou
 */
public class MouseListen extends Core implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {

    public static void main(String[] args) {
        new MouseListen().run();
    }

    private String msg = "";

    //init method that calls super init method
    public void init() {
        //inherit from core class's init method
        super.init();
        //get full screen window and store in w
        Window w = screen.getFullScreenWindow();
        //add mouse listener in the window
        w.addMouseListener(this);
        //add mouse motion listener in the window
        w.addMouseMotionListener(this);
        //add mouse wheel listener in the window
        w.addMouseWheelListener(this);
        //add key listener in the window
        w.addKeyListener(this);
    }
    
    //paint method
    public synchronized void paint(Graphics2D g) {
        //get full screen window and store it in w
        Window w = screen.getFullScreenWindow();
        //set drawing color to background color
        g.setColor(w.getBackground());
        //fill and draw a rectangle starting at 0,0(upperleft corner of screen) with width and height of screen
        g.fillRect(0, 0, screen.getWidth(), screen.getHeight());
        //set drawing color to foreground color
        g.setColor(w.getForeground());
        //draw the string at 40,50
        g.drawString(msg, 40, 50);
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

}
