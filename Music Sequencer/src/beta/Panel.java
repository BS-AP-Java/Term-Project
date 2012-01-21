//********************************************************************
//Panel.java      
//Author: Kwun Chan and Nanyou Guan
// 
// 
//********************************************************************
package beta;

import java.awt.*;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        g.setColor(Color.BLACK);
        g.drawString("Testing", 60, 60);
     }
	
     @Override
     public Dimension getPreferredSize() {
        return new Dimension(Frame.windowWidth, Frame.windowHeight);
     }

}
