package Group_2;

import java.util.Scanner;

public class Machine { //���Ǳ�
    private int password;
    private boolean power; // ����
    private static int sales; // ����(����) 
    private Scanner sc;
    private int[] maxRecipe; // �ִ� ��ᷮ(��ᰡ ���Ƽ� �迭����)
    private int changeMoney; // �Ž����� ����
    private int inputMoney; // �޴µ� ����
    private int[] size; // ������
    private int[][] recipes;
    private Coffee[] coffees;
    
    public Machine() {
        password = 1234;
        size = new int[] { 5, 10, 5, 10 };
        recipes = new int[][] { // ����, ����, ����, ��
            { 20, 0, 0, 100 },
            { 20, 100, 5, 100 },
            { 20, 80, 5, 100 }
        };
        changeMoney = 0;
        coffees = new Coffee[] { new Coffee("�Ƹ޸�ī��", 1, recipes[0], 1500),
                new Coffee("īǪġ��", 2, recipes[1], 2000),
                new Coffee("ī���", 3, recipes[2], 2500)
                };
        
    }
    
    

    
    public void admin() { //�����ڸ��
    setRecipe();
    setCoffeeName();
    displaySales();
    }
    
    public void setRecipe() { // ��ᷮ ����
        
    }
    public void setCoffeeName() {// Ŀ������ ����
 
    }
    public int displaySales() { // ����Ȯ��
        return 0;
    }
    public void enterAdmin(int password) { //�����ڸ�� ����
        if(this.password == password) {
            admin();
        }else {
            System.out.println("�߸��� �����Դϴ�.");
            displayMenu();
        }
    }
    
    public void displayMenu() { // �޴�
        displayCoffee();
        selectCoffee();
    }
    
    public int setUserRecipe() { //��ᷮ ����
        return 0;
    }
    
    public void displaySum(Coffee coffee) { // �ݾ� ǥ��
    	int result = coffee.getCoffeePrice();
    	System.out.println(result);
    	
    }
   
    public void selectCoffee() { // Ŀ�Ǽ���
        setUserRecipe();
    }
    
    public void displayCoffee() { // Ŀ��ǥ��
  
    }
    
    public void refund(Coffee coffee) {
    	int result;
    	sc = new Scanner(System.in);
    	System.out.println("���� ��������");
    	
		do {
		try {
			inputMoney = Integer.parseInt(sc.nextLine());
			break;
		}catch(NumberFormatException e){
			System.out.println("�ٽ� �Է����ּ���");
		}
		} while(true);
    	
    	if (inputMoney < coffee.getCoffeePrice()) {
    		System.out.println("�ݾ��� �����մϴ�");
    		result = inputMoney;
    	}else {
    	
    	System.out.println(inputMoney + "���� �����̽��ϴ�.");
    	result = inputMoney - coffee.getCoffeePrice();
    	
    	System.out.println("�ܾ��� " + result + "�Դϴ�");
    	}
    	
    	int unit = 10000;
		int num = 0;
		int sw = 0;

		while (true) {
			num = (int) (result / unit);
			System.out.printf("���� :  %d   �ż� : %d\n",unit,num);
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