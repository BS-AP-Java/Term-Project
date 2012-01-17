package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JButton btnButton = new JButton("button1");
		sl_panel.putConstraint(SpringLayout.NORTH, btnButton, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnButton, 10, SpringLayout.WEST, panel);
		panel.add(btnButton);
		
		JButton btnButton_1 = new JButton("button2");
		sl_panel.putConstraint(SpringLayout.NORTH, btnButton_1, 0, SpringLayout.NORTH, btnButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnButton_1, 6, SpringLayout.EAST, btnButton);
		panel.add(btnButton_1);
		
		JButton btnButton_2 = new JButton("button3");
		sl_panel.putConstraint(SpringLayout.NORTH, btnButton_2, 0, SpringLayout.NORTH, btnButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnButton_2, 6, SpringLayout.EAST, btnButton_1);
		panel.add(btnButton_2);
	}
}
