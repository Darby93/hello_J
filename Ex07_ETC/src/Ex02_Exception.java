
public class Ex02_Exception {

	public static void main(String[] args) {
		int num = 100;
		int result = 0;
		
		
		
		try {
			
			for(int i = 0; i < 10; i++) {
				result = num/(int)(Math.random()*10); //  0 ~ 9 까지 값
				System.out.println("result : " + result + " i : " + i);
			}
			
		}catch(ArithmeticException e) {
			System.out.println("연산예외 : " + e.getMessage());
		}catch(Exception e) { //가독성이 떨어지뮤
			System.out.println("나머지 예외는 내가 처리함...");
		}
		//여러개의 catch block 생성가능
		//하위 예외가 항상 위에 (부모)
		
		System.out.println("MainEnd");
		
	}

}
