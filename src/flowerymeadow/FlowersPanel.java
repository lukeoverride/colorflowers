package flowerymeadow;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FlowersPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private FlowersMainPanel flowersMainPanel;


	public FlowersPanel(int y, int x) {
		this.y = y;
		this.x = x;
		setBackground(Color.BLUE);
		setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON3) {
					//FIXME incorporare il cambio colore nell'update in base al valore di "flag"
					Cell cell = flowersMainPanel.getCoreFloweryMeadow().getCells().get(FlowersPanel.this.y).get(FlowersPanel.this.x);
					int availableFlowers = flowersMainPanel.getCoreFloweryMeadow().getAvailableFlowers();
					if (cell.isFlag()) {
						FlowersPanel.this.setBackground(Color.BLUE);
						cell.setFlag(false);
						flowersMainPanel.getCoreFloweryMeadow().setAvailableFlowers(++availableFlowers);
					}

					else if (cell.isCover()) {
						FlowersPanel.this.setBackground(Color.RED);
						cell.setFlag(true);
						flowersMainPanel.getCoreFloweryMeadow().setAvailableFlowers(--availableFlowers);
					}

				}

				else {

					FlowersPanel.this.flowersMainPanel.getCoreFloweryMeadow().discoverCells(FlowersPanel.this.y, FlowersPanel.this.x);
					flowersMainPanel.updateAllPanels();

					if (FlowersPanel.this.flowersMainPanel.getCoreFloweryMeadow().getCells().get(FlowersPanel.this.y).get(FlowersPanel.this.x).isBomb())
					{	
						JOptionPane.showMessageDialog(FlowersPanel.this, "Game Over");
					}
					else
					{
//						FlowersPanel.this.add(new TextPanel(""+FlowersPanel.this.flowersMainPanel.getCoreFloweryMeadow().countAdjacentFlowers(FlowersPanel.this.y, FlowersPanel.this.x)));
						FlowersPanel.this.flowersMainPanel.getCoreFloweryMeadow().getCells().get(FlowersPanel.this.y).get(FlowersPanel.this.x).getHelp();
					}
				}
			}
		});

	}



	public void update() {

		Cell cell = this.flowersMainPanel.getCoreFloweryMeadow().getCells().get(y).get(x);
		if (!cell.isCover()) {
			if (cell.getHelp() == 0)
				this.setBackground(Color.LIGHT_GRAY);
			else {
				this.add(new TextPanel(""+cell.getHelp()));
				repaint();
			}
		}
	}


	public void setFlowersMainPanel(FlowersMainPanel flowersMainPanel) {
		this.flowersMainPanel = flowersMainPanel;
	}



}
