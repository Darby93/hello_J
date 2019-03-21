//this
//1. ��ü �ڽ��� ����Ű�� this
//���赵���� �̾߱� �� ������ ��ü�� �����ɲ��� ... �����ɲ���� �����ϰ�
//���� �ڿ��� �� ����Ұ�

//2. this ��ü �ڽ�(������ ȣ���� �����ϴ�) :
//��Ģ : ��ü ������ ������ �Լ��� �ϳ��� ����
//���������� this�� ����ϸ� �������� ������ ȣ���� ����

class Test6 extends Object{ //extends Object ���� �ʾƵ� �ڵ����� ���������� 
	int i;
	int j;
	Test6(){}
	Test6(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	public void print() {
		System.out.println(i + " , " + j);
	}
	
	public void thisPrint() {
		System.out.println(this);
	}
	
}

class SoCar{
	String color;
	String gearType;
	int door;
	
	SoCar(){
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	
	SoCar(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	void print() {
		System.out.println(this.color + " / " + this.gearType + " / " + this.door);
	}
	
}


public class Ex15_This {

	public static void main(String[] args) {
		Test6 t = new Test6(100,200);
		t.print();
		System.out.println("t : " + t);
		t.thisPrint();
		
		SoCar so = new SoCar();
		so.print();
		
		SoCar so2 = new SoCar("blue","auto",4);
		so2.print();
		
		
	}

}
