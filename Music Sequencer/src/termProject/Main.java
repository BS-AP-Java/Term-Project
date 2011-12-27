package termProject;
import java.awt.*;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends Core {
private ScreenManager screenManager;
private Image background;
//Note: add more display modes later
private static final DisplayMode modes1[] = {
	new DisplayMode(800, 600, 32, 0),
	new DisplayMode(800, 600, 24, 0),
	new DisplayMode(800, 600, 16, 0),
	new DisplayMode(640, 480, 32, 0),
	new DisplayMode(640, 480, 24, 0),
	new DisplayMode(640, 480, 16, 0),
};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main driver = new Main();
		driver.run();
	}
	
	public void loadImages() {
		//Instantiate image objects here
	}
	
	public void run() {
		ScreenManager screenManager = new ScreenManager();
		
		try {
			DisplayMode dm = screenManager.findFirstCompatibleMode(modes1);
			screenManager.setFullScreen(dm);
			loadImages();
			//start the program
		} finally {
			screenManager.restoreScreen();
		}
	}
	
	public void paint(Graphics g) {
		if(g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		g.drawString("Kwun is cool.", 350, 300);
	}

}
