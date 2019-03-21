

import java.util.Scanner;

public class Machine { // 자판기
	private Scanner sc = new Scanner(System.in);
	private int password; // 관리자 모드 비밀번호
	private int sales; // 매출(누적)
	private static final int[] MAXSTOCK = new int[] { 200, 1000, 50, 1000 };; // 최대 재료량(재료가 많아서 배열선택)
	private int[] currentStock;
	private int[] size; // 사이즈
	private int[][] recipes; // 재료량
	private Coffee coffeeOrder; // 주문하는 커피
	private Coffee[] coffees; // 커피 정보 배열
	String[] recipeName; // 재료 이름

	public Machine() { // 생성자 함수
		password = 1234;
		currentStock = new int[] { 200, 1000, 50, 1000 };
		size = new int[] { 5, 10, 5, 10 };
		recipes = new int[][] { // 원두, 우유, 설탕, 물
				{ 20, 0, 0, 100 }, { 20, 100, 5, 100 }, { 20, 80, 5, 100 } };
		coffees = new Coffee[] { new Coffee1("아메리카노", recipes[0], 1500), new Coffee2("카페라떼", recipes[1], 2500),
				new Coffee3("카푸치노", recipes[2], 2000) };
		recipeName = new String[] { "원두", "우유", "설탕", "물" };
	}

	public void vendingMachine() { // 실행 함수
		while (true) {
			Coffee coffee = displayMenu();
			if (coffee == null)
				continue;
			coffee = setUserRecipe(coffee);
			refund(coffee, inputMoney(coffee));
		}
	}

