class Vtest{
	int iv;
	void print() {
		System.out.println("instance variable : " + iv);
	}
	
}

class Apt{
	String color; // String�� Ŭ����������  ��а� ���ڿ� Ÿ������...
	//Apt(){};     
	Apt(String color){ // ��ü������ �ʱ�ȭ
		//�Լ� (Ư���� �Լ�) : �Լ��� �̸��� Ŭ���� �̸��� ����
		//������ �Լ�(constructor)
		this.color = color; // this �� ��ü������ ����Ŵ
//		String color2;
	}
	
	void aptPrint() {
		System.out.println("���� :" + this.color);
	}
}


public class Ex02_variable {

	public static void main(String[] args) {
		Vtest t = new Vtest();
		t.print();
		
		Vtest t2 = new Vtest();
		t2.iv = 300;
		t2.print();
		
		Apt sk = new Apt("gold");
		sk.aptPrint();
		
		Apt naver = new Apt("red");
		naver.aptPrint();
	}

}
