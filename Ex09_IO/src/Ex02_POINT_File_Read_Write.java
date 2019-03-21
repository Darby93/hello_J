import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Stream의 대상이 파일 (read, write) : 디스크에 존재하는 물리적 파일
// FileInputStream, FileOutputStream
// text 기반 작업 : C:\\Temp\\a.txt...

public class Ex02_POINT_File_Read_Write {
	public static void main(String[] args) {
		// 1단계
		// POINT : I/O 작업은 가비지 콜렉터의 대상이 아니다
		// 파일 작업은 작업이 끝나면 자원을 해제해야 한다 (함수 : close())
		// 함수 : close() -> 내부적으로 소멸자 함수 호출
		
		/*
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("C:\\Temp\\a.txt");
			int data = 0;
			while ((data = fs.read()) != -1) {
				System.out.println("정수(숫자) : " + data);
				// h read -> 정수값으로 전달
				// 아스키 코드표를 기준으로 한 정수 값 출력
				System.out.println((char) data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fs.close();  // 정상적인 종료, 비정상적인 종료 시 모두 파일 닫기
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
		FileInputStream fs = null;
		FileOutputStream fos = null;
		String path = "C:\\Temp\\a.txt";
		
		try {
			fs = new FileInputStream(path); // read
			fos = new FileOutputStream("C:\\Temp\\new.txt");
			// write
			// FileOutputStream 클래스는 Temp 폴더 안에 new.txt가 존재하지 않으면
			// 자동으로 파일을 생성한다 >> 생성된 파일에 쓰기 작업
			
			// new FileOutputStream("C:\\Temp\\new.txt", true);
			// 생성자의 두 번째 인자가 true라면 
			// 기존 데이터에 append
			// 두 번째 인자가 없으면 (false)
			// 기존 데이터를 overwrite
			int data = 0;
			while ((data = fs.read()) != -1) {
				fos.write(data); // new.txt (인코딩 방식이 이미 정해져 있기때문에 알아서 문자값으로)
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fos.close();
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
}