	private Coffee displayMenu() { // 메뉴
		System.out.println("┌──────────────");
		System.out.println("│  커 피  메 뉴   ");
		System.out.println("│=============");
		System.out.printf("│ 1  %s   \n", coffees[0].getCoffeeName());
		System.out.println("│             ");
		System.out.printf("│ 2  %s    \n", coffees[1].getCoffeeName());
		System.out.println("│             ");
		System.out.printf("│ 3  %s     \n", coffees[2].getCoffeeName());
		System.out.println("│-------------");
		System.out.println("│ 4   종  료      ");
		System.out.println("└──────────────");

		int menu = 0;
		do {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("메뉴를 선택해주세요.");
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 1 && menu <= 4 || menu == password) {
					break;
				}
			} catch (Exception e) {
				System.out.println("메뉴를 잘못 선택했어요");
				System.out.println("1,2,3,4 중에 선택해주세요");
			}
		} while (true);

		coffeeOrder = null;
		switch (menu) {
		case 1:
		case 2:
		case 3:
			coffeeOrder = coffees[--menu];
			break;
		case 4:
			System.exit(0);
		case 1234:
			admin();
			break;
		}
		return coffeeOrder;
	}

	private Coffee setUserRecipe(Coffee coffee) { // 재료량 조절

		coffeeOrder = new Coffee(coffee.getCoffeeName(), new int[4], coffee.getCoffeePrice());

		for (int i = 0; i < coffee.getRecipe().length; i++) {
			coffeeOrder.getRecipe()[i] = coffee.getRecipe()[i];
		}

		System.out.printf("%s 커피를 선택하셨습니다.\n", coffeeOrder.getCoffeeName());
		System.out.println();
		for (int i = 0; i < coffeeOrder.getRecipe().length; i++) {
			if (coffeeOrder.getRecipe()[i] != 0) {
				int sizeSelect = 0;
				do {
					System.out.printf("%s의 양을 선택해주세요.\n", recipeName[i]);
					System.out.println("1. 기본 2. 적게 3. 많게");
					try {
						sizeSelect = Integer.parseInt(sc.nextLine());
						if (sizeSelect >= 1 && sizeSelect <= 3) {
							break;
						} else {
							throw new Exception();
						}
					} catch (Exception e) {
						break;
					}
				} while (true);

				switch (sizeSelect) {
				case 1:
					System.out.println("기본으로 설정했습니다.");
					System.out.println();
					break;
				case 2:
					System.out.println("적은 양으로 설정했습니다.");
					System.out.println();
					coffeeOrder.getRecipe()[i] -= size[i];
					break;
				case 3:
					System.out.println("많은 양으로 설정했습니다.");
					System.out.println();
					coffeeOrder.getRecipe()[i] += size[i];
					break;
				default:
					System.out.println("올바른 값을 입력해주세요.");
					System.out.println();
					i--;
					break;
				}
			}
		}

		System.out.println("얼음을 추가하시겠습니까? (+500원) (예 / 아니오)");
		String answer = sc.nextLine();
		if (answer.equals("예")) {
			coffeeOrder.setIce(true);
			coffeeOrder.setCoffeePrice(coffeeOrder.getCoffeePrice() + 500);
		}

		return coffeeOrder;
	}

	private void showOrder(Coffee coffee) { // 주문 내역 확인
		Coffee original = null;
		for (Coffee c : coffees) {
			if (coffee.getCoffeeName() == c.getCoffeeName()) {
				original = c;
				break;
			}
		}
		
		System.out.println("주문 내용을 확인해주세요.");
		System.out.println();
		if (coffee.isIce()) {
			System.out.print("아이스 ");
		}
		System.out.println(coffee.getCoffeeName());
		System.out.println();
		for (int i = 0; i < coffee.getRecipe().length; i++) {
			String sizeString = null;
			if (coffee.getRecipe()[i] == 0) {
				continue;
			} else if (coffee.getRecipe()[i] == original.getRecipe()[i]) {
				sizeString = "기본";
			} else if (coffee.getRecipe()[i] < original.getRecipe()[i]) {
				sizeString = "적게";
			} else if (coffee.getRecipe()[i] > original.getRecipe()[i]) {
				sizeString = "많게";
			}
			System.out.printf("%s : %s\n", recipeName[i], sizeString);
		}

		System.out.println();
		
		System.out.printf("가격 : %d원\n", coffee.getCoffeePrice());
		System.out.println();
	}
	
	private int inputMoney(Coffee coffee) { // 주문 확인, 취소, 입금
		
		showOrder(coffee);
		
		System.out.println("이대로 주문할까요? (예 / 아니오)");
		String answer = sc.nextLine();
		
		int inputMoney;
		if (answer.equals("예")) {			
			System.out.println("금액을 투입하세요.");
			do {
				try {
					inputMoney = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("다시 입력해주세요");
				}
			} while (true);		
		} else {
			System.out.println("주문을 취소합니다.");
			inputMoney = 0;
		}
		return inputMoney;
	}

	private void refund(Coffee coffee, int inputMoney) { // 계산, 잔돈 반환
		int result;
		
		if (inputMoney == 0) {
			return;
		} else if (inputMoney < coffee.getCoffeePrice()) {
			System.out.println("금액이 부족합니다");
			result = inputMoney;
		} else {	
			System.out.println(inputMoney + "원을 넣으셨습니다.");
			result = inputMoney - coffee.getCoffeePrice();

			System.out.println("잔돈은 " + result + "원입니다");
			makeCoffee(coffee);
		}

		int unit = 10000;
		int num = 0;
		int sw = 0;

		while (true) {
			num = (int) (result / unit);
			System.out.printf("%5d원  %4d개\n", unit, num);
			if (unit > 10) {
				result = result - unit * num;
				if (sw == 0) {
					unit = unit / 2;
					sw = 1;
				} else {
					unit = unit / 5;
					sw = 0;
				}
			} else {
				System.out.println("잔돈으로 나왔습니다.");
				return;
			}
		}
	}

	private void makeCoffee(Coffee coffee) { // 커피 제조
		for (int i = 0; i < currentStock.length; i++) {
			if (currentStock[i] < coffee.getRecipe()[i]) {
				System.out.println("죄송합니다. 재료가 부족합니다. 관리자에게 연락하세요.");
				return;
			}
		}

		for (int i = 0; i < currentStock.length; i++) {
			currentStock[i] -= coffee.getRecipe()[i];
		}
		sales += coffee.getCoffeePrice();
		System.out.println("주문한 커피가 나왔습니다.");
		System.out.println();
	}

	private void admin() { // 관리자 모드
		System.out.println("┌──────────────");
		System.out.println("│  관 리 자 메 뉴	  ");
		System.out.println("│=============");
		System.out.println("│ 1. 재료량 설정	  ");
		System.out.println("│	          ");
		System.out.println("│ 2. 커피 이름 변경  ");
		System.out.println("│			  ");
		System.out.println("│ 3. 매출 확인	  ");
		System.out.println("│");
		System.out.println("│ 4. 재고 확인");
		System.out.println("│-------------");
		System.out.println("│ 5. 종  료	  ");
		System.out.println("└──────────────");

		int menu = 0;
		do {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("메뉴를 선택해 주세요.");
				menu = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("다시 입력해주세요");
			}
		} while (true);

		switch (menu) {
		case 1:
			setRecipe();
			break;
		case 2:
			setCoffeeName();
			break;
		case 3:
			displaySales();
			break;
		case 4:
			currentStock();
			break;
		case 5:
			break;
		}
	}

	private void setRecipe() { // 재료량 설정
		int coffee1;
		do {
			try {
				System.out.println("재료량을 바꾸실 커피를 선택해주세요.");
				System.out.printf("1. %s 2. %s 3. %s\n", coffees[0].getCoffeeName(), coffees[1].getCoffeeName(),
						coffees[2].getCoffeeName());
				coffee1 = Integer.parseInt(sc.nextLine()) - 1;
				if (coffee1 >= 0 && coffee1 <= 2) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("올바른 값을 입력해주세요.");
			}
		} while (true);
		
		exit: while (true) {
			switch (coffee1 + 1) {
			case 1:
			case 2:
			case 3:
				System.out.println(coffees[coffee1].getCoffeeName());
				for (int i = 0; i < recipes[coffee1].length; i++) {
					System.out.printf("%s의 양을 입력해주세요.", recipeName[i]);
					recipes[coffee1][i] = Integer.parseInt(sc.nextLine());
				}
				System.out.printf("변경된 재료량입니다.\n[%d, %d, %d, %d]\n", recipes[coffee1][0], recipes[coffee1][1],
						recipes[coffee1][2], recipes[coffee1][3]);
				break exit;
			default:
				System.out.println("잘못 입력하였습니다.");
			}

		}
		System.out.println();
		admin();
	}

	private void setCoffeeName() {// 커피 이름 변경
		int numbers;	
		do {
			try {
				System.out.println("이름을 변경할 커피를 선택해주세요.");
				System.out.printf("1. %s 2. %s 3. %s\n", coffees[0].getCoffeeName(), coffees[1].getCoffeeName(),
						coffees[2].getCoffeeName());
				numbers = Integer.parseInt(sc.nextLine()) - 1;
				if (numbers >= 0 && numbers <= 2) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("올바른 값을 입력해주세요.");
			}
		} while (true);
		
		switch (numbers + 1) {
		case 1:
		case 2:
		case 3:
			System.out.println("변경할 이름을 입력해주세요 :");
			coffees[numbers].setCoffeeName(sc.nextLine());
			System.out.println("변경한 이름 :" + coffees[numbers].getCoffeeName());
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			setCoffeeName();
		}	
		System.out.println();
		admin();
	}

	private void displaySales() { // 매출 확인
		System.out.printf("현재까지의 매출은 %d원입니다.", sales);
		System.out.println();	
		System.out.println("\t\t나가기 [0]");	
		String exit = sc.nextLine();	
		if (exit.equals("0")) {
			admin();
		} else {
			System.out.println("잘못 입력하였습니다.");
			displaySales();
		}
	}

	private void currentStock() { // 현재 재고량 확인
		for (int i = 0; i < MAXSTOCK.length; i++) {
			if ((float) currentStock[i] / MAXSTOCK[i] <= 0.3) {
				System.out.printf("%s 재료가 30%% 미만 남았습니다.\n", recipeName[i]);
			}
		}
		System.out.println("원두,  우유,  설탕,  물  - 최대");
		for (int remain : MAXSTOCK) {
			System.out.printf("[%4d]", remain);
		}
		System.out.println();
		System.out.println("원두,  우유,  설탕,  물  - 현재");
		for (int remain2 : currentStock) {
			System.out.printf("[%4d]", remain2);

		}
		System.out.println();
		System.out.println("\t\t나가기 [0]");
		String exit = sc.nextLine();
		if (exit.equals("0")) {
			admin();
		} else {
			System.out.println("잘못 입력하였습니다.");
			currentStock();
		}
	}
}