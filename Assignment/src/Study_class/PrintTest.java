package Study_class;

import Study.Test;

public class PrintTest {
	public static void main(String [] args) {
		Test test = new Test();
		test.a = 3;
		test.setB(4);
		System.out.println(test.getB());
		System.out.println(test.a);
		
		System.out.println(test.add4(2, 3));
		
	}
}
