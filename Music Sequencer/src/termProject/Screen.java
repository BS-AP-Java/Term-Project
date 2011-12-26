package termProject;
import java.awt.*;
import javax.swing.JFrame;

public class Screen {
	private GraphicsDevice display;
	
	public Screen() {
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		display = graphicsEnvironment.getDefaultScreenDevice();
	}
	
	public void setFullScreen(DisplayMode dm, JFrame frame) {
		frame.setUndecorated(true);
		frame.setResizable(false);
		display.setFullScreenWindow(frame);
		if(dm != null && display.isDisplayChangeSupported()) {
			try {
				display.setDisplayMode(dm);
			} catch(Exception e) {
			}
		}
	}
	
	public Window getFullScreenWindow() {
		return display.getFullScreenWindow();
	}
	
	public void restoreScreen() {
		Window w = display.getFullScreenWindow();
		
		if(w != null) {
			w.dispose();
		}
		display.setFullScreenWindow(null);
	}

}
