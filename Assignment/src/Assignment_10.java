import java.util.Scanner;

public class Assignment_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���");
		int floor = sc.nextInt();
		
		for (int i = floor+1; i >= 1; i--) {
			for (int j = 1; j <= floor; j++) {
				if(i <= j) {
				System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	

		
	}

}