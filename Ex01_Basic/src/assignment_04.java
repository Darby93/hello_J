
public class assignment_04 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 0; i <= 20; i++) {
			if (i%2 != 0) {
				if (i%3 !=0) {
					sum +=i;
				}
			}
			
		}
		
		System.out.println(sum);
		
		
	}

}
