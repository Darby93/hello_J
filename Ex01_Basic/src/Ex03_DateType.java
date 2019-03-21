/*�ڹٴ� �ý��ۿ��� �⺻������ �����ϴ� 8���� �⺻ Ÿ���� ������ �ִ�.
 * 8���� �⺻ Ÿ���� ���� �����Ѵ�.
 * Tip) [��] �� [�ּҰ�]�� ������ �� �ִ�.
 * 
 * ���� -> ����(��������, 0, ��������) -> byte(-128 ~ 127)
 *                             -> char(�ѹ��ڸ� �����ϴ� �ڷ��� : �ѹ��ڴ� 2byte)
 *                                    unicode ü�踦 ������
 *                             -> short....(c����� ȣȯ�� ->����)
 *                             -> int(-21�� ~ 21��)*** java���� ������ �⺻Ÿ��
 *                             -> long(8byte) int���� ū��
 *      -> �Ǽ�(�ε��Ҽ���) -> float(4byte), double(8byte)                       
 *                       ���е��� ���� = ǥ�������� ũ�� *** �Ǽ� ���� �⺻Ÿ���� double    
 *      -> boolean(true, false) : ���α׷��� ���� ������ �� ���
 *      
 * �ñ��ؿ� : ���ڿ��� ǥ�� : ȫ�浿, �ȳ��ϼ��� ��� ������                            
 * String �� Ŭ���� : String s = new String("�ȳ��ϼ���");
 * �� ���� : String s = "�ȳ��ϼ���"; 
 * String ���ؼ� ������ ����� �ֱ� ������ String �� int ó�� ������!               
 * 
 * ��Ÿ�� : �޸𸮿� ���� (����, ��)
 * ����Ÿ�� : Ŭ����, �迭 �޸𸮿� ���� (�ּ� ����)
 * 
 * class == ���赵 == Ÿ�� �ڡ١ڡ�
 * class ���� Ÿ���� ��� ���� ūŸ��
 * 
 * class �� �ݵ�� �޸𸮿� �÷����� ����ؾ���(new)
 * class ù ����  �빮�ڷξ���
 */

//�ּ��� ���赵�� �ҷ���  >> �Ӽ�(��������)�� ����(�⺻)��� ������ ������ �־�� ��
//                       �Ӽ��� ������ ǥ��

class Car{
	String color; //������ ��ڴ�
	int window; //�ڵ����� â�� ����
}


public class Ex03_DateType {

