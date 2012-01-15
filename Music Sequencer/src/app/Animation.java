package app;

import java.awt.Image;
import java.util.ArrayList;
/**
 *
 * @author Nanyou
 */
public class Animation {

    private ArrayList scenes;//create an arraylist to hold each scene of the animation
    private int sceneIndex;//create an index for the scenes array
    private long movieTime;//holds the length of animation
    private long totalTime;//total length limit of animation

    //constructor
    public Animation() {
        scenes = new ArrayList();//create a new arraylist
        totalTime = 0;//set total time to 0
        start();//call the method start
    }

    /**
     * creates a synchronized method to add scene pictures
     * synchronized = only allows this method to run once at a time
     * and method is run before anything else is run
     * it is used when there are multiple threads running
     * image = image to add
     * time = the image's display duration
     */
    public synchronized void addScene(Image image, long time) {

        //adds the picture duration to the total time
        totalTime += time;

        /**
         * add a scene to the array list
         * image = image to be added
         * totalTime = total time
         */
        scenes.add(new OneScene(image, totalTime));
    }

    //method is called everytime animation is restarted or started
    public synchronized void start() {
        //set movie length to 0
        movieTime = 0;
        //set the index to 0 to start at the beggining
        sceneIndex = 0;
    }

    /**
     * method to change from scene to scene
     * @param timePassed = time passed between updates
     */
    public synchronized void update(long timePassed) {

        //check if there is more than one scene
        if(scenes.size()>1) {
            //set movieTime to the sum of all the time passed between updates(total time of animation)
            movieTime += timePassed;
            //check if movieTime is larger than totalTime the restarts animation
            if(movieTime >= totalTime) {
                //set movieTime to 0
                movieTime = 0;
                //set sceneIndex to 0
                sceneIndex = 0;
            }
            //when the movieTime exceeds the current scene's duration limit, change scenes
            while(movieTime > getScene(sceneIndex).endTime) {
                sceneIndex++;
            }
        }
    }

    //get animation's current scene/image
    public synchronized Image getImage() {

        //check if the scene array has scenes/images(if it is greater than 0)
        if(scenes.size() == 0) {
            //return a null value if there are no scenes/images
            return null;
        } else {
            //return the scene/image being displayed
            return getScene(sceneIndex).pic;
        }
    }

    //function to get scene/image
    private OneScene getScene(int x) {
        //returns the scene/image in the index
        return(OneScene)scenes.get(x);
    }

    /**
     * private inner class(a private class used by this class)
     * to convert a picture into an object
     */
    private class OneScene {
        Image pic;//picture
        long endTime;//picture display duration

        //constructor
        public OneScene(Image pic, long endTime) {

            //set pic to OneScene's pic
            this.pic = pic;
            //set endTime to OneScene's endTime
            this.endTime = endTime;
        }
    }

}
