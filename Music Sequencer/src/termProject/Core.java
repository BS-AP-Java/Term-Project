package termProject;
import java.awt.*;

import javax.swing.*;

public abstract class Core {
	private static  DisplayMode modes[] = {
		new DisplayMode(800, 600, 32, 0),
		new DisplayMode(800, 600, 24, 0),
		new DisplayMode(800, 600, 16, 0),
		new DisplayMode(640, 480, 32, 0),
		new DisplayMode(640, 480, 24, 0),
		new DisplayMode(640, 480, 16, 0),
	};
	private boolean running;
	protected ScreenManager screenManager;
	
	public void stop() {
		running = false;
	}
	
	public void run() {
		try {
			init();
			loop();
		} finally {
			screenManager.restoreScreen();
		}
	}
	
	public void init() {
		screenManager = new ScreenManager();
		DisplayMode dm = screenManager.findFirstCompatibleMode(modes);
		Window window = screenManager.getFullScreenWindow();
		
		screenManager.setFullScreen(dm);
		window.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		window.setBackground(Color.white);
		window.setForeground(Color.black);
		running = true;
	}
	
	public void loop() {
		long curTime = System.currentTimeMillis();
		long lastTime = curTime;
		long totalTime = 0;
		int fps = 0;
		int frames = 0;
		
		while(running == true) {
			Graphics2D g2D = screenManager.getGraphics();
			lastTime = curTime;
			curTime = System.currentTimeMillis();
			totalTime += curTime - lastTime;
			if(totalTime > 1000) {
				totalTime -= 1000;
				fps = frames;
				frames = 0;
			}
			frames++;
			update(totalTime);
			g2D.setBackground(Color.WHITE);
			g2D.setColor(Color.BLACK);
			g2D.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			g2D.drawString("FPS" + fps, 20, 20);
			draw(g2D);
			g2D.dispose();
			screenManager.update();
			try {
				Thread.sleep(20);
			} catch(Exception e) {
				
			}
		}
	}
	
	public void update(long totalTime) {
		
	}
	
	public void draw(Graphics2D g2D) {
		
	}

}
