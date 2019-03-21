import java.util.ArrayList;

import home.or.bit.School;

public class ArrayList01_pr {

	public static void main(String[] args) {
		ArrayList intarr = new ArrayList();
		intarr.add(1);
		intarr.add(2);
		intarr.add("진호");
		intarr.add("바보");
		
		for(Object arr : intarr) {
			System.out.println(arr);
		}
		

		
		intarr.remove(0);
		intarr.remove(0);

		
		System.out.println(intarr.toString());
		
		
		intarr.add(0, "hello");

		
		
		
		for(Object arr : intarr) {
			System.out.println(arr);
		}
		

		
		ArrayList<School> arr2 = new ArrayList<School>();
		
		
		
		
		for(School arr : arr2) {
			System.out.println(arr.toString());
		}
	}

}
