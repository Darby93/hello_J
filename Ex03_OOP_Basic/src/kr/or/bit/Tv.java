package kr.or.bit;

/*
�䱸���� ����
Tv�� ä�� ������ ������ �ִ�( ex) 1~250ä�� )
Tv�� �귣�� �̸��� ������ �ִ� ( ex) �Ｚ, LG)
Tv�� ä�� ��ȯ ����� ������ �ִ� ( ä�� ���� ���� �Ѵܰ辿)
��� 2��  (++ , --)
Tv�� ���������� ������ �ִ�
Tv�� ������ On �Ҽ��� �ְ� off �Ҽ��� �ִ� 
*/
public class Tv {
	public int ch; //public  int ch = 1;
	public String brandname;
	public boolean tn; //true (on), false(off)
	
	public void ch_up() {
		//member field ���� ��
		ch++;
	}
	
	public void ch_down() {
		//member field ���� ��
		ch--;
	}
	
	public void tn_on() {
		tn = true;
		System.out.println("������ �մϴ�");
	}
	
	public void tn_off() {
		tn = false;
		System.out.println("������ ���ϴ�");
	}
	
	
}