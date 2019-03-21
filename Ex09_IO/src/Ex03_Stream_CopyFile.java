import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03_Stream_CopyFile {

	public static void main(String[] args) throws IOException {
		String oriFile = "C:\\Temp\\NEW\\Chrysanthemum.jpg";
		String targetFile = "copy.jpg";
		// default 경로 : C:\FrontEndBackEnd\JAVA\Labs\Ex09_IO
		// 경로를 명시하지 않으면 >> 프로젝트 폴더
		
		FileInputStream fis = new FileInputStream(oriFile);
		FileOutputStream fos = new FileOutputStream(targetFile);
		
		int data = 0;
		while ((data = fis.read()) != -1) {
			fos.write(data);
		}
		fos.close();
		fis.close();
		System.out.println("작업 완료");
	}
}
