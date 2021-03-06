//********************************************************************
//Backbone.java      
//Author: Kwun Chan and Nanyou Guan
// 
// 
//********************************************************************
package beta;

//import the necessary classes 
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
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Backbone extends JLayeredPane implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {
	//declare instance variables for this class
	public static boolean running;
	protected Frame frame;
	private JFrame f;
	private SoundManager soundManager;
	private JButton save, open, credits, play, help;
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
	private JButton w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14;
	public static JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5;
	private JLabel lblPiano, lblPiano_1, lblDoubleBass, lblDoubleBass_1, lblSnareDrum, lblBassDrum, lblClick, lblChoose; 
	private ImageIcon icon;
	private int blackWidth, blackHeight, whiteWidth, whiteHeight;
	private FileRW fileRW;
	private ButtonGroup group;
	private JRadioButton rbPiano, rbDoubleBass, rbSnareDrum, rbBassDrum, rbClick; 
	
	//the constructor for the class
	public Backbone() {
	}
	
	/**********************************
    //Method Name: public void stop()
    //Method to stop the program
    //
    *********************************/
    public void stop() {
        //set running to false
        running = false;
    }

    /**********************************
    //Method Name: public void run()
    //method that calls init and mainLoop while program is running
    //
    *********************************/
    public void run() {
        try {
            //call the init method
            init();
            //call the mainLoop method
            mainLoop();
        } finally {
        	
        }
    }

    /**********************************
    //Method Name: public void init()
    //Sets up the screen 
    //
    *********************************/
    public void init() {
    	try {
    		//Create a new SoundManager object
    		soundManager = new SoundManager();
    		//create a new fileRW object
    		fileRW = new FileRW();
    		//set the width and height of the black and white keys of the piano
    		blackWidth = 48;
    		blackHeight = 140;
    		whiteWidth = 60;
    		whiteHeight = 240;
	        //construct screen object
	        frame = new Frame(this);
	        f = frame.getFrame();
	        //set the frame to have no layout
	        this.setLayout(null);
	        //set font style, type, and size
	        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	        //set background color to colbalt blue
	        this.setBackground(new Color(61, 89, 171));
	        //Add a  key listener to the frame
	        f.addKeyListener(this);
	        //add mouse listeners to the frame
	        f.addMouseListener(this);
	        //add a mouse motion listener to the frame
	        f.addMouseMotionListener(this);
	        //add a mouse wheel listener to the frame
	        f.addMouseWheelListener(this);
	        ////////////////////////////////////////////////////////////////
	        //create a jlabel saying select instrument to preview
	        lblChoose = new JLabel("Select Instrument to preview:");
	        //set the position and size of the jlabel
	        lblChoose.setBounds(40, 515, 150, 26);
	        //create radiobuttons to choose between the instruments to preview
	        rbPiano = new JRadioButton("Piano", true);
	        rbDoubleBass = new JRadioButton("Double Bass");
	        rbSnareDrum = new JRadioButton("Snare Drum");
	        rbBassDrum = new JRadioButton("Bass Drum");
	        //create a new button group
	        group = new ButtonGroup();
	        //add the radiobuttons to the button group
	        group.add(rbPiano);
	        group.add(rbDoubleBass);
	        group.add(rbSnareDrum);
	        group.add(rbBassDrum);
	        //set sizes for the radiobuttons
	        rbPiano.setBounds(200, 515, 55, 26);
	        rbDoubleBass.setBounds(260, 515, 85, 26);
	        rbSnareDrum.setBounds(350, 515, 85, 26);
	        rbBassDrum.setBounds(440, 515, 80, 26);
	        ///////////////////////////////////////////////////////////////
	        //create new JButtons for piano
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
	        //add action Listeners to the buttons of the piano
	        //if the piano radiobutton is selected set, when the buttons are pressed play the piano sound
	        //if the double bass radiobutton is selected, when the buttons are pressed play the double bass sound
	        //if the snare radio button is selected, when the buttons are pressed play the snare drum sound
	        //if the bass radio button is selected, when the buttons are pressed play the bass drum sound
	        //if the click radio button is selected, when the buttons are pressed play the click sound
	        b1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(16);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(16);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(21);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(21);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(0);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(0);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b4.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(6);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(6);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b5.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(10);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(10);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b6.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(17);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(17);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b7.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(22);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(22);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b8.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(1);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(1);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b9.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(7);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(7);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b10.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(11);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(11);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        b11.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(18);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(18);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(23);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(23);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(2);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(2);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(4);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(4);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		}
                }
            });
	        w4.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(8);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(8);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w5.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(12);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(12);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w6.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(14);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(14);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w7.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(19);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(19);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w8.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(24);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(24);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w9.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(3);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(3);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w10.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(5);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(5);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w11.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(9);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(9);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w12.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(13);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(13);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w13.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(15);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(15);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        w14.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(rbPiano.isSelected()) {
	        			soundManager.pianoPlay(20);
	        		} else if(rbDoubleBass.isSelected()) {
	        			soundManager.doubleBassPlay(20);
	        		} else if(rbSnareDrum.isSelected()) {
	        			soundManager.snareDrumPlay(0);
	        		} else if(rbBassDrum.isSelected()) {
	        			soundManager.bassDrumPlay(0);
	        		} 
                }
            });
	        ///////////////////////////////////////////////////////////////
	        //set the size and position of the buttons of the piano
	        //set the color of the buttons to black or white to make it look like a piano
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
    		//add the black keys in
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
	        w2.putClientProperty("Synthetica.background", Color.WHITE);
    		w2.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w3.setBounds(180, 250, whiteWidth, whiteHeight);
	        w3.putClientProperty("Synthetica.background", Color.WHITE);
    		w3.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w4.setBounds(240, 250, whiteWidth, whiteHeight);
	        w4.putClientProperty("Synthetica.background", Color.WHITE);
    		w4.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w5.setBounds(300, 250, whiteWidth, whiteHeight);
	        w5.putClientProperty("Synthetica.background", Color.WHITE);
    		w5.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w6.setBounds(360, 250, whiteWidth, whiteHeight);
	        w6.putClientProperty("Synthetica.background", Color.WHITE);
    		w6.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w7.setBounds(420, 250, whiteWidth, whiteHeight);
	        w7.putClientProperty("Synthetica.background", Color.WHITE);
    		w7.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w8.setBounds(480, 250, whiteWidth, whiteHeight);
	        w8.putClientProperty("Synthetica.background", Color.WHITE);
    		w8.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w9.setBounds(540, 250, whiteWidth, whiteHeight);
	        w9.putClientProperty("Synthetica.background", Color.WHITE);
    		w9.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w10.setBounds(600, 250, whiteWidth, whiteHeight);
	        w10.putClientProperty("Synthetica.background", Color.WHITE);
    		w10.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w11.setBounds(660, 250, whiteWidth, whiteHeight);
	        w11.putClientProperty("Synthetica.background", Color.WHITE);
    		w11.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w12.setBounds(720, 250, whiteWidth, whiteHeight);
	        w12.putClientProperty("Synthetica.background", Color.WHITE);
    		w12.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w13.setBounds(780, 250, whiteWidth, whiteHeight);
	        w13.putClientProperty("Synthetica.background", Color.WHITE);
    		w13.putClientProperty("Synthetica.background.alpha", 0.9f);
	        w14.setBounds(840, 250, whiteWidth, whiteHeight);
	        w14.putClientProperty("Synthetica.background", Color.WHITE);
    		w14.putClientProperty("Synthetica.background.alpha", 0.9f);
    		//add the white keys in
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
	        
	        //Create an Imageicon for the save button
	        icon = new ImageIcon("resources//Images//save.png");
	      //create the save button and set the size and position
	        save = new JButton(icon);
	        save.setBounds(65, 0, 50, 50);
	        save.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	         try {
	        fileRW.getWhereSave();
	        fileRW.writeFile();
	       } catch (IOException e1) {
	        e1.printStackTrace();
	       }}});
	        //Create an ImageIcon for the open button
	        icon = new ImageIcon("resources//Images//open file.png");
	        //Create the open button and set the size and position
	        open = new JButton(icon);
	        open.setBounds(0, 0, 50, 50);
	        open.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	          //Call the getFile method and readFileMethod
	          fileRW.getFile();
	          fileRW.readFile();
	               }
	              });
	        //Create an ImageIcon for the play button
	        icon = new ImageIcon("resources//Images//play button.png");
	        //create the play button and set size and positon
	        play = new JButton(icon);
	        play.setBounds((f.getWidth()/2)-25, 0, 50, 50);
	        play.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	          //call the play method
	          soundManager.play();
	                  }
	         });
	        //create help button
	        help = new JButton("Help");
	        help.setBounds(800, 0, 74, 21);
	        help.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		                   //When the button is pressed create a new frame  
		                   JFrame help = new JFrame("Help");
		                   //set it so it can not be resized
		                   help.setResizable(true);
		                   //set it so it is always on top
		                   help.setAlwaysOnTop(true);
		                   //set the position and size
		                   help.setBounds(682, 380, 400, 300);
		                   //create a jlabel saying Created by Nanyou Guan and Kwun Chan
		                   JLabel about = new JLabel("The Keys are referenced in numerical order from left to right");
		                   about.setBounds(0, 0, 500, 30);
		                   JLabel about1 = new JLabel("type in the note numbers for each row separated by : ex: 1:2:3:4");
		                   about1.setBounds(0, 10, 500, 30);
		                   JLabel about2 = new JLabel("111 is a rest");
		                   about2.setBounds(0, 20, 500, 30);
		                   JLabel about3 = new JLabel("save and open the file before playing it");
		                   about3.setBounds(0, 30, 500, 30);
		                   //add the jlabel in
		                   help.add(about);
		                   help.add(about1);
		                   help.add(about2);
		                   help.add(about3);
		                   //set the frame to be visible
		                   help.setVisible(true);
		                   //set it so when you close the window you end that frame
		                   help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		         }
		        });
	        //create the credit button and set size and positon
	        credits = new JButton("About");
	        credits.setBounds(885, 0, 74, 21);
	        credits.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	                   //When the button is pressed create a new frame  
	                   JFrame credit = new JFrame("Credits");
	                   //set it so it can not be resized
	                   credit.setResizable(false);
	                   //set it so it is always on top
	                   credit.setAlwaysOnTop(true);
	                   //set the position and size
	                   credit.setBounds(682, 380, 210, 125);
	                   //create a jlabel saying Created by Nanyou Guan and Kwun Chan
	                   JLabel about = new JLabel("Created by Nanyou Guan and Kwun Chan");
	                   //add the jlabel in
	                   credit.add(about);
	                   //set the frame to be visible
	                   credit.setVisible(true);
	                   //set it so when you close the window you end that frame
	                   credit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	         }
	        });
    		////////////////////////////////////////////////////////////////
    		//Create text fields for the user to type in the note and set the size and position of them
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
    		////////////////////////////////////////////////////////////////
    		//create jlabels to indicate which text field is for which instrument and set the sizes and positions
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
    		////////////////////////////////////////////////////////////////
    		//add the textfields, buttons, radiobuttons, and labels to the frame
    		this.add(textField);
    		this.add(textField_1);
    		this.add(textField_2);
    		this.add(textField_3);
    		this.add(textField_4);
    		this.add(textField_5);
    		this.add(lblPiano);
    		this.add(lblPiano_1);
    		this.add(lblDoubleBass);
    		this.add(lblDoubleBass_1);
    		this.add(lblSnareDrum);
    		this.add(lblBassDrum);
	        this.add(open);
	        this.add(save);
	        this.add(play);
	        this.add(help);
	        this.add(credits);
	        this.add(rbPiano);
	        this.add(rbDoubleBass);
	        this.add(rbSnareDrum);
	        this.add(rbBassDrum);
	        this.add(lblChoose);
	        running = true;
    	} catch(Exception e) {
    		
    	}
    }

    /**********************************
    //Method Name: public void mainLoop()
    //Main loop that keeps the program running
    //
    *********************************/
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

    //update based on time passed
    public void update(long timePassed) {
    	
    }

    /**
    //paints graphics(pictures/images)
    public void paint(Graphics2D g) {
    	
    }
    **/
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
    /**********************************
    //Method Name: public Dimension getPreferredSize()
    //Returns the dimension for the frame
    //
    *********************************/
  public Dimension getPreferredSize() {
    return new Dimension(Frame.windowWidth, Frame.windowHeight);
  }
	
	/////////////////////////////////////INPUT METHODS////////////////////////////////////////////////
	
	/**********************************
    //Method Name: public void keyPressed(KeyEvent e)
    //method to override keyPressed method in keylistener
    //Parameters: KeyEvent e -
    *********************************/
    public void keyPressed(KeyEvent e) {
        //stores keycode value of key pressed
        int keyCode = e.getKeyCode();
        //check if the key code is equal to the escape key's keycode
        if(keyCode == KeyEvent.VK_ESCAPE) {
            //call the stop method inherited from the class
            stop();
        } else if(keyCode == KeyEvent.VK_SPACE) {
        	
        } else {
            //print out what key the user pressed
            //msg = "Pressed: " + KeyEvent.getKeyText(keyCode);
            //makes the program not wait for other buttons to be pressed and uses the key
            //example of when the program waits for other buttons is when you do Ctrl+Alt+Delete)
            e.consume();
        }
    }

    /**********************************
    //Method Name: public void keyReleased(KeyEvent e)
    //method to override keyReleased method in keylistener
    //Parameters: KeyEvent e -
    *********************************/
    public void keyReleased(KeyEvent e) {
        //get the key code of the key released
        //int keyCode = e.getKeyCode();
        //print out what key the user pressed
        //msg = "Released: " + KeyEvent.getKeyText(keyCode);
        //makes the program not wait for other buttons to be pressed and uses the key
        //example of when the program waits for other buttons is when you do Ctrl+Alt+Delete)
        e.consume();
    }

    /**********************************
    //Method Name: public void keyTyped(KeyEvent e)
    //method to override keyTyped method in keylistener
    //Parameters: KeyEvent e -
    *********************************/
    public void keyTyped(KeyEvent e) {
        //makes the program not wait for other buttons to be pressed and uses the key
        //example of when the program waits for other buttons is when you do Ctrl+Alt+Delete)
    	e.consume();
    }

    /**********************************
    //Method Name: public void keyTyped(KeyEvent e)
    //Method to override mousePressed method in mouselistener
    //Parameters: MouseEvent e- 
    *********************************/
    public void mousePressed(MouseEvent e) {
        //display message when mouse is pressed
        //msg = "You pressed down the mouse";
        try {
        	//soundManager.play();
        } catch(Exception ex) {
        	System.err.println(ex.getMessage());
        	ex.printStackTrace();
        }
    }

    /**********************************
    //Method Name: public void mouseReleased(MouseEvent e)
    //Checks if the mouse button has been released
    //Parameter; MouseEvent e-
    *********************************/
    public void mouseReleased(MouseEvent e) {
    	//display message when mouse is released
    	//msg = "You released the mouse";
  	}	

  	/**********************************
  	//Method Name: public void mouseClicked(MouseEvent e)
  	//Checks if the mouse button has been clicked(pressed and released)
  	//Parameter; MouseEvent e-
   *********************************/
  	public void mouseClicked(MouseEvent e) {
  
	}

	/**********************************
  	//Method Name: public void mouseEntered(MouseEvent e)
  	//
  	//Parameter; MouseEvent e-
  	*********************************/
	public void mouseEntered(MouseEvent e) {
  
	}

	/**********************************
  	//Method Name: public void mouseExited(MouseEvent e)
  	//
  	//Parameter; MouseEvent e-
	 *********************************/
	public void mouseExited(MouseEvent e) {
  
	}

	/**********************************
  	//Method Name: public void mouseDragged(MouseEvent e)
  	//Checks if the mouse is being dragged 
  	//Parameter; MouseEvent e-
	 *********************************/
	public void mouseDragged(MouseEvent e) {
		//display message when mouse is dragged
		//msg = "You are dragging the mouse";
	}

	/**********************************
  	//Method Name: public void mouseMoved(MouseEvent e)
  	//Checks if the mouse is moved
  	//Parameter; MouseEvent e-
	 *********************************/
	public void mouseMoved(MouseEvent e) {
		//display message when the mouse is moved
		//msg = "You are moving the mouse";
	}

	/**********************************
  	//Method Name: public void mouseWheelMoved(MouseWheelEvent e)
  	//Checks if the mouse wheel is moved
  	//Parameter; MouseEvent e-
	 *********************************/
	public void mouseWheelMoved(MouseWheelEvent e) {
		//display message when mouse wheel is moved
		//msg = "You are moving the mouse wheel";
	}

}
