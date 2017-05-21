package flowerymeadow;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TextPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	
	public TextPanel(String text) {
		this.text = text;
		this.setFocusable(true);
		repaint();
		this.setSize(50,50);
		this.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(text, 20, 25);
	}

}
