import java.util.Scanner;

public class Assogment_08 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���");
		int floor = sc.nextInt();
		
		for (int i = 0; i <= floor; i++) {
			for (int j = 0; j <= floor-1-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
