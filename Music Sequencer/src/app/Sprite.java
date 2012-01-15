package app;

import java.awt.Image;
/**
 *
 * @author Nanyou
 */
public class Sprite {

    private Animation a;
    private float x;
    private float y;
    private float xSpeed;
    private float ySpeed;

    //constructor
    public Sprite(Animation a) {
        //set outside a value to this method's a value
        this.a = a;
    }

    //this method changes the sprite's position based on time passed
    public void update(long timePassed) {
        //set x postion to xSpeed multiplied by time passed(speed*time=distance)
        x += xSpeed * timePassed;
        //set y postion to ySpeed multiplied by time passed(speed*time=distance)
        y += ySpeed * timePassed;
        //update animation's timepassed
        a.update(timePassed);
    }

    //function to get x postion
    public float getX() {
        //return x value
        return x;
    }

    //function to get y position
    public float getY() {
        //return y value
        return y;
    }

    //method to set sprite's x postion
    public void setX(float x) {
        //set outside y value to this method's y value
        this.x = x;
    }

    //method to set sprite's y position
    public void setY(float y) {
        //set outside y value to this method's y value
        this.y = y;
    }

    //function to get sprite's width
    public int getWidth() {
        //returns the image's width
        return a.getImage().getWidth(null);
    }

    //function to get sprite's height
    public int getHeight() {
        //returns the image's height
        return a.getImage().getHeight(null);
    }

    //function to get x speed
    public float getXSpeed() {
        return xSpeed;
    }

    //function to get y speed
    public float getYSpeed() {
        return ySpeed;
    }

    //method to set x speed
    public void setXSpeed(float xSpeed) {
        //set outside ySpeed value to this method's ySpeed
        this.xSpeed = xSpeed;
    }

    //method to set y speed
    public void setYSpeed(float ySpeed) {
        //set outside ySpeed value to this method's ySpeed
        this.ySpeed = ySpeed;
    }

    //function to get sprite/image
    public Image getImage() {
        //return the image
        return a.getImage();
    }
}
