package flowerymeadow;

public class Cell {
	
	private int y;
	private int x;
	private boolean cover;
	private boolean bomb;
	private int help;
	private boolean flag;
	
	public Cell(int y, int x) {
		this.y = y;
		this.x = x;
		bomb = false;
		cover = true;
		help = 0;
		flag = false;
	}
	
	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}
	public boolean isBomb() {
		return bomb;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void setCover(boolean cover) {
		this.cover = cover;
	}
	public boolean isCover() {
		return cover;
	}

	public void setHelp(int help) {
		this.help = help;
	}
	
	public int getHelp() {
		return help;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
