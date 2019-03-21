import java.io.IOException;

public class Ex03_Exception_fianally {
	static void startInstall() {
		System.out.println("Install");
	}
	static void copyFiles() {
		System.out.println("COPY FILES");
	}
	static void fileDelete() {
		System.out.println("DELETE FILES");
	}
	public static void main(String[] args) {
		
		try {
			copyFiles();
			startInstall();
			
			//개발자가 임의로 [예외를 만들] 수 있다
			//A, B, C 정상입력   ----  D라고 입력하면 비정상이라고 정해줌
			//사용자 예외 던지기 (예외 객체를 개발자가 직접 생성한다)(new)
			throw new IOException("Install 처리 중 문제 발생");
		}catch(Exception e) {
			System.out.println("예외 메세지 출력 : " + e.getMessage());
		}finally { //예외가 발생, 발생 하지 않던 강제적 실행 블럭
			fileDelete();
		}
		//주의사항 ...
		//**********함수 종료 (return) 가 있더라도 finally는 실행된다
		System.out.println("Main end");
		
	}

}
