import java.util.Scanner;

//�ݺ���(while, do~while)
public class Ex11_Statement {

	public static void main(String[] args) {
//		while(true) {   ���ѷ���
//			System.out.println("True");
//		}
		
		int i =1;
		while (i >= 10) { // ���� True�ϵ���  �۾���
			System.out.println(i);
			//�ݵ�� ���ο��� ������� ������ ó���� �ؾ���
			i--;
		}
		
		//1~100������ ��
		int sum = 0;
		int j = 1;
		while(j <= 100) {
			//j++; //����^^ 5150
			sum += j;
			
			j++; //5050
		}
		
		System.out.println("1~100������ : " + sum);
		
		
		//while ������ ������ (ó�� �Ͻô� �� : for)
		int o = 0;
		int k = 2;
		while(k <= 9) {
			o = 1;
			while ( o <=9 ) {
				System.out.printf("[%d] * [%d] = [%d] ", k,o,k*o);
				o++;
			}
			System.out.println();
			k++;
			
		}
		
		//do ~ while() : ������ ���� ( ������ �ѹ� ���� �� ���� ���� �Ǵ�)
		//do {���๮} while(���ǽ�)
		//�޴�����
		//1.�λ�
		//2.�޿�
		//1�Է��ϸ� �λ� .... 2�Է��ϸ� �޿� .... 3���Է��ϸ� �ٽ��Է�
		Scanner sc = new Scanner(System.in);
		int inputdata = 0;
		do {
			System.out.println("���� �Է���(0~10)");
			inputdata = Integer.parseInt(sc.nextLine());
		}while(inputdata > 10) ; //while true ��� �ݺ�
		// while�� Ż���� ������ false�� ��
			System.out.println("����� �Է��� ���ڴ� : " + inputdata);
		
		
		
	}

}
