// main �Լ��� ������ �ִ� Ŭ���� 
// Tip) c# : public static void Main()

// ���� : variable
// ���� Scope (��ȿ����) : ����Ǵ� ��ġ�� ����
// 1. instance varible : ��������


// 2. local variable : �������� (�Լ��ȿ� ����� ����)

// class Test{ public void run(){ int speed=0;} }
// ���������� ������ �ʱⰪ�� �������Ѵ�

// 3. static variable : �������� (��ü�� �����ڿ�)

// {���赵 == Ŭ���� == Ÿ��(����� ���� Ÿ��)} �ڡ�

class Test{

	int iv; //instance variable
	// �� ������ �ʱ�ȭ�� ���� �ʾƵ� �ȴ� (�⺻�� : default) �������ִ�
	// why : int iv = 100; �ʱ�ȭ�� ���� �ʾƵ� ��밡���ϰ� �������
	// ��ü���� �ٸ� ���� (����Ʈ ���� �ٸ� ������) ���� �ϱ� ���ؼ�
	
	void print(int i) {
	}
	
	String print2(int i) {
		return "���ϸ�";
	}
	
	void print3() {
		int i = 100; // �Լ��ȿ� �ִ� ������ local variable
		             // �Լ��� ȣ��Ǹ� �׶�  stack �޸𸮿� �����ǰ� �Լ��� ����Ǹ� ���� �Ҹ�
		             // ���������� �ݵ�� �ʱ�ȭ�� �Ͽ��� �Ѵ١ڡ�
		System.out.println(i);
	}
	
// �ϳ��� Ŭ���� �ȿ� public�� ���� class�� �ϳ��ۿ� ����	
	void write() {
		System.out.println("iv ��������(��ü����) : " + iv);
		//System.out.println(i);
		//Error : i ������ scope : print() �Լ� ����
		int i = 200; // ������ ������
		// int iv = 300; Error �� �ƴ����� �ǹ̰� ����  ! �׳�����������
	}
  	
}

public class Ex01_variable { 
	
	public static void main(String[] args) {

		
		
		// ���α׷��� �������� ������ �ִ� Ŭ����
		Test t1 = new Test();
		t1.iv = 10;
		
		Test t2 = new Test();
		System.out.println(t1.iv);
		
		t1.write();
		t1.write();
		
		int s = 0; // local variable
		System.out.println("�������� : s = " + s);
		
		int s2; // �����
		s2 = 100; // �ʱ�ȭ
		System.out.println(s2);
		
		s2 = 300;
		

	}

}
