import java.util.Scanner;

public class Assignment_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���");
		int floor = sc.nextInt();
		
		for (int i = 1; i <= floor; i++) {
			for (int j = 1; i >= j ; j++) {
					System.out.print("* ");
			}
			System.out.println();
		}
	}
}