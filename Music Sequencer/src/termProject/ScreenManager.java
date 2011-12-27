package termProject;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

public class ScreenManager {
	private GraphicsDevice videoCard;
	
	public ScreenManager() {
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		videoCard = graphicsEnvironment.getDefaultScreenDevice();
	}
	
	public DisplayMode[] getCompatibleDisplayModes() {
		return videoCard.getDisplayModes();
	}
	
	public DisplayMode findFirstCompatibleMode(DisplayMode modes[]) {
		DisplayMode mode = null;
		DisplayMode goodModes[] = videoCard.getDisplayModes();
		
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
		return videoCard.getDisplayMode();
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
	
	/**
	 * Note to self:
	 * maybe you can try to make each menu state a JPanel to put into this frame
	 * @param dm
	 */
	public void setFullScreen(DisplayMode dm) {
		JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setIgnoreRepaint(true);
		frame.setResizable(false);
		videoCard.setFullScreenWindow(frame);
		if(dm != null && videoCard.isDisplayChangeSupported()) {
			try {
				videoCard.setDisplayMode(dm);
			} catch(Exception e) {
			}
		}
		frame.createBufferStrategy(2);
	}
	
	public Graphics2D getGraphics() {
		Graphics2D g2D = null;
		Window window = videoCard.getFullScreenWindow();
		
		if(window != null) {
			BufferStrategy bufferStrategy = window.getBufferStrategy();
			g2D = (Graphics2D)bufferStrategy.getDrawGraphics();
		} else {
			g2D = null;
		}
		return g2D;
	}
	
	public void update() {
		Window window = videoCard.getFullScreenWindow();
		
		if(window != null) {
			BufferStrategy bufferStrategy = window.getBufferStrategy();
			if(!bufferStrategy.contentsLost()) {
				bufferStrategy.show();
			}
		}
	}
	
	public Window getFullScreenWindow() {
		return videoCard.getFullScreenWindow();
	}
	
	public int getWidth() {
		Window window = videoCard.getFullScreenWindow();
		int width = 0;
		
		if(window != null) {
			width = window.getWidth();
		} else {
			width = 0;
		}
		return width;
	}
	
	public int getHeight() {
		Window window = videoCard.getFullScreenWindow();
		int height = 0;
		
		if(window != null) {
			height = window.getHeight();
		} else {
			height = 0;
		}
		return height;
	}
	
	public void restoreScreen() {
		Window window = videoCard.getFullScreenWindow();
		
		if(window != null) {
			window.dispose();
		}
		videoCard.setFullScreenWindow(null);
	}
	
	public BufferedImage createCompatibleImage(int width, int height, int transparency) {
		Window w = videoCard.getFullScreenWindow();
		BufferedImage bufferedImage = null;
		
		if(w != null) {
			GraphicsConfiguration graphicsConfig = w.getGraphicsConfiguration();
			bufferedImage = graphicsConfig.createCompatibleImage(width, height, transparency);
		}
		return bufferedImage;
	}
	
}
