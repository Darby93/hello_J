import java.util.Scanner;

public class practice_02 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("값1을 입력하세요");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("연산기호를 입력하세요");
		String opr = sc.nextLine();
		
		System.out.println("값2을 입력하세요");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int result = 0;
		
		
		if (opr.equals("+")) {
			result = num1 + num2;
		}else if(opr.equals("-")){
			result = num1 - num2;
		}else if(opr.equals("/")){
			result = num1 / num2;
		}else if(opr.equals("*")){
			result = num1 * num2;
		}else if(opr.equals("%")){
			result = num1 % num2;
		}else {
			System.out.println("제대로 된 연산기호가 아닙니다");
		 return;
		 }
		
		System.out.println(result);
		
		
		
		
		
	}
	
	
	
	
	

}
