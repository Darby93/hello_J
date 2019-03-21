

import java.util.Scanner;

public class CoffeeMachine {
	private Scanner sc = new Scanner(System.in);
	private InputMoneySystem inputmoney = new InputMoneySystem();
	
	private int totalMoney = 0;
	
	public static final Material[] materials = {
			new AmericanoMaterial(), 
			new HazelnutMaterial(), 
			new MilkcoffeeMaterial()
			};
	public static final int[] PRICE = { 1000, 2000, 3000 };
	public static final int AMERICANO = 0;
	public static final int HAZELNUT = 1;
	public static final int MILKCOFFEE = 2;
	
	private static final int AMERICANO_BUTTON = 0;
	private static final int HAZELNUT_BUTTON = 1;
	private static final int MILKCOFFEE_BUTTON = 2;
	private int change;

	private void caculateMoney (int money) { // 수정
		int temp = money;
		System.out.println("현재금액 : " + temp);
		
		while (temp < PRICE[AMERICANO]) {
			if (temp < PRICE[AMERICANO]) {
				System.out.println("뽑을 수 있는 커피가 없습니다. 돈을 더 넣으세요.");
			}
			temp += sc.nextInt();
			System.out.println("현재금액 : " + temp);
		}
		
		if (temp >= PRICE[AMERICANO]) {
			System.out.println("1. 아메리카노((뽑을 수 있음)) -1000원 -" + materials[AMERICANO].countOfCoffee() + "잔 남음");
		}
		if (temp >= PRICE[HAZELNUT]) {
			System.out.println("2. 헤이즐넛((뽑을 수 있음)) - 2000원 -" + materials[HAZELNUT].countOfCoffee() + "잔 남음");
		}
		if (temp >= PRICE[MILKCOFFEE]) {
			System.out.println("3. 밀크커피((뽑을 수 있음)) - 3000원 -" + materials[MILKCOFFEE].countOfCoffee() + "잔 남음");
		}
		totalMoney = temp;
	}
	
	// 잔돈반환버튼 삭제

	boolean selectCoffee(Material material, int button) {

		switch (button) {
			case AMERICANO_BUTTON:
			case HAZELNUT_BUTTON:
			case MILKCOFFEE_BUTTON:
				if (material.canMakeCoffee()) {
					System.out.println("재고가 없습니다.");
					return false;
				}
				material.make();
				change = totalMoney - PRICE[button];
				totalMoney = 0;
				System.out.println("잔돈 : " + change);
				break;
			default:
				System.out.println("없는 번호입니다.");
		}
		return true;
	}
	
	public void execute() {
		int selectNumber;
		boolean checkStock=false;
		
		while (true) {
			InputMoneySystem.showMenu();
			caculateMoney(InputMoneySystem.inputMoney());

			do {
				System.out.println("뽑을 커피의 번호를 입력하세요.");

				selectNumber = sc.nextInt();
				if (selectNumber >= 1 && selectNumber <= 3)
					checkStock = selectCoffee(materials[selectNumber - 1], selectNumber - 1);
			
			} while (!(selectNumber >= 1 && selectNumber <= 3) ||  checkStock ==false);
		}
	}
}