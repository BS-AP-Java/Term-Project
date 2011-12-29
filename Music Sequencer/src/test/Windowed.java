package test;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Windowed extends ScreenManager {
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gd.getDefaultConfiguration();
    
    public Windowed(Canvas c) {
		super(c);
	}
    
    public void setWindowed() {
    	frame.setBounds(windowedModeX, windowedModeY, windowedModeWidth, windowedModeHeight);
    	frame.setResizable(true);
    	frame.setIgnoreRepaint(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	fullScreenMode = false;
    }
    
    public void update() {
    	BufferStrategy buffer = canvas.getBufferStrategy();
    	if(!buffer.contentsLost() ) {
    		buffer.show();
    	}
    }

}
