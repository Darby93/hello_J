
class Data{
	int i;
}




public class Ex10_Method_Call {
	public static void main(String[] args) {
		Data d  = new Data();
		d.i = 100;
		System.out.println("d.i : " + d.i);
		
		scall(d);
		System.out.println("d.i : " + d.i);
		vcall(d.i); //���� �Ѱ���
		System.out.println("d.i : " + d.i);
	}
	
	static void scall(Data momomomomomo) { //�ּҰ� ����
		System.out.println("�Լ� : " + momomomomomo.i);
		momomomomomo.i = 1111;
	}
	
	static void vcall(int x) { //�� ����
		System.out.println("before : " + x);
		x = 8888;
		System.out.println("after : " + x);
	}
	
}