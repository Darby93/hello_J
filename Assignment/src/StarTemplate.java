
public class StarTemplate {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			for (int j = i; j < 10; j++) {
				System.out.print(" ");
			}
			for (int k = 11 - i; k <= 10; k++) {
				System.out.print("3");
			}
			for (int j = 9-i; j < 10; j++) {
				System.out.print("B");
			}
			for (int k = i; k <= 10; k++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = 1; i <= 10; i++) {
			for (int j = i; j < 10; j++) {
				System.out.print(" ");
			}
			for (int k = 11 - i; k <= 10; k++) {
				System.out.print("3");
			}
			for (int j = 9-i; j < 10; j++) {
				System.out.print("B");
			}
			for (int k = i; k <= 10; k++) {
				System.out.print("7");
			}
			System.out.println();
		}
		System.out.println();

	}

}  
 