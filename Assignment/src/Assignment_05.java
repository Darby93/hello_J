
public class Assignment_05 {

	public static void main(String[] args) {
		for (int i = 4; i <= 6; i++) {
			for (int j = 6; j >= 5; j--) {
				if (i >= j) {
				System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			for (int k = 4; k <= 6; k++) {
				if (i >= k) {
				System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
