package flowerymeadow;

import java.util.ArrayList;

public class CoreFloweryMeadow {


	private final int WIDTH;
	private final int HEIGHT;
	//	private Cell[][] cells;
	private ArrayList<ArrayList<Cell> > cells;
	private int availableFlowers = 10;

	public CoreFloweryMeadow(int width, int length) {
		this.WIDTH = width;
		this.HEIGHT = length;

		cells = new ArrayList<ArrayList<Cell> >();

		for (int i = 0; i < HEIGHT; i++)
			cells.add(i, new ArrayList<Cell>());

		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++)
				cells.get(i).add(new Cell(i, j));

		//		for (int i = 0; i < HEIGHT; i++)
		//			for (int j = 0; j < WIDTH; j++)
		//				System.out.println(cells.get(i).get(j));

		insertBombs();

	}

	private void insertBombs() {

		//		cells[2][2].setBomb(true);
		//		cells[1][4].setBomb(true);
		//		cells[5][1].setBomb(true);
		//		cells[8][2].setBomb(true);

		//		cells.get(0).get(0).setBomb(true);
		//		cells.get(3).get(1).setBomb(true);
		//		cells.get(2).get(3).setBomb(true);
		//		cells.get(3).get(4).setBomb(true);
		//		cells.get(3).get(6).setBomb(true);
		//		cells.get(4).get(0).setBomb(true);
		//		cells.get(4).get(1).setBomb(true);
		//		cells.get(5).get(6).setBomb(true);
		//		cells.get(7).get(5).setBomb(true);
		//		cells.get(8).get(7).setBomb(true);


		//		cells.get(0).get(7).setBomb(true);
		//		cells.get(1).get(0).setBomb(true);
		//		cells.get(4).get(6).setBomb(true);
		//		cells.get(4).get(8).setBomb(true);
		//		cells.get(5).get(6).setBomb(true);
		//		cells.get(5).get(8).setBomb(true);
		//		cells.get(6).get(0).setBomb(true);
		//		cells.get(6).get(8).setBomb(true);
		//		cells.get(7).get(8).setBomb(true);
		//		cells.get(8).get(7).setBomb(true);

		for (int i = 0; i < 10; i++) {
			
			int p;
			int q;
			
			do
			{
				p = ((int) (Math.random()*10))%9; 
				q = ((int) (Math.random()*10))%9;
			}

			while (cells.get(p).get(q).isBomb());
			cells.get(p).get(q).setBomb(true);
		}


		/*	cells.get(2).get(3).setBomb(true);
		cells.get(2).get(4).setBomb(true);
		cells.get(2).get(5).setBomb(true);
		cells.get(3).get(2).setBomb(true);
		cells.get(4).get(2).setBomb(true);
		cells.get(4).get(6).setBomb(true);
		cells.get(6).get(3).setBomb(true);*/

	}

	//	public Cell[][] getCells() {
	//		return cells;
	//	}

	public ArrayList<ArrayList<Cell> > getCells() {
		return cells;
	}

	public int countAdjacentFlowers(int y, int x) {
		int count = 0;
		System.out.println(y+" "+x);
		if (y > 0 && cells.get(y-1).get(x).isBomb()) //up
			count++;
		if (y > 0 && x > 0 && cells.get(y-1).get(x-1).isBomb()) //left-up
			count++;
		if (y > 0 && x < WIDTH-1 && cells.get(y-1).get(x+1).isBomb()) //up-right
			count++;
		if (x < WIDTH-1 && cells.get(y).get(x+1).isBomb()) //right
			count++;
		if (x > 0 && cells.get(y).get(x-1).isBomb()) //left
			count++;
		if (x > 0 && y < HEIGHT-1 && cells.get(y+1).get(x-1).isBomb()) //left-down
			count++;
		if (y < HEIGHT-1 && cells.get(y+1).get(x).isBomb()) //down
			count++;
		if (x < WIDTH-1 && y < HEIGHT-1 && cells.get(y+1).get(x+1).isBomb()) //down-right
			count++;

		System.out.println(count);
		return count;

	}



	public void discoverCells(int y, int x) {
		if (y >= WIDTH || x >= HEIGHT || x < 0 || y <0 || !cells.get(y).get(x).isCover())
			return;

		cells.get(y).get(x).setCover(false);
		int help = countAdjacentFlowers(y, x);
		cells.get(y).get(x).setHelp(help);
		if (help != 0)
			return;

		discoverCells(y-1, x);
		discoverCells(y+1, x);
		discoverCells(y, x+1);
		discoverCells(y, x-1);
		discoverCells(y-1, x-1);
		discoverCells(y+1, x-1);
		discoverCells(y-1, x+1);
		discoverCells(y+1, x+1);
	}

	public int[][] getMatrixProbability(ArrayList<CellOutput> totalCells, FlowNumber number){
		int[][] matrix = new int[9][9];

		for (int i = 0; i < totalCells.size(); i++){
			CellOutput cell = totalCells.get(i);
			int y = Integer.parseInt(cell.getY());
			int x = Integer.parseInt(cell.getX());

			if (y == -1)
				number.n = x;
			else
				matrix[y][x]++;
		}

		return matrix;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public int getAvailableFlowers() {
		return availableFlowers;
	}

	public void setAvailableFlowers(int availableFlowers) {
		this.availableFlowers = availableFlowers;
	}

}
