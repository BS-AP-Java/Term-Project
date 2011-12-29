package test;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class FullScreen extends ScreenManager {
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice gd = ge.getDefaultScreenDevice();
	GraphicsConfiguration gc = gd.getDefaultConfiguration();
	
	public FullScreen(Canvas c) {
		super(c);
	}
	
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
	
	public Graphics2D getGraphics() {
		Graphics2D g2D = null;
		Window window = gd.getFullScreenWindow();
		
		if(window != null) {
			BufferStrategy bufferStrategy = window.getBufferStrategy();
			g2D = (Graphics2D)bufferStrategy.getDrawGraphics();
		} else {
			g2D = null;
		}
		return g2D;
	}
	
	public void update() {
		Window window = gd.getFullScreenWindow();
		
		if(window != null) {
			BufferStrategy bufferStrategy = window.getBufferStrategy();
			if(!bufferStrategy.contentsLost()) {
				bufferStrategy.show();
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
