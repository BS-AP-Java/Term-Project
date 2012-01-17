package app;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class UserInterface extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserInterface() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		Box horizontalBox = Box.createHorizontalBox();
		springLayout.putConstraint(SpringLayout.NORTH, horizontalBox, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, horizontalBox, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, horizontalBox, 58, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, horizontalBox, -10, SpringLayout.EAST, this);
		add(horizontalBox);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JButton btnOpen = new JButton("Open");
		horizontalBox.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		horizontalBox.add(btnSave);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		JButton btnPlay = new JButton("Play");
		horizontalBox.add(btnPlay);
		
		JButton btnPause = new JButton("Pause");
		horizontalBox.add(btnPause);
		
		JButton btnStop = new JButton("Stop");
		horizontalBox.add(btnStop);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_3);
		
		JButton btnOptions = new JButton("Options");
		horizontalBox.add(btnOptions);
		
		JButton btnAbout = new JButton("About");
		horizontalBox.add(btnAbout);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, horizontalBox);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
		add(scrollPane);

	}
}
