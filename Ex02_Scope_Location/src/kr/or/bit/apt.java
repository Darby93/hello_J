package kr.or.bit;

public class apt {
	public String aptname; // 
	int door; //default   �ٺ�!
	private int window; // ĸ��ȭ, ����ȭ
	
	//�����Ҵ�
	//�����Ҵ��� ���� �����Ҵ��� ���� ������ ��ȣ
	public void write_window(int w) {//ĸ��ȭ�� �ڿ��� write �Լ�
		if( w == 0) {
			window = 100;
		}else {
			window = w;
		}
	}
	
	public int readwindow() { //ĸ��ȭ�� �ڿ��� read �Լ�
		return window;
	}

}
