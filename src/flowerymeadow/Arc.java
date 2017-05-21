package flowerymeadow;

public  class Arc{

	public String start;
	public String end;
	
	public Arc(String start,String end){
		this .start=start;
		this .end=end;
	}

	public String isStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
}

