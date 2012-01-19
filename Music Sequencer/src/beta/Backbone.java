package beta;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import lol.FileRW;


public class Backbone extends JLayeredPane implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {
	public static boolean running;
	protected Frame frame;
	private String msg;//string to hold words
	private JFrame f;
	private BufferedImage bg;
	private File bgFile;
	private SoundManager soundManager;
	private JButton stop, save, open, credits, play, pause;
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
    	try { x = new FileRW("nanyou");
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
	        //set background color to black
	        this.setBackground(Color.white);
	        //set foreground color to white
	        this.setForeground(Color.black);
	        f.addKeyListener(this);
	        f.addMouseListener(this);
	        f.addMouseMotionListener(this);
	        f.addMouseWheelListener(this);
	        ///////////////////////////////////////////////////////////////
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
    		save.setBounds(65, 0, 58, 21);
    		icon = new ImageIcon("resources//Images//open file.png");
    		open = new JButton(icon);
    		open.setBounds(0, 0, 58, 21);
    		icon = new ImageIcon("resources//Images//play button.png");
    		play = new JButton(icon);
    		play.setBounds(370, 0, 58, 21);
    		icon = new ImageIcon("resources//Images//pause button.png");
    		pause = new JButton(icon);
    		pause.setBounds(440, 0, 58, 21);
    		icon = new ImageIcon("resources//Images//stop.png");
    		stop = new JButton(icon);
    		stop.setBounds(510, 0, 58, 21);
    		credits = new JButton("About");
    		credits.setBounds(885, 0, 74, 21);
    		////////////////////////////////////////////////////////////////
    		textField = new JTextField();
    		textField.setColumns(10);
    		textField.setBounds(this.getWidth()/4, 22, 480, 20);
    		textField_1 = new JTextField();
    		textField_1.setColumns(10);
    		textField_1.setBounds(this.getWidth()/4, 50, 480, 20);
    		textField_2 = new JTextField();
    		textField_2.setColumns(10);
    		textField_2.setBounds(this.getWidth()/4, 75, 480, 20);
    		textField_3 = new JTextField();
    		textField_3.setColumns(10);
    		textField_3.setBounds(this.getWidth()/4, 103, 480, 20);
    		textField_4 = new JTextField();
    		textField_4.setColumns(10);
    		textField_4.setBounds(this.getWidth()/4, 129, 480, 20);
    		textField_5 = new JTextField();
    		textField_5.setColumns(10);
    		textField_5.setBounds(this.getWidth()/4, 153, 480, 20);
    		textField_6 = new JTextField();
    		textField_6.setColumns(10);
    		textField_6.setBounds(this.getWidth()/4, 178, 480, 20);
    		////////////////////////////////////////////////////////////////
    		lblPiano = new JLabel("Piano");
    		lblPiano.setBounds(17, 24, 46, 14);
    		lblPiano_1 = new JLabel("Piano 2");
    		lblPiano_1.setBounds(17, 49, 46, 14);
    		lblDoubleBass = new JLabel("Double Bass");
    		lblDoubleBass.setBounds(17, 74, 70, 20);
    		lblDoubleBass_1 = new JLabel("Double Bass 2");
    		lblDoubleBass_1.setBounds(17, 105, 74, 14);
    		lblSnareDrum = new JLabel("Snare Drum");
    		lblSnareDrum.setBounds(17, 130, 70, 14);
    		lblBassDrum = new JLabel("Bass Drum");
    		lblBassDrum.setBounds(17, 155, 58, 14);
    		lblClick = new JLabel("Click");
    		lblClick.setBounds(17, 180, 27, 14);
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
