package test;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Skin {
	public static boolean fullScreenMode;
	public int windowedModeWidth, windowedModeHeight;
	public int windowedModeX, windowedModeY;
	public int currentWindowWidth, currentWindowHeight;
	public final JFrame frame;
	private Dimension dim;
	public GraphicsEnvironment ge;
    public GraphicsDevice gd;
    public GraphicsConfiguration gc;
    
	public Skin() {
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();
		fullScreenMode = false;
		frame = new JFrame();
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		windowedModeWidth = dim.width;
	    windowedModeHeight = dim.height;
	    windowedModeX = 0;
	    windowedModeY = 0;
	    currentWindowWidth = frame.getWidth();
	    currentWindowHeight = frame.getHeight();
	    frame.setVisible(true);
	    frame.setResizable(true);
    	frame.setIgnoreRepaint(true);
	    frame.setTitle("Music Sequencer");
	    frame.createBufferStrategy(2);
	    frame.setBounds(windowedModeX, windowedModeY, windowedModeWidth, windowedModeHeight);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    currentWindowWidth = frame.getWidth();
	    currentWindowHeight = frame.getHeight();
	    //frame.add(panel);
	    //frame.pack();
	}
	
	public void apply() {
		frame.setVisible(false); // Hide the display
        if (frame.isDisplayable())
           frame.dispose();      // Dispose it
        if (fullScreenMode) {    // Put into full screen mode
           // User may have change the windowed mode settings. Saved them for restoration.
           windowedModeWidth = frame.getWidth();
           windowedModeHeight = frame.getHeight();
           windowedModeX = frame.getX();
           windowedModeY = frame.getY();
           setFullScreen();
        } else { // Put into windowed mode
           frame.setUndecorated(false);      // Put the title and border back
           gd.setFullScreenWindow(null); // windowed mode
           frame.setBounds(windowedModeX, windowedModeY, windowedModeWidth, windowedModeHeight);
           frame.setResizable(true);
        }
        // Update the current settings
        currentWindowWidth = frame.getWidth();
        currentWindowHeight = frame.getHeight();
        frame.setVisible(true); // Show it again
	}
	
	public void addPanel(JPanel panel) {
		frame.setContentPane(panel);
		frame.pack();
	}
	
	public void setWindowed() {
    	frame.setBounds(windowedModeX, windowedModeY, windowedModeWidth, windowedModeHeight);
    	frame.setResizable(true);
    	frame.setIgnoreRepaint(true);
    	frame.setVisible(true);
    	fullScreenMode = false;
    }
	
	public void update() {
		if(fullScreenMode == false) {
			BufferStrategy buffer = frame.getBufferStrategy();
	    	if(!buffer.contentsLost()) {
	    		buffer.show();
	    	}
		} else {
			Window window = gd.getFullScreenWindow();
			
			if(window != null) {
				BufferStrategy bufferStrategy = window.getBufferStrategy();
				if(!bufferStrategy.contentsLost()) {
					bufferStrategy.show();
				}
			}
		}
		
		frame.addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent e) {
	            int keyCode = e.getKeyCode();
	            switch (keyCode) {
	               // Space key to toggle between fullscreen and windowed modes
	               case KeyEvent.VK_SPACE:
	                  fullScreenMode = !fullScreenMode;
	                  apply();
	                  break;
	               // ESC to quit (in fullscreen mode)
	               case KeyEvent.VK_ESCAPE:
	                  System.exit(0);
	                  break;
	            }
	         }
	      });
    }
	
	public Graphics2D getGraphics() {
		Graphics2D g2D = null;
		Window window = gd.getFullScreenWindow();
		
		if(window != null) {
			BufferStrategy bufferStrategy = window.getBufferStrategy();
			g2D = (Graphics2D)bufferStrategy.getDrawGraphics();
		} else {
			BufferStrategy bufferStrategy = frame.getBufferStrategy();
			g2D = (Graphics2D)bufferStrategy.getDrawGraphics();
		}
		return g2D;
	}
	
	////////////////////Full Screen Stuff/////////////////////////////////
	
	public DisplayMode[] getCompatibleDisplayModes() {
		return gd.getDisplayModes();
	}
	
	public DisplayMode findFirstCompatibleMode(DisplayMode modes[]) {
		DisplayMode mode = null;
		DisplayMode goodModes[] = gd.getDisplayModes();
		
		for(int i = 0; i < modes.length; i++) {
			for(int idx = 0; idx < goodModes.length; idx++) {
				if(displayModesMatch(modes[i], goodModes[idx])) {
					mode = modes[i];
				}
			}
		}
		return mode;
	}
	
	public DisplayMode getCurrentDisplayMode() {
		return gd.getDisplayMode();
	}
	
	public boolean displayModesMatch(DisplayMode m1, DisplayMode m2) {
		boolean match = true;
		
		if(m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()) {
			match = false;
		}
		if(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()) {
			match = false;
		}
		if(m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()) {
			match = false;
		}
		return match;
	}
	
	public void changeDisplayMode(DisplayMode dm) {
		if(dm != null && gd.isDisplayChangeSupported()) {
			try {
				gd.setDisplayMode(dm);
			} catch(Exception e) {
			}
		}
	}
	
	public void setFullScreen(DisplayMode dm) {
		if(gd.isFullScreenSupported()) {
			frame.setUndecorated(true);
			frame.setIgnoreRepaint(true);
			frame.setResizable(false);
			gd.setFullScreenWindow(frame);
			if(dm != null && gd.isDisplayChangeSupported()) {
				try {
					gd.setDisplayMode(dm);
				} catch(Exception e) {
				}
			}
			fullScreenMode = true;
		}
	}
	
	public void setFullScreen() {
		if(gd.isFullScreenSupported()) {
			frame.setUndecorated(true);
			frame.setIgnoreRepaint(true);
			frame.setResizable(false);
			frame.setVisible(false);
			gd.setFullScreenWindow(frame);
			if(gd.isDisplayChangeSupported()) {
				try {
					gd.setDisplayMode(findFirstCompatibleMode(getCompatibleDisplayModes()));
				} catch(Exception e) {
				}
			}
		}
	}
	
	public Window getFullScreenWindow() {
		return gd.getFullScreenWindow();
	}
	
	public void restoreScreen() {
		Window window = gd.getFullScreenWindow();
		
		if(window != null) {
			window.dispose();
		}
		gd.setFullScreenWindow(null);
	}
	
	public BufferedImage createCompatibleImage(int width, int height, int transparency) {
		Window w = gd.getFullScreenWindow();
		BufferedImage bufferedImage = null;
		
		if(w != null) {
			GraphicsConfiguration graphicsConfig = w.getGraphicsConfiguration();
			bufferedImage = graphicsConfig.createCompatibleImage(width, height, transparency);
		}
		return bufferedImage;
	}

}
