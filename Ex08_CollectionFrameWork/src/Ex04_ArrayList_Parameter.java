import java.util.ArrayList;

class EmpData{
	private ArrayList alist;
	private int[] numbers;
	
	EmpData(){
		this.alist = new ArrayList();
		this.numbers = new int[10];
	}
	
	//alist >> getter(read return), setter(write)
	
	//getter
	public ArrayList getAlist() {
		return this.alist;
	}
	
	public void setAlist(ArrayList alist) {
		this.alist = alist;
	}
	
	//numbers getter setter 만들어
	public int[] getNumbers(){
		return this.numbers;
	}
	
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	
	
}
public class Ex04_ArrayList_Parameter {
	public static void main(String[] args) {
		EmpData empdata = new EmpData();
		System.out.println(empdata.toString());
		System.out.println(empdata.getAlist().toString());
		
		ArrayList li = new ArrayList();
		li.add(100);
		li.add(200);
		li.add(300);
		empdata.setAlist(li);
		System.out.println(empdata.getAlist().toString());
		
		ArrayList li2 = new ArrayList(100); //  방크기를 정해서 만들 수 있지만 잘안씀 어처피 자동정리해줌
		
		
		
		
	}
}
