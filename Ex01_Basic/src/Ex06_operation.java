
public class Ex06_operation {
	
	public static void main(String[] args) {
		
		int result = 100/100;
		System.out.println(result);
		
		
		result = 13/2;
		System.out.println(result);
		
		result =  13%4;
		System.out.println(result);
		
		//������ ������ (++, --) 1�� ����, 1�� ����
		int i = 10;
		++i; //��ġ ����
		System.out.println(i);
		
		i++; //��ġ ����
		System.out.println(i);
		
		//���� 1�� : ��ġ, ��ġ ����
		
		//POINT : ��ġ�� ��ġ�� �����ڿ� �����ϸ� �ٸ�
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2; //j2 1������Ű�� + ����
		System.out.println(result2);
		// ������� i2 = 5,  j2 = 5, result2 = 10
	    result2 = i2 + j2++;
		// i2 = 5, j2 = 6, result2 = 10
		System.out.println(result2);
		System.out.println(j2);
		
		//POINT
		//�ڹ��� ���� ��Ģ
		//������ ��� [����]�� int�� ��ȯ �� ó��
		//byte + byte => �����Ϸ��� int + int�� ����
		byte b = 100; // -128 ~ 127
		byte c = 1;
		byte d = (byte)(b + c);
		int e = b + c;
		// 1. byte d = (byte)(b + c); ������ ���� ���� �� �ִ�.
		// 2. int d = b + c; ����
		System.out.println(e);
		
		//byte + short => int + int
		//char + char => int + int
		//POINT : ���꿡 int ���� ���� Ÿ���� int �� ��ȯ(long ����)
		//byte, char, short => int �ٲپ ���� ó��
		
		//byte + short => int + int >> ��� int
		//char + char => int + int >> ��� int
		//int + long => long + long >> ��� long
		
		//������ �Ǽ� >> �Ǽ�
		//float + int >> float + float >> float
		//long + float >> flaot + float >> float
		//float + double >> double + double >> double
		
		float num2 = 10.45f;
		int num3 = 20;
		
		// num2 + num3
		float num4 = num2 + num3;
		System.out.println(num4);
		
		//char �� ����Ÿ��
		char c2 = '!';
		char c3 = '!';
		
		//c2+c3
		int c4 = c2+c3;
		System.out.println(c4);
		
		char c5 = (char)c4;
		System.out.println(c5);
		System.out.println((char)c4);
		
		//���
		//�߼ұ�� ���蹮�� (������) ==> �����
		int sum = 0;
		for(int j = 1; j <= 100; j++) {
			//System.out.println(j);
			sum = sum + j;
			
		}
		
		System.out.println(sum);
		
		
		//1~100 ���� ¦���� ��
		int sum1 = 0;
		for(int l = 1; l <= 100; l++) {
			
			if(l%2 ==0) {
				
			sum1 += l;
			
			}
		}
		
		System.out.println(sum1);
		
		//== ������ (��(value) ���ϴ� ������)
		//javascript (===)   �������󵵵�
		if(10 == 10.0f) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		//! ����������
		if('A' != 65) { //���� �ʴ�?
			System.out.println("���� ���� �ƴϾ�");
		}else {
			System.out.println("���� ���̾�");
		}
		
		
		//�ϱ��ϱ�(POINT)
		//���ó�� ���� ������(���׿�����)�١ڡ١�
		int p = 10;
		int k = -10;
		int result4 = (p==k)?p:k; 
		//? �տ��ִ� ���ǽ��� ���̶��  : �տ� �ִ� ����
		//? �տ��ִ� ���ǽ��� �����̶�� : �ڿ� �ִ� ����
		System.out.println("result4 : " + result4);
		
		//�� ���� �����ڸ� if������ �ٲپ� ������!    ���׿����ڰ� �� ȿ�������ڵ�!
		if(p==k) {
			result4 = p;
		}else {
			result4 = k;
		}
		
		/*
              ����ǥ
         0 : false
         1 : true
		        OR ���߿� �ϳ��� ���̿��� ��      AND �Ѵ� ���̿��� ��
		 0 0     0                       0
		 0 1     1                       0
		 1 0     1                       0
		 1 1     1                       1
		 
		 sql(oracle)
		 select *
		 from emp
		 where job='sales' and sal > 2000; 
		 
		 select *
		 from emp
		 where job='sales' or sal > 2000;
		 */
		
		
		//������ ( | (or) , & (and) )
		//0 �� 1 �� bit ����
		int x = 3;
		int y = 5;
		System.out.println("x|y : " + (x|y));
		System.out.println("x&y : " + (x&y));
		//������ 3�� -> 2���������� ��ȯ
		// 128 64 32 16 8 4 2 1 
		//   0  0  0  0 0 0 1 1 (2���� : 3)
		//              0 1 0 1 (2���� : 5)
		//OR            0 1 1 1 -> 1 + 2 + 4 > 7    x|y �� 7�� ���̳���
		//AND           0 0 0 1 -> 1    x&y �� 1�� ���� ����
		
		//POINT ������ (|| (or), && (and)) ������ return boolean
		//�߿��� ���� !! �١ڡ١�
		//if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1) {���๮}
		//if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1) {���๮}
		
	}

}
