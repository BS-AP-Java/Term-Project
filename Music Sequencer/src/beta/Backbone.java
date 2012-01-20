package beta;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import lol.FileRW;


public class Backbone extends JLayeredPane implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {
	public static boolean running;
	protected Frame frame;
	private String msg;//string to hold words
	private JFrame f;
	private SoundManager soundManager;
	private JButton stop, save, open, credits, play, pause;
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
	private JButton w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14;
	private JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;
	private JLabel lblPiano, lblPiano_1, lblDoubleBass, lblDoubleBass_1, lblSnareDrum, lblBassDrum, lblClick;
	private ImageIcon icon;
	private int maxWhite, maxBlack, blackWidth, blackHeight, whiteWidth, whiteHeight;
	private FileRW x;
	public Backbone() {
	}
	
	//method to stop the program
    public void stop() {
        //set running to false
        running = false;
    }

    //method that calls init and gameLoop while program is running
    public void run() {
        try {
            //call the init method
            init();
            //call the mainLoop method
            mainLoop();
        } finally {
        	if(Frame.fullScreen == true) {
            //removes full screen and restores screen back to normal
            frame.restoreScreen();
        	} else {
        		
        	}
        }
    }

    //sets up screen
    public void init() {
    	try {
    		x = new FileRW("nanyou");
    		maxBlack = 15;
    		maxWhite = 15;
    		blackWidth = 48;
    		blackHeight = 140;
    		whiteWidth = 60;
    		whiteHeight = 240;
    		msg = "Press Esc to exit";
	        //construct screen object
	        frame = new Frame(this);
	        f = frame.getFrame();
	        this.setLayout(null);
	        //set font style, type, and size
	        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	        //set foreground color to white
	        this.setBackground(new Color(61, 89, 171));
	        f.addKeyListener(this);
	        f.addMouseListener(this);
	        f.addMouseMotionListener(this);
	        f.addMouseWheelListener(this);
	        ///////////////////////////////////////////////////////////////
	        b1 = new JButton();
	        b2 = new JButton();
	        b3 = new JButton();
	        b4 = new JButton();
	        b5 = new JButton();
	        b6 = new JButton();
	        b7 = new JButton();
	        b8 = new JButton();
	        b9 = new JButton();
	        b10 = new JButton();
	        b11 = new JButton();
	        w1 = new JButton();
	        w2 = new JButton();
	        w3 = new JButton();
	        w4 = new JButton();
	        w5 = new JButton();
	        w6 = new JButton();
	        w7 = new JButton();
	        w8 = new JButton();
	        w9 = new JButton();
	        w10 = new JButton();
	        w11 = new JButton();
	        w12 = new JButton();
	        w13 = new JButton();
	        w14 = new JButton();
	        ///////////////////////////////////////////////////////////////
	        b1.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b2.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b3.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b4.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b5.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b6.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b7.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b8.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b9.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b10.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        b11.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w1.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w2.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w3.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w4.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w5.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w6.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w7.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w8.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w9.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w10.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w11.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w12.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w13.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        w14.addActionListener(new ActionListener() {
   			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
	        ///////////////////////////////////////////////////////////////
	        b1.setBounds(36, 250, blackWidth, blackHeight);
	        b1.putClientProperty("Synthetica.background", Color.BLACK);
    		b1.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b2.setBounds(96, 250, blackWidth, blackHeight);
	        b2.putClientProperty("Synthetica.background", Color.BLACK);
    		b2.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b3.setBounds(156, 250, blackWidth, blackHeight);
	        b3.putClientProperty("Synthetica.background", Color.BLACK);
    		b3.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b4.setBounds(276, 250, blackWidth, blackHeight);
	        b4.putClientProperty("Synthetica.background", Color.BLACK);
    		b4.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b5.setBounds(336, 250, blackWidth, blackHeight);
	        b5.putClientProperty("Synthetica.background", Color.BLACK);
    		b5.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b6.setBounds(456, 250, blackWidth, blackHeight);
	        b6.putClientProperty("Synthetica.background", Color.BLACK);
    		b6.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b7.setBounds(516, 250, blackWidth, blackHeight);
	        b7.putClientProperty("Synthetica.background", Color.BLACK);
    		b7.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b8.setBounds(576, 250, blackWidth, blackHeight);
	        b8.putClientProperty("Synthetica.background", Color.BLACK);
    		b8.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b9.setBounds(696, 250, blackWidth, blackHeight);
	        b9.putClientProperty("Synthetica.background", Color.BLACK);
    		b9.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b10.setBounds(756, 250, blackWidth, blackHeight);
	        b10.putClientProperty("Synthetica.background", Color.BLACK);
    		b10.putClientProperty("Synthetica.background.alpha", 0.8f);
	        b11.setBounds(876, 250, blackWidth, blackHeight);
	        b11.putClientProperty("Synthetica.background", Color.BLACK);
    		b11.putClientProperty("Synthetica.background.alpha", 0.8f);
	        this.add(b1, 1, -1);
	        this.add(b2, 1, -1);
	        this.add(b3, 1, -1);
	        this.add(b4, 1, -1);
	        this.add(b5, 1, -1);
	        this.add(b6, 1, -1);
	        this.add(b7, 1, -1);
	        this.add(b8, 1, -1);
	        this.add(b9, 1, -1);
	        this.add(b10, 1, -1);
	        this.add(b11, 1, -1);
	        w1.setBounds(60, 250, whiteWidth, whiteHeight);
	        w1.putClientProperty("Synthetica.background", Color.WHITE);
    		w1.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w2.setBounds(120, 250, whiteWidth, whiteHeight);
	        w3.setBounds(180, 250, whiteWidth, whiteHeight);
	        w4.setBounds(240, 250, whiteWidth, whiteHeight);
	        w5.setBounds(300, 250, whiteWidth, whiteHeight);
	        w6.setBounds(360, 250, whiteWidth, whiteHeight);
	        w7.setBounds(420, 250, whiteWidth, whiteHeight);
	        w8.setBounds(480, 250, whiteWidth, whiteHeight);
	        w9.setBounds(540, 250, whiteWidth, whiteHeight);
	        w10.setBounds(600, 250, whiteWidth, whiteHeight);
	        w11.setBounds(660, 250, whiteWidth, whiteHeight);
	        w12.setBounds(720, 250, whiteWidth, whiteHeight);
	        w13.setBounds(780, 250, whiteWidth, whiteHeight);
	        w14.setBounds(840, 250, whiteWidth, whiteHeight);
	        this.add(w1, 0, -1);
	        this.add(w2, 0, -1);
	        this.add(w3, 0, -1);
	        this.add(w4, 0, -1);
	        this.add(w5, 0, -1);
	        this.add(w6, 0, -1);
	        this.add(w7, 0, -1);
	        this.add(w8, 0, -1);
	        this.add(w9, 0, -1);
	        this.add(w10, 0, -1);
	        this.add(w11, 0, -1);
	        this.add(w12, 0, -1);
	        this.add(w13, 0, -1);
	        this.add(w14, 0, -1);
	        ///////////////////////////////////////////////////////////////
	        /**
	        for (int i = 0; i < maxBlack; i++) {
		        if (i == 3 || i == 6 || i == 10 || i ==13) {
		            continue;
		        }
		        JButton b = new JButton();
		        b.setBackground(Color.BLACK);
		        b.setLocation(i*(whiteWidth) + (blackWidth*3/4), 250);
		        b.setSize(blackWidth, blackHeight);

		        this.add(b, 1, -1);
		    }
	        for (int i = 1; i < maxWhite; i++) {
		        JButton b = new JButton();
		        b.setBackground(Color.WHITE);
		        b.setLocation(i * whiteWidth, 250);
		        b.setSize(whiteWidth, whiteHeight);

		        this.add(b, 0, -1);
		    }
		    **/
	        /**
	        for (int i = 0; i < maxBlack; i++) {
		        int j = i % 7;
		        if (j == 2 || j == 6)
		            continue;

		        JButton b = new JButton();
		        b.setBackground(Color.BLACK);
		        b.setLocation(i*(whiteWidth) + (blackWidth*3/4), 300);
		        b.setSize(blackWidth, blackHeight);

		        this.add(b, 1, -1);
		    }
	        
	        for (int i = 0; i < maxWhite; i++) {
		        JButton b = new JButton();
		        b.setBackground(Color.WHITE);
		        b.setLocation(i * whiteWidth, 300);
		        b.setSize(whiteWidth, whiteHeight);

		        this.add(b, 0, -1);
		    }
		    **/
	        ///////////////////////////////////////////////////////////////
    		icon = new ImageIcon("resources//Images//save.png");
    		save = new JButton(icon);
    		save.setBounds(65, 0, 50, 50);
    		save.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
                
    		icon = new ImageIcon("resources//Images//open file.png");
    		open = new JButton(icon);
    		open.setBounds(0, 0, 50, 50);
    		open.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
    		icon = new ImageIcon("resources//Images//play button.png");
    		play = new JButton(icon);
    		play.setBounds(370, 0, 50, 50);
    		play.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
    		icon = new ImageIcon("resources//Images//pause button.png");
    		pause = new JButton(icon);
    		pause.setBounds(440, 0, 50, 50);
    		pause.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
    		icon = new ImageIcon("resources//Images//stop.png");
    		stop = new JButton(icon);
    		stop.setBounds(510, 0, 50, 50);
    		stop.addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	}}
                );
    		credits = new JButton("About");
    		//credits.putClientProperty("Synthetica.background", Color.RED);
    		//credits.putClientProperty("Synthetica.background.alpha", 0.20f);
    		credits.setBounds(885, 0, 74, 21);
    		credits.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e)
                {
                	JFrame credit = new JFrame("Credits");
                	credit.setBounds(600, 300, 210, 125);
                	JLabel about = new JLabel("Created by Nanyou Guan and Kwun Chan");
                	credit.add(about);
                	credit.setVisible(true);
                	credit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                	}});
    		////////////////////////////////////////////////////////////////
    		textField = new JTextField();
    		textField.setColumns(10);
    		textField.setBounds(100, 52, 800, 20);
    		textField_1 = new JTextField();
    		textField_1.setColumns(10);
    		textField_1.setBounds(100, 80, 800, 20);
    		textField_2 = new JTextField();
    		textField_2.setColumns(10);
    		textField_2.setBounds(100, 105, 800, 20);
    		textField_3 = new JTextField();
    		textField_3.setColumns(10);
    		textField_3.setBounds(100, 133, 800, 20);
    		textField_4 = new JTextField();
    		textField_4.setColumns(10);
    		textField_4.setBounds(100, 159, 800, 20);
    		textField_5 = new JTextField();
    		textField_5.setColumns(10);
    		textField_5.setBounds(100, 183, 800, 20);
    		textField_6 = new JTextField();
    		textField_6.setColumns(10);
    		textField_6.setBounds(100, 208, 800, 20);
    		////////////////////////////////////////////////////////////////
    		lblPiano = new JLabel("Piano");
    		lblPiano.setBounds(17, 54, 46, 14);
    		lblPiano_1 = new JLabel("Piano 2");
    		lblPiano_1.setBounds(17, 79, 46, 14);
    		lblDoubleBass = new JLabel("Double Bass");
    		lblDoubleBass.setBounds(17, 104, 70, 20);
    		lblDoubleBass_1 = new JLabel("Double Bass 2");
    		lblDoubleBass_1.setBounds(17, 135, 74, 14);
    		lblSnareDrum = new JLabel("Snare Drum");
    		lblSnareDrum.setBounds(17, 160, 70, 14);
    		lblBassDrum = new JLabel("Bass Drum");
    		lblBassDrum.setBounds(17, 185, 58, 14);
    		lblClick = new JLabel("Click");
    		lblClick.setBounds(17, 210, 27, 14);
    		////////////////////////////////////////////////////////////////
    		this.add(textField);
    		this.add(textField_1);
    		this.add(textField_2);
    		this.add(textField_3);
    		this.add(textField_4);
    		this.add(textField_5);
    		this.add(textField_6);
    		this.add(lblPiano);
    		this.add(lblPiano_1);
    		this.add(lblDoubleBass);
    		this.add(lblDoubleBass_1);
    		this.add(lblSnareDrum);
    		this.add(lblBassDrum);
    		this.add(lblClick);
    		soundManager = new SoundManager();
	        this.add(open);
	        this.add(save);
	        this.add(play);
	        this.add(pause);
	        this.add(stop);
	        this.add(credits);
	        running = true;
    	} catch(Exception e) {
    		
    	}
    }

    //main loop that keeps program running
    public void mainLoop() {
        //get the current time when program starts
        long startTime = System.currentTimeMillis();
        //set runTime's starting time to startTime
        long runTime = startTime;
        //check if program is running
        while(running) {
            //calculate amount of time passed since program started
            long timePassed = System.currentTimeMillis() - runTime;
            //add the amount of time passed to runTime
            runTime += timePassed;
            //call update method
            update(timePassed);
            //get graphics object from the screen and store it in g
            //Graphics2D g = (Graphics2D)this.getGraphics();
            //paint graphics
            this.repaint();
            //dispose of graphic object
            //g.dispose();
            //update screen
            //frame.update();
            try {
                Thread.sleep(20);
            } catch(Exception ex) {
            	
            }
        }
    }

    //update animation
    public void update(long timePassed) {
    	
    }

    /**
    //paints graphics(pictures/images)
    public void paint(Graphics2D g) {
    	
    }
    **/
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//set drawing color to background color
        g.setColor(this.getBackground());
        //draw a filled rectangle starting at position 0,0(upperleft corner) with width and height of screen
        g.fillRect(0, 0, f.getWidth(), f.getHeight());
		//g.drawImage(bg, 0, 0, f.getWidth(), f.getHeight(), null);
        //change drawing color to foreground color
        g.setColor(this.getForeground());
        //g.drawString(msg, 60, 60);
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(Frame.windowWidth, Frame.windowHeight);
     }
	
	/////////////////////////////////////INPUT METHODS////////////////////////////////////////////////
	
	//method to override keyPressed method in keylistener
    public void keyPressed(KeyEvent e) {
        //stores keycode value of key pressed
        int keyCode = e.getKeyCode();
        //check if the key code is equal to the escape key's keycode
        if(keyCode == KeyEvent.VK_ESCAPE) {
            //call the stop method inherited from the class core
            stop();
        } else if(keyCode == KeyEvent.VK_SPACE) {
        	Frame.fullScreen = !Frame.fullScreen;
    		frame.apply();
        } else {
            //print out what key the user pressed
            msg = "Pressed: " + KeyEvent.getKeyText(keyCode);
            //makes the program not wait for other buttons to be pressed and uses the key
            //example of when the program waits for other buttons is when you do Ctrl+Alt+Delete)
            e.consume();
        }
    }

    //method to override keyReleased method in keylistener
    public void keyReleased(KeyEvent e) {
        //get the key code of the key released
        int keyCode = e.getKeyCode();
        //print out what key the user pressed
        msg = "Released: " + KeyEvent.getKeyText(keyCode);
        //makes the program not wait for other buttons to be pressed and uses the key
        //example of when the program waits for other buttons is when you do Ctrl+Alt+Delete)
        e.consume();
    }

    //method to override keyTyped method in keylistener
    public void keyTyped(KeyEvent e) {
        //makes the program not wait for other buttons to be pressed and uses the key
        //example of when the program waits for other buttons is when you do Ctrl+Alt+Delete)
    	e.consume();
    }

    //mouse listener
    public void mousePressed(MouseEvent e) {
        //display message when mouse is pressed
        msg = "You pressed down the mouse";
        try {
        	//soundManager.play();
        } catch(Exception ex) {
        	System.err.println(ex.getMessage());
        	ex.printStackTrace();
        }
    }

    public void mouseReleased(MouseEvent e) {
        //display message when mouse is released
        msg = "You released the mouse";
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    //mouse motion listener
    public void mouseDragged(MouseEvent e) {
        //display message when mouse is dragged
        msg = "You are dragging the mouse";
    }

    public void mouseMoved(MouseEvent e) {
        //display message when the mouse is moved
        msg = "You are moving the mouse";
    }

    //mouse wheel listener
    public void mouseWheelMoved(MouseWheelEvent e) {
        //display message when mouse wheel is moved
        msg = "You are moving the mouse wheel";
    }
	
}
