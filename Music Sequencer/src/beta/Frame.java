package beta;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public static boolean fullScreen;
	public static int windowWidth, windowHeight, windowX, windowY;
	private GraphicsDevice gd;
	
	public Frame(Panel panel) {
		super();
		fullScreen = false;
		windowWidth = 800;
		windowHeight = 600;
		windowX = 0;
		windowY = 0;
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		setBounds(windowX, windowY, windowWidth, windowHeight);
		setResizable(true);
		setContentPane(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Music Sequencer");
		pack();
		setVisible(true);
		createBufferStrategy(2);
	}
	
	public void apply() {
        this.setVisible(false); // Hide the display
        if (isDisplayable())
           this.dispose();      // Dispose it
        if (fullScreen) {    // Put into full screen mode
           windowX = this.getX();
           windowY = this.getY();
           if (gd.isFullScreenSupported()) {
              this.setUndecorated(true);
              this.setResizable(false);
              gd.setFullScreenWindow(this);
           }
        } else { // Put into windowed mode
           this.setUndecorated(false);      // Put the title and border back
           gd.setFullScreenWindow(null); // windowed mode
           this.setBounds(windowX, windowY, windowWidth, windowHeight);
           this.setResizable(true);
        }
        this.setVisible(true); // Show it again
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
			this.setUndecorated(true);
			this.setIgnoreRepaint(true);
			this.setResizable(false);
			gd.setFullScreenWindow(this);
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
			this.setUndecorated(true);
			this.setIgnoreRepaint(true);
			this.setResizable(false);
			this.setVisible(false);
			gd.setFullScreenWindow(this);
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
