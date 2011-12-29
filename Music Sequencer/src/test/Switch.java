package test;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class Switch {
	private static boolean fullScreenMode = true; // Fullscreen or windowed mode?
	   // Settings for the windowed mode
	   private static String windowedModeTitle = "In windowed mode of screen size";
	   private static int windowedModeWidth, windowedModeHeight;
	   private static int windowedModeX, windowedModeY;
	   // Current window width and height
	   private static int currentWindowWidth, currentWindowHeight;
	   
	   public static void main(String[] args) {
	      // Find out the current display screen width and height
	      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	      // Windowed mode initially covers the full screen 
	      windowedModeWidth = dim.width;
	      windowedModeHeight = dim.height;
	      windowedModeX = 0;
	      windowedModeY = 0;
	      
	      // Need to get the graphic device for switching into the fullscreen mode
	      final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	      final JFrame frame = new JFrame();
	   
	      if (device.isFullScreenSupported()) { // Check if fullscreen mode supported
	         frame.setUndecorated(true);        // Don't show title and border
	         frame.setResizable(false);
	         //this.setIgnoreRepaint(true);     // Ignore OS re-paint request
	         device.setFullScreenWindow(frame); // Put this Window into fullscreen mode
	         fullScreenMode = true;
	      } else { // Fullscreen not supported, go for windowed mode
	         frame.setBounds(windowedModeX, windowedModeY, windowedModeWidth, windowedModeHeight);
	         //frame.setUndecorated(true);      // Don't show title and border
	         frame.setResizable(true);
	         fullScreenMode = true;
	      }
	      
	      currentWindowWidth = frame.getWidth();
	      currentWindowHeight = frame.getHeight();
	      frame.setContentPane(new DrawPanel());
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setTitle(windowedModeTitle);
	      frame.pack();
	      frame.setVisible(true);
	   
	      // Key event handler
	      frame.addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent e) {
	            int keyCode = e.getKeyCode();
	            switch (keyCode) {
	               // Space key to toggle between fullscreen and windowed modes
	               case KeyEvent.VK_SPACE:
	                  fullScreenMode = !fullScreenMode;
	                  // Need to dispose the display to change the decoration
	                  frame.setVisible(false); // Hide the display
	                  if (frame.isDisplayable())
	                     frame.dispose();      // Dispose it
	                  if (fullScreenMode) {    // Put into full screen mode
	                     // User may have change the windowed mode settings. Saved them for restoration.
	                     windowedModeWidth = frame.getWidth();
	                     windowedModeHeight = frame.getHeight();
	                     windowedModeX = frame.getX();
	                     windowedModeY = frame.getY();
	                     if (device.isFullScreenSupported()) {
	                        frame.setUndecorated(true);
	                        frame.setResizable(false);
	                        device.setFullScreenWindow(frame);
	                     }
	                  } else { // Put into windowed mode
	                     frame.setUndecorated(false);      // Put the title and border back
	                     device.setFullScreenWindow(null); // windowed mode
	                     frame.setBounds(windowedModeX, windowedModeY, windowedModeWidth, windowedModeHeight);
	                     frame.setResizable(true);
	                  }
	                  // Update the current settings
	                  currentWindowWidth = frame.getWidth();
	                  currentWindowHeight = frame.getHeight();
	                  frame.setVisible(true); // Show it again
	                  break;
	               // ESC to quit (in fullscreen mode)
	               case KeyEvent.VK_ESCAPE:
	                  System.exit(0);
	                  break;
	            }
	         }
	      });
	   }
	   
	   // Drawing Panel
	   public static class DrawPanel extends JPanel {
	      @Override
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);
	         setBackground(Color.BLACK);
	         // Printing some texts
	         g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
	         String message;
	         if (fullScreenMode) {
	            g.setColor(Color.YELLOW);
	            message = "In Full Screen mode (no decoration)!";
	         } else {
	            g.setColor(Color.GREEN);
	            message = "In Windowed mode (with decoration)!";
	         }
	         // Find out the message width and height (to centralize texts)
	         FontMetrics fontMetrics = g.getFontMetrics();
	         Rectangle2D messageBounds = fontMetrics.getStringBounds(message, g);
	   
	         g.drawString(message,
	               (int)((getWidth() - messageBounds.getWidth()) / 2),
	               (int)((getHeight() - messageBounds.getHeight()) / 2));

	         g.setColor(Color.WHITE);
	         g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	         message = "SPACE to toggle between Full-screen/windowed modes, ESC to quit.";
	         messageBounds = g.getFontMetrics().getStringBounds(message, g);
	         g.drawString(message,
	               (int)((getWidth() - messageBounds.getWidth()) / 2),
	               (int)((getHeight() - messageBounds.getHeight()) / 2) + 30);
	      }
	   
	      // Call back method to set the size of this panel
	      @Override
	      public Dimension getPreferredSize() {
	         return new Dimension(currentWindowWidth, currentWindowHeight);
	      }
	   }

}
