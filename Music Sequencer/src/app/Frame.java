package app;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
/**
 *
 * @author Nanyou
 */
public class Frame {

    public static void main(String[] args) {
        //create an object of this class named frame
        Frame frame = new Frame();
        frame.run();

        /**
         * set the display mode setttings
         * has 4 parameters
         * 800 = resolution x value
         * 600 = resolution y value
         * 16 = bit depth(ex: 16 bit colors, 32 bit colors)
         * DisplayMode.REFRESH_RATE_UNKNOWN = use this if you do not know the refresh rate
         */
        //DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);

    }

    private Sprite sprite;
    private FullScreen screen;//create a FullScreen object to allow us to use the FullScreen class' methods here
    private Image bg;//holds background image
    private boolean loaded;//set to false and used to check if images are loader
    private Animation a;//Animation object to have access to anumation class
    private Image pic;//holds another image

    //array to hold display modes
    private static final DisplayMode modes1[] = {
        //mode format = resolution width, resolution height, bit depth, refresh rate
        new DisplayMode(800, 600, 32, 0),
        new DisplayMode(800, 600, 24, 0),
        new DisplayMode(800, 600, 16, 0),
        new DisplayMode(640, 480, 32, 0),
        new DisplayMode(640, 480, 24, 0),
        new DisplayMode(640, 480, 16, 0),
    };

    //method to load pictures
    private void loadPics() {
        bg = new ImageIcon("images/om/om_d1.png").getImage();
        Image scene1 = new ImageIcon("images/om/om_d1.png").getImage();
        Image scene2 = new ImageIcon("images/om/om_d1.png").getImage();
        //pic = new ImageIcon("C:\\Users\\Nanyou\\Desktop\\game\\sprites\\maps\\church_area.png").getImage();
        a = new Animation();//construct the new animation object
        sprite = new Sprite(a);//construct a sprite that will move the whole specified animation(in this case it is a)
        a.addScene(scene1, 250);//adds scene1 to the array
        a.addScene(scene2, 250);//set display duration to 250ms
        sprite.setXSpeed(0.1f);//set the x speed of the sprite
        sprite.setYSpeed(0.1f);//set the y speed of the sprite
        loaded = true;
    }

    /**
     * sets the stuff that will appear on the screen
     * @param dm = display mode settings used to pass on setFullScreen
     */
    public void run() {
        //construct the screen
        screen = new FullScreen();
        loaded = false;

        /**
        //set background color of the window to black
        setBackground(Color.BLACK);
        //set foreground color of the window to white
        setForeground(Color.white);
        //set font of the window to arial, plain(ex: no bold, italics, etc.), and a size of 24
        setFont(new Font("Arial", Font.PLAIN, 24));
        **/

        try {
            //find display mode that is compatible with monitor and program
            DisplayMode dm = screen.findFirstCompatibleMode(modes1);
            //uses the display mode and sets full screen
            screen.setFullScreen(dm);
            //call the loadpics method to load pictures
            loadPics();
            //call the movieLoop method to loop through the scenes
            movieLoop();

            /**
            //if previous try works set thread to sleep
            try {
                //set thread to sleep for 5 seconds(5000ms)
                Thread.sleep(5000);
            **/

            } catch(Exception ex) {

            } finally {
            //restores back to the normal screen
            screen.restoreScreen();
        }
    }
    
    //method to loop through the scenes of the animation
    public void movieLoop() {
        
        //store the current time when method is run into startTime variable
        long startTime = System.currentTimeMillis();//this gets the current time in ms
        //stores the length of time that animation is played
        long runTime = startTime;
        
        //check if runTime is less than 5000ms(5secs)
        while(runTime - startTime < 5000) {
            
            //keeps track of time passed in one loop
            long timePassed = System.currentTimeMillis() - runTime;
            //add timePassed to runTime
            runTime += timePassed;
            //call the update method to update the sprite
            update(timePassed);
            //draw and update the screen
            Graphics2D g = screen.getGraphics();
            //paint the pictures on the screen
            paint(g);
            //get rid of graphics object
            g.dispose();
            //update the screen
            screen.update();

            /**
            //update the timePassed in the animation method
            //when timePassed is greater than the animation's total time
            //the animation will restart
            a.update(timePassed);
            **/

            try {
                Thread.sleep(20);
            } catch(Exception e) {
                
            }
        }
    }

    //method to check if sprite is off screen and put it back on screen
    public void update(long timePassed) {
        //check if sprite's left x position is less than 0(off the left of screen)
        if(sprite.getX() < 0) {
            //make the sprite move right
            sprite.setXSpeed(Math.abs(sprite.getXSpeed()));
          //check if sprite's right x position is greater than screen width(off the right of screen)
        } else if(sprite.getX() + sprite.getWidth() > screen.getWidth()) {
            //make the sprite move left
            sprite.setXSpeed(-Math.abs(sprite.getXSpeed()));
        }
        //check if the sprite's upperleft y position is less than 0(off the top of screen)
        if(sprite.getY() < 0) {
            //make the sprite move down
            sprite.setYSpeed(Math.abs(sprite.getYSpeed()));
          //check if sprite's lower y position is greater than screen height(off the bottom of screen)
        } else if(sprite.getY() + sprite.getHeight() > screen.getHeight()) {
            //make the sprite move up
            sprite.setYSpeed(-Math.abs(sprite.getYSpeed()));
        }
        //update the sprite
        sprite.update(timePassed);
    }

    //paint graphics
    public void paint(Graphics g) {

        //check if pictures are loaded and then draws them
        if(loaded) {
            //draw the background image at postion 0,0
            g.drawImage(bg, 0, 0, null);
            //draw the sprite and all the animations it contains at the nearest x and y value position
            g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);
            g.drawString("TEST", 200, 400);
            /**
            //check if g is a Graphics2D object. if it is, text will be made smooth
            if(g instanceof Graphics2D) {

            //set the g to a Graphics2D object and store it in g2
            //this is done so we can use Graphics2D methods
            Graphics2D g2 = (Graphics2D)g;

            //set a rendering hint so all text will be antialiased
            //first parameter is what you want to change(the text)
            //second parameter is how it will be changed(set antialiasing on)
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            }
            **/

            /**
            * draws the word awesome at postion 200,200
            g.drawString("Awesome", 200, 200);
            */

            /**
            //draw animation image
            g.drawImage(a.getImage(), 0, 0, null);
            **/

            /**
            //draw the picture at position 170, 180
            g.drawImage(pic, 200, 200, null);
            **/
        }
    }
}
