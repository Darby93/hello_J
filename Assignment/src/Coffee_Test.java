import java.util.Scanner;

public class Coffee_Test {

	public static void main(String[] args) {
//		int inputMoney;
		Scanner sc = new Scanner(System.in);
//    	System.out.println("돈을 넣으세용");
//    	inputMoney = Integer.parseInt(sc.nextLine());
//    	System.out.println(inputMoney + "원을 넣으셨습니다.");
		System.out.println("숫자입력");
		do {
		try {
			int money = Integer.parseInt(sc.nextLine());
			break;
		}catch(NumberFormatException e){
			System.out.println("다시 입력해주세요");
		}
		} while(true);
		
	}

}
