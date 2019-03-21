import java.util.Scanner;

/*
 * 간단한 사칙 연산기 (+, -, *, /) 
 * 입력값 3개 (입력값은 nextLine() 받아서 필요하다면 숫자 변환)
 * 목적 : Integer.parseInt(), equals()
 * 화면
 * >입력값 : 100
 * >입력값(기호): +
 * >입력값: 600
 * >연산결과 : 700
 * 
 * ----------------
 * >입력값 : 100
 * >입력값(기호): -
 * >입력값: 100
 * >연산결과 : 0
 * 
 * 기호받는 건)
 * String opr = sc.nextLine();
 * 
 * hint) if(){} else if(){}
 * hint) if(opr == "+"){ 더하기 연산할거야} (xxxx)
 * hint) if (opr.equals("+")) { 더하기 연산}
 */
public class Ex09_operation_Quiz {

	public static void main(String[] args) {
		
//		String str = "+";
//		if(str.equals("+")) {
//			System.out.println("+");
//		}
//		
//		int i = 100;
//		if(i == 100) {
//			System.out.println(i);
//		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("값을 입력하세요");
		int number1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("부호를 입력하세요");
		String opr = sc.nextLine();
		
		System.out.println("값을 입력하세요");
		int number3 = Integer.parseInt(sc.nextLine());
		
		int result = 0;


		
		if (opr.equals("+")) {   //숫자는  ==   문자는 opr.equals("?")
			result = number1 + number3;
		}else if(opr.equals("-")){
			result = number1-number3;
		}else if(opr.equals("*")){
			result = number1*number3;
		}else if(opr.equals("/")){
			result = number1/number3;
		}else {
			System.out.println("지원하지 않는 연산자 입니다");
			//key point (여기서는 main 함수)
			//return 키워드 : [함수단위]의 종결자 > main 함수 탈출 > 종료
			return;
		}
		
		System.out.printf("%d %s %d = %d", number1, opr, number3, result);
		
		
		

	}

}
