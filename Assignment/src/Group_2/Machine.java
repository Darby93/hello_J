package Group_2;

import java.util.Scanner;

public class Machine { //자판기
    private int password;
    private boolean power; // 전원
    private static int sales; // 매출(누적) 
    private Scanner sc;
    private int[] maxRecipe; // 최대 재료량(재료가 많아서 배열선택)
    private int changeMoney; // 거스름돈 단위
    private int inputMoney; // 받는돈 단위
    private int[] size; // 사이즈
    private int[][] recipes;
    private Coffee[] coffees;
    
    public Machine() {
        password = 1234;
        size = new int[] { 5, 10, 5, 10 };
        recipes = new int[][] { // 원두, 우유, 설탕, 물
            { 20, 0, 0, 100 },
            { 20, 100, 5, 100 },
            { 20, 80, 5, 100 }
        };
        changeMoney = 0;
        coffees = new Coffee[] { new Coffee("아메리카노", 1, recipes[0], 1500),
                new Coffee("카푸치노", 2, recipes[1], 2000),
                new Coffee("카페라떼", 3, recipes[2], 2500)
                };
        
    }
    
    

    
    public void admin() { //관리자모드
    setRecipe();
    setCoffeeName();
    displaySales();
    }
    
    public void setRecipe() { // 재료량 설정
        
    }
    public void setCoffeeName() {// 커피종류 변경
 
    }
    public int displaySales() { // 매출확인
        return 0;
    }
    public void enterAdmin(int password) { //관리자모드 접근
        if(this.password == password) {
            admin();
        }else {
            System.out.println("잘못된 접근입니다.");
            displayMenu();
        }
    }
    
    public void displayMenu() { // 메뉴
        displayCoffee();
        selectCoffee();
    }
    
    public int setUserRecipe() { //재료량 조절
        return 0;
    }
    
    public void displaySum(Coffee coffee) { // 금액 표시
    	int result = coffee.getCoffeePrice();
    	System.out.println(result);
    	
    }
   
    public void selectCoffee() { // 커피선택
        setUserRecipe();
    }
    
    public void displayCoffee() { // 커피표시
  
    }
    
    public void refund(Coffee coffee) {
    	int result;
    	sc = new Scanner(System.in);
    	System.out.println("돈을 넣으세용");
    	
		do {
		try {
			inputMoney = Integer.parseInt(sc.nextLine());
			break;
		}catch(NumberFormatException e){
			System.out.println("다시 입력해주세요");
		}
		} while(true);
    	
    	if (inputMoney < coffee.getCoffeePrice()) {
    		System.out.println("금액이 부족합니다");
    		result = inputMoney;
    	}else {
    	
    	System.out.println(inputMoney + "원을 넣으셨습니다.");
    	result = inputMoney - coffee.getCoffeePrice();
    	
    	System.out.println("잔액은 " + result + "입니다");
    	}
    	
    	int unit = 10000;
		int num = 0;
		int sw = 0;

		while (true) {
			num = (int) (result / unit);
			System.out.printf("단위 :  %d   매수 : %d\n",unit,num);
			if (unit > 100) {
				result = result - unit * num;
				if (sw == 0) {
					unit = unit / 2;
					sw = 1;
				} else {
					unit = unit / 5;
					sw = 0;
				}
			} else {
				return;

			}
		}
    }
    
}