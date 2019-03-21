
/*
  Ŭ���� == ���赵 == Ÿ�� �̴�
  Ŭ������ �⺻ ������� : �ʵ�(������, ���°�, ������), �Լ�(���)
  ������(������) : public, private, default(���� �ʴ°�), protected(���)
  
  1. public class Test{}
  
  2. class Test{} >> default �����ڰ� �����Ǿ��� 
  (default ������ : ���� ���� �ȿ� ��������, �ٸ� ����(package)�� ������ ��� �Ұ�)
  
  3. default class �� ���� ��� : ���� ���������� �ٸ� Ŭ������ ���� ����
                                           ������������
  
  4. �ϳ��� �ڹ� ������ (a.java) �������� Ŭ������ ���� �� ������
      >>Ex01_main.java
      >>class Test{ } �ڵ� ���� .... �����δ� ���� �ȵ�!
      >>�� �������� Ŭ������ ���� �� public�� ������ Ŭ������ �ϳ���
     
     
  default : ���� ���� ������ ����
  
  
*/


import kr.or.bit.*; // �������� �������Ƿ�  Ŭ������ �ٿ��ش�  ����������!
import kr.or.bit.apt;
import kr.or.bit.Emp;

class Test{  //default class
	int i;   //default int
	
	void print() {   //default void print()
		System.out.println("default");
	}
}

public class Ex01_main {

	public static void main(String[] args) {
		Person p = new Person();
		p.name = "����"; //���� ��Ű���� ��밡��
		
		// kr.or.bit ���� �ȿ� �ִ� Car Ŭ���� ���
		apt apt = new apt();
		apt.aptname = "����"; //�ٸ���Ű�� ������ public ����ؼ� �� �� ����

		
		
		apt.write_window(0);
		System.out.println(apt.readwindow());
		
		Test t = new Test();
		t.i = 100;
		
		
		//************************************************************
		
		Emp e = new Emp();
		e.setEmpno(-8888);
		System.out.println(e.getEmpno());
		
		e.mgr = -8888;
		System.out.println(e.mgr);
		
		
		
		
	}

}
