package beta;

import java.awt.DisplayMode;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
	public static boolean fullScreen;
	public static int windowWidth, windowHeight, windowX, windowY;
	public static JFrame jframe;
	private GraphicsDevice gd;
	
	public Frame(JPanel pane) {
		jframe = new JFrame();
		fullScreen = false;
		windowWidth = 800;
		windowHeight = 600;
		windowX = 0;
		windowY = 0;
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		jframe.setResizable(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setTitle("Music Sequencer");
		jframe.setContentPane(pane);
		jframe.pack();
		jframe.setBounds(windowX, windowY, windowWidth, windowHeight);
		jframe.setVisible(true);
		jframe.createBufferStrategy(2);
	}
	
	public void apply() {
        jframe.setVisible(false); // Hide the display
        if (jframe.isDisplayable()) {
           jframe.dispose();      // Dispose it
        }
        if (fullScreen) {    // Put into full screen mode
           windowX = jframe.getX();
           windowY = jframe.getY();
           if (gd.isFullScreenSupported()) {
              jframe.setUndecorated(true);
              jframe.setResizable(false);
              gd.setFullScreenWindow(jframe);
           }
        } else { // Put into windowed mode
           jframe.setUndecorated(false);      // Put the title and border back
           gd.setFullScreenWindow(null); // windowed mode
           jframe.setBounds(windowX, windowY, windowWidth, windowHeight);
           jframe.setResizable(true);
        }
        jframe.setVisible(true); // Show it again
	}
	
	/**
	public Graphics2D getGraphics() {
		return (Graphics2D)jframe.getGraphics();
    }
    **/
	
	/**
	//method to update display
    public void update() {
    	BufferStrategy bs = null;
		try {
		bs = jframe.getBufferStrategy();
		} catch(Exception e) {
			System.out.println("ERRROR");
		}
		if(bs != null) {
			//check if the there is content in the full screen window
	        if(!bs.contentsLost()) {
	            //if there is content, show it on the full screen window
	            bs.show();
	        }
		} else {
			
		}
    }
    **/
    
    public JFrame getFrame() {
    	return jframe;
    }
	
////////////////////Full Screen Stuff/////////////////////////////////
	
	public DisplayMode[] getCompatibleDisplayModes() {
		return gd.getDisplayModes();
	}

	public DisplayMode findFirstCompatibleMode(DisplayMode[] modes) {
		DisplayMode mode = null;
		DisplayMode[] goodModes = gd.getDisplayModes();
		
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
			jframe.setUndecorated(true);
			jframe.setIgnoreRepaint(true);
			jframe.setResizable(false);
			gd.setFullScreenWindow(jframe);
			if(dm != null && gd.isDisplayChangeSupported()) {
				try {
					gd.setDisplayMode(dm);
				} catch(Exception e) {
				}
			}
			fullScreen = true;
		}
	}

	public void setFullScreen() {
		if(gd.isFullScreenSupported()) {
			jframe.setUndecorated(true);
			jframe.setIgnoreRepaint(true);
			jframe.setResizable(false);
			jframe.setVisible(false);
			gd.setFullScreenWindow(jframe);
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
