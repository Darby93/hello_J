import java.util.Scanner;

public class practice_01 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��1�� �Է��ϼ���");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("�����ȣ�� �Է��ϼ���");
		String opr = sc.nextLine();
		
		System.out.println("��2�� �Է��ϼ���");
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
			System.out.println("����� �� �����ȣ�� �ƴմϴ�");
		 return;
		 }
		
		System.out.println(result);
		
		
	}
	
	
	
	
	

}