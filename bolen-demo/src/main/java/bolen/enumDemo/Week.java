package bolen.enumDemo;

public enum Week {
	
	Tuesday(2,"星期二"),
	Monday(1,"星期一"),
	Wednesday(3,"星期三")
	;
	
	private int seq;
	private String name;

	private Week(int day,String name) {
		this.seq = day;
		this.name=name;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
