import java.util.Arrays;

import kr.or.bit.Emp;

class Test{
	void print() {
		System.out.println("�θ��Լ�_Test");
	}
}

class Test2 extends Test{

	@Override
	void print() {
		System.out.println("�ڽ��Լ�_Test2_�����ڸ����");
	}
	
	void print(String s) {
		System.out.println("���� �����ε� �Լ��� ^^");
	}
	
	
}

public class Ex05_Inherit_Override {

	public static void main(String[] args) {
		Test2 test = new Test2();
		test.print();
		test.print("�����ε�");
		
		System.out.println(test); //default toString()�� �پ�����
		System.out.println(test.toString());
		
		//Emp Ŭ�������� Object ������ toString() ������
		Emp e = new Emp(9999,"�ƹ���");
		String str = e.toString();
		System.out.println(str);
		
		//Arrays �̳༮�� Object�� ������ toString() ������......
		int [] arr = {11,23,45,67,77};
		String result = Arrays.toString(arr);
		System.out.println(result);
		
	}
	
	
	

}