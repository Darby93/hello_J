import java.util.Scanner;

public class Ex08_Printf_format {

	public static void main(String[] args) {
		//java.lang package �Ʒ� �ִ� �ڿ� (import) ���� ���� ���� ��� ����
		//default open �Ǿ� �־
		//C# : Console.WriteLine()
		//C# : Console.ReadLine()
		
		//java : System.out.println();
		System.out.println("A"); //�ٹٲ�
		System.out.print("B");
		System.out.print("C");
		System.out.println("D");
		System.out.println("S");
		
		int num = 100;
		System.out.println(num);
		
		//����(format) ���� (���)
		//%d (10���� ������ ����)
		//%f (�Ǽ���)
		//%s (���ڿ�)
		//%c (����)
		//Ư������ : \t (��Ű) , \n (�ٹٲ�)
		
		System.out.printf("num ���� : %d �Դϴ�\n", num);
		System.out.printf("num�� ���� [%d] �Դϴ�. �׸��� [%d]\n", num, 1000);
		
		float f = 3.14f;
		System.out.println(f);
		System.out.printf("f ���� ���� : %f �Դϴ� \n", f);
		
		System.out.printf("���ڿ� ���� %s�� ����ϰ� %d ���� ���� ���","�ȳ���", 100);
		
		//cmd (console)���� ����ڰ� �Է��� ���� read ����
		//java.util.Scanner sc = new java.util.Scanner(System.in);
		//�� �ڵ�ó�� Ŭ������ ����Ҷ�� ���� (package)�� ���� ���ƾ� �մϴ�
		//���� ������ ��ܿ� : import java.util;
		Scanner sc = new Scanner(System.in); //�Է°��� ���� �� �ִ�
		System.out.println("\n\n���� �Է��ϼ���");
		String value = sc.nextLine(); // ����ڰ� �Է��� ���� read
		System.out.println("�Է°� : " + value);
		
		//System.out.println("���ڰ��� �Է��ϼ���");
		//int number = sc.nextInt(); // ���ڰ����� read
		//System.out.println("number : " + number);
		
		//sc.hasNextFloat(); Type ���� read �ϴ� �Լ��� �����Ѵ�
		//������ �ϴ� nextLine(); ���!! ��������
		//������� : �׳� ���ڷ� read�ؼ� �ʿ��ϴٸ� ����ȯ�� ����Ѵ�
		//TodayPoint 
		//�١ڡ١�[[[���ڸ� -> ���ڷ�]]]�١ڡ١�
		//Integer.parseInt(s); ���ڸ� ������ 
		//Float.parseFloat(s); ���ڸ� �Ǽ���
		//Double.parseDouble(s); ���ڸ� �Ǽ���
		/////////////////////////////////////////////////
		System.out.println("���ڸ� �Է��ϼ���");
		int number1 = Integer.parseInt(sc.nextLine());
		number1 += 100;
		
		

		
		System.out.println("���� : " + number1);
		
		//���ڸ� -> ���ڸ� (���� ����)
		String data = String.valueOf(1000);
		data +=100;
		System.out.println(data);

	}

}