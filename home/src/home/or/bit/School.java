package home.or.bit;

public class School {
	private String name;
	private String major;
	private int number;
	
	
	
	
	public School(String name, String major, int number) {
		super();
		this.name = name;
		this.major = major;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "School [major=" + major + ", number=" + number + "]";
	}

	
	
	
	
}
