package Study;

import java.util.Scanner;

public class Study_02 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 숫자를 입력하세요 ");
		int a = sc.nextInt();
		
		System.out.println("2. 숫자를 입력하세요 ");
		int b = sc.nextInt();
		
		if ( a > b) {
			System.out.println("1번이 이겼습니다");
		}else if(a == b) {
			System.out.println("비겼습니다");
		}else {
			System.out.println("2번이 이겼습니다");
		}
		
	}

}
