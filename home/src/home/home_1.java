package home;

import java.util.Scanner;

/*
Quiz
������� �ϴ� �ý����� ��ȭ�� ��ǰ ��÷ �ý����Դϴ�
��ǰ ��õ�� 1000 ������ ������
��ǰ���� Tv, Notebook, �����, �ѿ켼Ʈ, ����
��ǰ ��õ�� 900 ������ ������
��ǰ���� NoteBook, �����, �ѿ켼Ʈ, ����
��ǰ ��õ�� 800 ������ ������
��ǰ���� �����, �ѿ켼Ʈ, ����
��ǰ ��õ�� 700 ������ ������
��ǰ���� �ѿ켼Ʈ, ����    
��ǰ ��õ�� 600 ������ ������
��ǰ���� ����  
�׿ܴ� 100 ~ 500 ������ ĩ��

����ڰ� �ͼ� ��ǰ �ý��� ����ϰ� �Ǹ� �����ϰ� 100 ~ 1000 ������ ������ ����


*/

public class home_1 {
	public static void main(String[] args) {
		int score =  ((int)(Math.random()*10)+1)*100;
		System.out.println(score);
		Scanner sc = new Scanner(System.in);
		String gift = "";
		
		System.out.println("1������ ��ǰ����");
		while(true) {
			int r = sc.nextInt();
			if ( r != 1) {
				System.out.println("�ٽô�������");
			}else {
				System.out.println("��ǰ��÷�� ���۵˴ϴ�");
			} 
			switch(score) {
			case 1000: 
				break;
			case 900: 
				break;
			case 800: 
				break;
			case 700: 
				break;
			case 600: 
				break;
			default : gift = "ĩ��";
				break;
				
			}
	
			
		}
		
		
		
		
		
	}

}
