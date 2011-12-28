package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

public class Splash {
	// Overlay a progress bar over the splash screen
	// run with VM command-line option -splash:splashImageFilename
	public static void main(String[] args) {
	   SplashScreen splash = SplashScreen.getSplashScreen();
	   if (splash != null) { // Okay, Splash screen created
	      Dimension splashBounds = splash.getSize();
	      Graphics2D g2d = splash.createGraphics();
	   
	      // Simulate a progress bar
	      for (int i = 0; i < 100; i += 5) {
	         g2d.setColor(Color.RED);
	         g2d.fillRect(0, splashBounds.height / 2,
	               splashBounds.width * i / 100, 20);
	         splash.update();
	         try {
	            Thread.sleep(200);  // Some delays
	         } catch (Exception e) {
	        	 
	         }
	      }
	      g2d.dispose();
	      splash.close();
	   }
	}

}
