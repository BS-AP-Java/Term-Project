package termProject;
import java.awt.*;
import javax.swing.JFrame;

public class Main extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		Main main = new Main();
		main.run(dm);
	}
	
	public void run(DisplayMode dm) {
		Screen screen = new Screen();
		
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(new Font("Times New Roman", Font.PLAIN, 24));
		try {
			screen.setFullScreen(dm, this);
			try {
				Thread.sleep(5000);
			} catch(Exception e) {
			}
		} finally {
			screen.restoreScreen();
		}
	}
	
	public void paint(Graphics g) {
		g.drawString("Hello Kwun", 350, 300);
	}

}
