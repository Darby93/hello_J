

import java.util.Scanner;

public class InputMoneySystem {
	static Scanner sc = new Scanner(System.in);
	public static int amount = 0; // 수정
	
	public static void showMenu() {
		System.out.println("-------메뉴---------");
		System.out.println("1. 아메리카노 1000원");
		System.out.println("2. 헤이즐넛 2000원");
		System.out.println("3. 밀크커피 3000원");
		System.out.println("현금을 입력하세요.");
	}
	
	public static int inputMoney() {
		return sc.nextInt();
	}
}