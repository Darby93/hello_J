import java.util.Scanner;

//main 함수 Scanner  사용 주민번호 입력받고
//앞:6자리 뒷:7자리
//입력값 : 123456-1234567 
//1. 자리수 체크 (기능)함수 (14 ok)
//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수
//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수
//3개의 함수 static 으로 설계 하세요
public class Ex07_String_T {
	
	static boolean juminCheck(String str) {
		return str.length() == 14 ? true : false;
	}
	
	static boolean juminFirstNumber(String str) {
		boolean numcheck = false;
		int num = Integer.parseInt(str.substring(7, 8));
		if (num > 0 && num < 5) {
			numcheck = true;
		}
		return numcheck;
	}
	
	static void juminDisplay(String ssn) {
		// CASE1 >
		// String gender= ssn.replace("-","").substring(6,7);
		// int numgender = Integer.parseInt(gender);
		// if(numgender%2 == 0)System.out.println("여자");
		// if(numgender%2 == 1)System.out.println("남자");

		// CASE2 >
		char cgen = ssn.replace("-", "").charAt(6);
		// 123456-1234567 -> 1234561234567 > 123456[1]234567 추출> '1'
		switch (cgen) {
			case '1': // break 생략
			case '3':
				System.out.println("남자^^");
				break;
			case '2': // break 생략
			case '4':
				System.out.println("여자^^");
				break;
			default:
				System.out.println("중성");
		}
	}
	public static void main(String[] args) {
		String ssn = "";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("주민번호입력:");
			ssn = sc.nextLine();
		}while(!juminCheck(ssn) || !juminFirstNumber(ssn));
		
		//출력
		juminDisplay(ssn);

	}

}
