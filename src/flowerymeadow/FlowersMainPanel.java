package flowerymeadow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowersMainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowersPanel[][] panels;
	private final int WIDTH;
	private final int HEIGHT;
	private CoreFloweryMeadow coreFloweryMeadow;
	
	

	public FlowersMainPanel(int width, int length) {
		
		this.WIDTH = width;
		this.HEIGHT = length;

		this.setLayout(new GridLayout(this.WIDTH,this.HEIGHT)); //set layout
		panels = new FlowersPanel[this.WIDTH][this.HEIGHT];
		
		this.coreFloweryMeadow = new CoreFloweryMeadow(this.WIDTH,this.HEIGHT);
		
		for (int i = 0; i < this.HEIGHT; i++){
			for (int j = 0; j < this.WIDTH; j++){
				panels[i][j] = new FlowersPanel(i,j);
				panels[i][j].setPreferredSize(new Dimension(50, 50));
				panels[i][j].setFocusable(true);
				panels[i][j].setFlowersMainPanel(this);
				this.add(panels[i][j]);
			}
		}
//		
//		this.pack(); //sets appropriate size for frame
		
//		this.add(new JButton("HELP!"));
		this.setVisible(true);
	}
	
	public void updateAllPanels(){
		for (int i = 0; i < this.HEIGHT; i++)
			for (int j = 0; j < this.WIDTH; j++){
				panels[i][j].update();
			}
			
	}

	public CoreFloweryMeadow getCoreFloweryMeadow() {
		return coreFloweryMeadow;
	}
	
	
	
}
