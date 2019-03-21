package pattern;

public class Drink_main {

	public static void main(String[] args) {
		Drink d = new GreenTea();
		d.method();
		
		System.out.println();
		
		Drink d2 = new Coffee();
		d2.method();
	}

}
