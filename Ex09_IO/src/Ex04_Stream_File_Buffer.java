import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 컴퓨터의 가장 느린 작업 : 파일 I/O (read, write : Disk)
 * File 작업 (Disk) >> read, write를 byte 단위로
 * 문제 해결 : 묶어서 작업
 * Buffer 메모리 : 쌓아두고 한 번에 처리하자
 * 
 * 고민하지 말고 그냥 Buffer 사용하자
 * 
 * File I/O 작업시 성능 개선
 * 
 * 버퍼를 사용하면 Line 단위 처리 가능 (엔터 기반)
 * 
 * Java API가 보조 스트림으로 제공 : 독자적으로 new를 할 수 없다 (param을 강제)
 * BufferedInputStream buffer = new BufferedInputStream();
 * default 생성자를 구현하지 않았따 ... overloading만 구현
 * BufferedOutputStream
 * 
 * BufferedInputStream(InputStream in) > InputStream을 상속 구현한 객체의 주소
 */

public class Ex04_Stream_File_Buffer {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("data.txt"); // 파일 생성 기능
			bos = new BufferedOutputStream(fos);
			
			for (int i = 0; i < 10; i++) {
				bos.write('A');
			}
			/*
			 * 궁금한 점
			 * buffer는 언제 파일에 write하는가?
			 * Java buffer의 크기 : 8KB -> 8192B
			 * 1. buffer 안의 내용이 가득 채워지면 자동으로 비운다.
			 * 2. buffer를 강제로 비우는 방법 : flush() > 강제로 비우기
			 * 3. bos.close()하면 내부적으로 flush() 호출
			 */
			// bos.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
