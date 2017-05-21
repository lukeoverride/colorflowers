package flowerymeadow;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowersFrame extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowersMainPanel flowersMainPanel;
	private ResultsPanel resultsPanel;
	private Intelligence intelligence;
	
	public FlowersFrame() {
		flowersMainPanel = new FlowersMainPanel(9, 9);
		this.setLayout(new BorderLayout());
		this.add(flowersMainPanel,BorderLayout.CENTER);
		JButton help = new JButton("HELP!");
		this.add(help,BorderLayout.SOUTH);
		intelligence = new Intelligence(flowersMainPanel.getCoreFloweryMeadow());
		
		help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Set<CellOutput> resultsCells = intelligence.createInputForDLV();
				JFrame resultsFrame = new JFrame();
				int numberOfFreeCells = 0;
				if (resultsCells != null)
					numberOfFreeCells = resultsCells.size();
				resultsPanel = new ResultsPanel(resultsCells,intelligence);
				resultsFrame.add(resultsPanel);
				resultsFrame.pack();
				resultsFrame.setVisible(true);
			}
		});
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		FlowersFrame flowersFrame = new FlowersFrame();
	}
	

}