	public static void main(String[] args) {
		
		Car c = new Car(); // ���ø޸𸮿� c������ ��������� heap�޸𸮿� ���� â���� �ö�
		System.out.println("c��� ������ �� : " + c); 
		                   //Car@566776ad �ּҰ�  
		
		//c. ~~~       . = �ּҸ� ã�� ������ !! 
		
		Car c2;
		c2 = c;
		System.out.println("c2��� ������ �� : " + c2);
		System.out.println(c==c2);
//		c2 = c;
//		
//		c2.color = "red"; // c�� �÷���  ����� �ٲ�  ���� �ּҸ� ������
		
		Car c3;  // ����
		c3 = new Car(); //�Ҵ� �и�
		System.out.println("c3��� ������ �� : " + c3);
		System.out.println(c==c3);
	    c3.color = "gold";
	    c3.window = 10;
		// c3 �� c�� ���� �ʴ�
		System.out.println(c3.color);
		System.out.println(c3.window);
		
		
		int i = 200;
		System.out.println(i);
		//200 �޸𸮾ȿ� ���� �������  // 
		
		int j ; // ����
		//j = i;
		j = 1000;
		//i���� ��ȭ�� ���� �״�� 200
		
		int a, b; //�ݵ�� �ʱ�ȭ �۾��� ���ľ� �Ѵ�.
		a= 10;
		b= 20;
		
		int k = 1111;
		int k2 = k;
		k = 2222; // k2�� ���� ��ȭ�� ���� !! 
		
		//int (-21�� ~ 21��)
		//int number = 10000000000; ����(������ ����) 
		//���� ���ͷ��� ǥ�������� [int] ���� �ڡ١ڡ١ڡ١ڡ�
		//���� ���ͷ� >> ǥ���� �� �ִ� ���ڰ�
		//���̻� L
		long number = 100000000000L; //���� ���ͷ� ���� L�� �ٿ� long ���� ���� 
		
		System.out.println("long Ÿ�� : "+ number);
		
		//char : �������� ������ �ִ� (2byte)
		//���ڸ� ǥ���ϴ� Ÿ��
		//1. �ѹ��� > 2byte ���� 
		//2. �ѱ����� : 2byte
		//3. ������, ����, Ư������, ���� : 1byte
		//   �ѱ�, ���� ��δ� �ѹ��� ǥ���� �ϱ����� 2byte
		
		//java ���ڿ� : "��" : String s = "��";, String s2 = "slfknsldfs";
		//java ����(�ѹ���) : char c = '��';
		
	    char single = '��';
	    System.out.println(single);
	    
	    char ch = 'A';
	    System.out.println(ch);
	    System.out.println((int)ch); //casting Ÿ�Ժ�ȯ // �ƽ�Ű �ڵ�ǥ 10������
	    // A : 65 , a : 97
	    
	    char ch2 = 'a';
	    System.out.println((int)ch2);
	    
	    int ch3 = 65;
	    char c4 = (char)ch3; //����� ����ȯ >> �Ͻ��� ����ȯ�� ����
	    System.out.println(c4);
	    
		int cint2 = c4; //�Ͻ��� ����ȯ ����� �����Ϸ��� �˾Ƽ� (int)c4;
		                
		//Today Point
		//������ ������ �ִ� [���� ���� ����] [������ Ÿ����] ������!! �ڡ١ڡ١ڡ�
		// �׸��� Ÿ���� ũ�⸦ ����
		//ū Ÿ�Կ��� ���� Ÿ���� ���� ���� �� �ִ�
		//���� Ÿ�Կ��� ū Ÿ���� ���� ���� �� ����
		
//		int intvalue = 103029970;
//		byte bytevalue = (byte)intvalue; //�������� �ս��� �Ͼ
//		System.out.println(bytevalue); //������ �� 
		
		int intvalue = 10;
		byte bytevalue = (byte)intvalue; 
		System.out.println(bytevalue); 
		
		//String (���ڿ�) Ÿ��
		//String Ŭ����
		//String str = new String("ȫ�浿");
		//�ڡ� String �Ϲ� �� Ÿ�� ���ŵ� ������ ���� ���������ڡ١ڡ�( int, double ó��)
		
		String s = "A";
		s += "B";
		s += "C";
		s += "D";
		
		String str = "hello world";
		System.out.println(str);
		
		String str2 = str +" = �������";
		System.out.println(str2);
		
		String str3 = "1000";
		String str4 = "10";
		
		String result = str3 + str4; // + >> ���ڿ� + ���ڿ� (���տ�����)
		System.out.println(result);
		
		System.out.println("100" + 100); // 100100
		System.out.println(100 + "100"); // 100100
		System.out.println(100+100+"100"); //200100
		System.out.println(100+(100+"100")); //100100100
		System.out.println(100+"100"+100); //100100100
		
        //�Ǽ�(�ε��Ҽ���)
		//float (4byte)
		//double(8byte) �ڡ� �Ǽ��� �⺻ ���ͷ��� double(���е��� ����-> �Ҽ��θ� ������ ����)
		
		float f = 3.14f; //���̻� (F, f)
		float f2 = 1.123456789f;
		System.out.println(f2); //�ݿø�ó�� 7�ڸ����� ǥ������ (���������)
		
		double d = 1.123456789123456789;
		System.out.println(d);// �ݿø�ó�� 16�ڸ� ǥ��
		
		double d2 = 100;
		//�����Ϸ��� ���������� �ڵ����� ����ȯ (�Ͻ��� ����ȯ)
		//double d3 = (double)299
		
		
		//1232323 >> ���� ���ͷ��� ������ int
		//1.123123 >> �Ǽ� ���ͷ��� ������ : double
		
		//Quiz
		double d3 = 100;
		int i5 = 10;
				
		// int result2 = d3+i5;
		//double result = d2 + i5;// ������ �ս� ���� ���� �� �ִ�
		//������ �ս� ���� ���� �� �ִ�
		int result2 = (int)d3 + i5;
	    
		//2. ������ ���� �� ������ ���� �ջ�� �� �ִ�
//		int result2 = (int)d3 + i5;
				
		
		//3. ���� �ջ�� �� �ִ�
//		int result2 = (int)(d3+i5);
				
				
	    //Topday Point
		//���� Ÿ�� + ū Ÿ�� => ūŸ��
		//int + double => double
		//int short => int
		//Ÿ�԰� ����ȯ >> ������ ������ ���� ���� ���� ������ Ÿ������ �Ǵ�
		
		int i6 = 100;
		byte b2 = (byte)i6;
		System.out.println(i6);
		
		byte b3 = 20;
		int i7 = b3; //����� ���������� ����ȯ
		             //�����Ϸ��� int i7 (int
				
				
		
		
		
		
		
		

	}

}
