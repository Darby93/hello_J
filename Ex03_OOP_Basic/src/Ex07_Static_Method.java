//static method
class StaticClass{
	public int iv; //����ʵ�
	static int cv; //����ʵ�
	
	//�Ϲ��Լ�
	void m () {
		//�Ϲ��Լ� m() ���� iv ���� ó�� : (0)
		iv = 100;
		//�Ϲ��Լ� m() cv���� ó�� : (0)
		//static �ڿ��� �Ϲ��ڿ����� ����(�׻�) memory�� �ε� �ȴ�
		cv = 200;
		
		System.out.println("iv : " + iv + " , " + "cv : " + cv);
		
	}
	
	static void sm() {
		//�Ϲ��ڿ��� iv �ڿ��� (member field) ��� : (x)
		//iv = 200; sm() �Լ��� �׻� �Ϲ��ڿ����� memory�� ���� �ö�
		//���������� ���� ����
		cv = 200;
		//�������� ��� ������ ����
		//static �� static���� ��� ����������
		System.out.println("static ���� : " + cv);

	}
}
/*
�Ϲ��Լ� : �Ϲ��ڿ�, static �ڿ� ��� ���
static �Լ� : static �ڿ��� ��� ����   memory ��������!(static ���� ���)
*/

public class Ex07_Static_Method {

	public static void main(String[] args) {
		StaticClass s = new StaticClass();
		s.m();
		s.sm();
		
		StaticClass.sm();
		
		
		
		
	}

}