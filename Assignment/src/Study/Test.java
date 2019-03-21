package Study;

public class Test {
	public int a;
	private int b;
	
	public int getB() {  //read
		return b;
	}
	public void setB(int b) {  //write
		this.b = b;
	}
	
	private void add() {
		System.out.println(2+3);
	}
	private int add2() {
		return 2+3;
	}
	private void add3(int a, int b) {
		System.out.println(a+b);
	}
	public int add4(int a, int b) {
		return a+b;
	}
	
	
	
}
