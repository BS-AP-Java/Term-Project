package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Heart extends Body {
	//protected Body body;
	public boolean running;
	public int fps;
    public int frames;
    public long totalTime;
    public long curTime;
    public long lastTime;
	public final static int MAIN_MENU_STATE = 0;
	public final static int SEQUENCE_STATE= 1;
	public final static int CREDITS_STATE = 2;
	public static int CURRENT_STATE = MAIN_MENU_STATE;
	public Heart[] states = new Heart[3];
	
	public Heart() {
		//body = new Body();
		running = true;
		fps = 0;
		frames = 0;
		curTime = System.currentTimeMillis();
		lastTime = curTime;
	}
	
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
			Graphics2D g2D = getGraphics();
			try {
		        lastTime = curTime;
		        curTime = System.currentTimeMillis();
		        totalTime += curTime - lastTime;
		        if( totalTime > 1000 ) {
		          totalTime -= 1000;
		          fps = frames;
		          frames = 0;
		        } 
		        ++frames;
		        g2D.setFont( new Font( "Courier New", Font.PLAIN, 12 ) );
		        g2D.setColor( Color.GREEN );
		        g2D.drawString( String.format( "FPS: %s", fps ), 20, 20 );
		        update();
			} finally {
				// release resources
		        //if(graphics != null)
		          //graphics.dispose();
		        if(g2D != null )
		          g2D.dispose();
			}
		}
	}
	
	public void update(long totalTime) {
		
	}
	
	public void render(Graphics2D g2D) {
		
	}

}
