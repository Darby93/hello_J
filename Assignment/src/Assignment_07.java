import java.util.Scanner;

public class Assignment_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int floor = sc.nextInt();
		
		for(int i = 0; i < floor; i++) {
			for(int j = 0; j < floor-1-i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
