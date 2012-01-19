package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Nanyou extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nanyou frame = new Nanyou();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Nanyou() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 469);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JButton btnPlay = new JButton("Play");
		mnMenu.add(btnPlay);
		
		JButton btnPause = new JButton("Pause");
		mnMenu.add(btnPause);
		
		JButton btnOpen = new JButton("Open");
		mnMenu.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		mnMenu.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		mnMenu.add(btnExit);
		
		JButton btnAbout = new JButton("About");
		mnMenu.add(btnAbout);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPiano = new JLabel("Piano");
		lblPiano.setBounds(17, 24, 46, 14);
		panel.add(lblPiano);
		
		JLabel lblPiano_1 = new JLabel("Piano 2");
		lblPiano_1.setBounds(17, 49, 46, 14);
		panel.add(lblPiano_1);
		
		JLabel lblDoubleBass = new JLabel("Double Bass");
		lblDoubleBass.setBounds(17, 74, 58, 20);
		panel.add(lblDoubleBass);
		
		JLabel lblDoubleBass_1 = new JLabel("Double Bass 2");
		lblDoubleBass_1.setBounds(17, 105, 74, 14);
		panel.add(lblDoubleBass_1);
		
		JLabel lblSnareDrum = new JLabel("Snare Drum");
		lblSnareDrum.setBounds(17, 130, 56, 14);
		panel.add(lblSnareDrum);
		
		JLabel lblBassDrum = new JLabel("Bass Drum");
		lblBassDrum.setBounds(17, 155, 58, 14);
		panel.add(lblBassDrum);
		
		JLabel lblClick = new JLabel("Click");
		lblClick.setBounds(17, 180, 27, 14);
		panel.add(lblClick);
		
		textField = new JTextField();
		textField.setBounds(95, 22, 480, 17);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 50, 480, 17);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(95, 75, 480, 18);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(95, 103, 480, 17);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(95, 129, 480, 15);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(95, 153, 480, 17);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(95, 178, 480, 17);
		panel.add(textField_6);
		
		JButton button = new JButton("New button");
		button.setBounds(17, 242, 27, 128);
		panel.add(button);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(2, 242, 27, 168);
		panel.add(btnNewButton);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(36, 242, 27, 168);
		panel.add(button_1);
	}
}
