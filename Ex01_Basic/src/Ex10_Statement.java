
public class Ex10_Statement {
	public static void main(String[] args) {
		/*
		 ���
		 ���ǹ�(�б⹮) : if(����, else, else if), switch() case break....
		 �ݺ��� : for(�ݺ�Ƚ���� ��Ȯ), while(���Ǹ���ġ�ϸ� ���ѷ���), do~while()����������
         break(��Ż��), continue(�Ʒ� ���� skip)
		*/
		
		int count = 0; // local variable (�ʱ�ȭ �ʿ�)
		if (count < 1) {
			System.out.println("True");
		}
		
		
		if (count < 1) System.out.println("True {����}"); 
		// �߰��� ���̵� ������
		
		char data = 'A';  //���ǰ����� : ����, char, String ����
		switch(data) {
			case 'A' : System.out.println("���ں�");
				break;
			default : System.out.println("default");
		}
		
		//�ݺ���
		int sum = 0;
		for(int i = 0; i <= 10; i++) {
			//System.out.println("i :" + i);
			//sum = sum + i
			sum += i;
		}
		System.out.println("1���� 10���� �� : " + sum);
		
		
		//for ���� ����ؼ� 1~10 ������ Ȧ���� ���� ���غ�����
		//for�� �ܿ� �ٸ� ������� ������� ������ (if(x))
		
		int sum1 = 0;
		for (int i = 1; i <= 10; i+=2) {
			//System.out.println("i :" + i);
			sum1 += i;
		}
		System.out.println(sum1); // (1~10���� Ȧ���� ��)
		
		//1~100���� ¦���� ��
		
		int sum2 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i%2 != 0) {
				sum2+=i;
			}
			
		}
		System.out.println(sum2);
		
		//�Ի���� ��ǥ���� ���� (������) : ����
		//for�� (��ø) >> �����
		
		for (int i = 2; i<=9; i++) {
			for (int j = 1; j<=9; j++) {
				//System.out.println("i : " + i+"  j : "+j);
				System.out.printf("[%d]*[%d] = [%d]\t\n", i, j, i*j);
			}
			System.out.println();
		}
		System.out.println("****************************************************");
		
		// Key Point (break(Ż��), continue(��ŵ))
		for (int i = 2; i<=9; i++) {
			for (int j = 1; j<=9; j++) {
				//if( i == j)
				//	continue; //�Ʒ� ������ skip (�׳� �Ѿ��)
				if (i == j) break;
				System.out.printf("[%s]\t", "*");
				//System.out.printf("[%d]*[%d] = [%d]\t", i, j, i*j);
			}
			System.out.println();
		}
		
		
		for (int i = 2 ; i <= 9; i++) {
			for(int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 100; i >= 0; i--) { //���۰��� ū ������
			System.out.println("i : " + i);
			
		}
		
		//��̷� ..(�Ǻ���ġ).. ����ó��
		System.out.println("�Ǻ���ġ");
		int a = 0, b = 1, c = 0;
		
		for(int i = 0; i <= 9 ; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println(" " + c);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
