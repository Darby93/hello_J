import java.util.Scanner;

/*
 * ������ ��Ģ ����� (+, -, *, /) 
 * �Է°� 3�� (�Է°��� nextLine() �޾Ƽ� �ʿ��ϴٸ� ���� ��ȯ)
 * ���� : Integer.parseInt(), equals()
 * ȭ��
 * >�Է°� : 100
 * >�Է°�(��ȣ): +
 * >�Է°�: 600
 * >������ : 700
 * 
 * ----------------
 * >�Է°� : 100
 * >�Է°�(��ȣ): -
 * >�Է°�: 100
 * >������ : 0
 * 
 * ��ȣ�޴� ��)
 * String opr = sc.nextLine();
 * 
 * hint) if(){} else if(){}
 * hint) if(opr == "+"){ ���ϱ� �����Ұž�} (xxxx)
 * hint) if (opr.equals("+")) { ���ϱ� ����}
 */
public class Ex09_operation_Quiz {

	public static void main(String[] args) {
		
//		String str = "+";
//		if(str.equals("+")) {
//			System.out.println("+");
//		}
//		
//		int i = 100;
//		if(i == 100) {
//			System.out.println(i);
//		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� �Է��ϼ���");
		int number1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("��ȣ�� �Է��ϼ���");
		String opr = sc.nextLine();
		
		System.out.println("���� �Է��ϼ���");
		int number3 = Integer.parseInt(sc.nextLine());
		
		int result = 0;


		
		if (opr.equals("+")) {   //���ڴ�  ==   ���ڴ� opr.equals("?")
			result = number1 + number3;
		}else if(opr.equals("-")){
			result = number1-number3;
		}else if(opr.equals("*")){
			result = number1*number3;
		}else if(opr.equals("/")){
			result = number1/number3;
		}else {
			System.out.println("�������� �ʴ� ������ �Դϴ�");
			//key point (���⼭�� main �Լ�)
			//return Ű���� : [�Լ�����]�� ������ > main �Լ� Ż�� > ����
			return;
		}
		
		System.out.printf("%d %s %d = %d", number1, opr, number3, result);
		
		
		

	}

}
