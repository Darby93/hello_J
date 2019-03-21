import java.util.Scanner;

//main 함수 Scanner 사용 주민번호 입력받고
//앞 : 6자리 뒷 : 7자리
//입력값 : 123456-1234567
//1. 자리수 체크(기능)함수 (14 ok)
//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수
//3. 뒷번호 첫번째 자리값을 가지고 1,3남자, 2,4 여자 출력 기능함수
//3개의 함수 static 으로 설계 하세요
public class Ex07_String_Total_Quiz {
	static boolean juminCheck(String ss) {
		
		if(ss.length() != 14) {
			System.out.println("다시 뽑아라");
		}
		
		return false;
	}
	
	
	static void gender(String ss) {
		
		int first = Integer.parseInt(ss.substring(7, 8));
		
		if(!(first > 0 && first < 5)) {
			System.out.println("다시 입력하세요");
			return;
		}
		
	}
	
	static void print() {
		
	}
	

	public static void main(String[] args) {
		
	}

}
