package flowerymeadow;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ResultsPanel extends JPanel {

	private JButton probabilityButton;
	private JTable tableProb;
	private int numberOfFreeCells;
	Set<CellOutput> resultCells;
	private Intelligence intelligence;

	public ResultsPanel(Set<CellOutput> resultCells, Intelligence intelligence) {

		this.intelligence = intelligence;
		this.setLayout(new BorderLayout());
		this.probabilityButton = new JButton("USE PROBABILITY");
		this.add(probabilityButton,BorderLayout.SOUTH);
	
		
		this.probabilityButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<CellOutput> totalCells = ResultsPanel.this.intelligence.createCombinationsForProbability();
				System.out.println("il numero totale di celle ottenute è "+totalCells.size());
				
				//FIXME delegare coreflowerymeadow per le righe seguenti
				//intelligence contiene coreflowerymeadow, io contengo intelligence
				FlowNumber number = new FlowNumber();
				int [][] matrix = ResultsPanel.this.intelligence.getCoreFloweryMeadow().getMatrixProbability(totalCells, number);
				
				
				
				//tableProb = new JTable(81,3);
				
				System.out.println("Probabilities to find a flower are: ");
				
				int k = 0;
				for (int i = 0; i < 9; i++) {
					for (int j = 0 ; j < 9; j++){
						
						System.out.print((double) matrix[i][j]/number.n+" ");
						ResultsPanel.this.tableProb.setValueAt((double) matrix[i][j]/number.n, k, 0);
						tableProb.setValueAt(i, k, 1);
						tableProb.setValueAt(j, k, 2);
						k++;
					}
				}
				
				System.out.println("Numero totale è "+number.n);
				
			/*	Iterator<CellOutput> iter = resultCells.iterator();
				int i = 0;
				while(iter.hasNext()) {
					CellOutput cell = iter.next();
					table.setValueAt(cell.getY(), i, 0);
					table.setValueAt(cell.getX(), i, 1);
					i++;
					}*/
				
				
				tableProb.setVisible(true);
				ResultsPanel.this.repaint();
				
			}
		});
		
		
		this.probabilityButton.setEnabled(false);
		this.setVisible(true);
		this.resultCells = resultCells;

		if (resultCells.size() == 0) {
			System.out.println("qui");
			JLabel emptyLabel = new JLabel("No results are available. You can use probability");
			this.add(emptyLabel,BorderLayout.NORTH);
			this.probabilityButton.setEnabled(true);
			tableProb = new JTable(81,3);
			this.add(tableProb,BorderLayout.CENTER);
			//tableProb.setVisible(false);
		}
		else {
			
			JLabel emptyLabel = new JLabel("Free cells are:");
			this.add(emptyLabel,BorderLayout.NORTH);
			JTable table = new JTable(this.resultCells.size(),2);
			
			Iterator<CellOutput> iter = resultCells.iterator();
			int i = 0;
			while(iter.hasNext()) {
				CellOutput cell = iter.next();
				table.setValueAt(cell.getY(), i, 0);
				table.setValueAt(cell.getX(), i, 1);
				i++;
				}
			
			this.add(table,BorderLayout.CENTER);
			
		}


	}

}
