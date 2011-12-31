package test;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public abstract class Heart {
	protected FullScreen fullScreen = new FullScreen();
	public boolean running = true;
	public int fps = 0;
    public int frames = 0;
    public long totalTime = 0;
    public long curTime = System.currentTimeMillis();
    public long lastTime = curTime;
	public final static int MAIN_MENU_STATE = 0;
	public final static int SEQUENCE_STATE= 1;
	public final static int CREDITS_STATE = 2;
	public static int CURRENT_STATE = MAIN_MENU_STATE;
	public Heart[] states = new Heart[3];
	
	public void init() {
		states[MAIN_MENU_STATE] = new MainMenu();
		//states[SEQUENCE_STATE] = new Sequencer();
		//states[CREDITS_STATE] = new Credits();
		
		for(int i = 0; i < states.length; i++) {
			states[i].init();
		}
	}
	
	public void enter() {
		states[CURRENT_STATE].enter();
	}
	
	public void loop() {
		while(running == true) {
			Graphics2D g2D = fullScreen.getGraphics();
			try {
				// count Frames per second...
		        lastTime = curTime;
		        curTime = System.currentTimeMillis();
		        totalTime += curTime - lastTime;
		        if( totalTime > 1000 ) {
		          totalTime -= 1000;
		          fps = frames;
		          frames = 0;
		        } 
		        ++frames;
			} finally {
				// release resources
		        //if(graphics != null)
		          //graphics.dispose();
		        if(g2D != null )
		          g2D.dispose();
			}
		}
	}
	
	public void update() {
		
	}
	
	public void render(Graphics2D g2D) {
		
	}

}
