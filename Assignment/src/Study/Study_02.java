package Study;

import java.util.Scanner;

public class Study_02 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. ���ڸ� �Է��ϼ��� ");
		int a = sc.nextInt();
		
		System.out.println("2. ���ڸ� �Է��ϼ��� ");
		int b = sc.nextInt();
		
		if ( a > b) {
			System.out.println("1���� �̰���ϴ�");
		}else if(a == b) {
			System.out.println("�����ϴ�");
		}else {
			System.out.println("2���� �̰���ϴ�");
		}
		
	}

}