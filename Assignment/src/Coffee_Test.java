import java.util.Scanner;

public class Coffee_Test {

	public static void main(String[] args) {
//		int inputMoney;
		Scanner sc = new Scanner(System.in);
//    	System.out.println("���� ��������");
//    	inputMoney = Integer.parseInt(sc.nextLine());
//    	System.out.println(inputMoney + "���� �����̽��ϴ�.");
		System.out.println("�����Է�");
		do {
		try {
			int money = Integer.parseInt(sc.nextLine());
			break;
		}catch(NumberFormatException e){
			System.out.println("�ٽ� �Է����ּ���");
		}
		} while(true);
		
	}

}
