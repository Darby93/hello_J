import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 문제점
// 1. 한글 1자 >> 2byte 필요 >> Stream : 1byte의 통로 >> 한글이 통과할 수 없다
// 2. 통로 하나 더 >> Reader, Writer : 2byte의 통로

public class Ex05_Reader_Writer_kor {
	public static void main(String[] args) {
		// File Reader, Writer
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader(".\\src\\Ex01_Stream.java");
			fw = new FileWriter("copy_Ex02.txt"); // 복사본을 만들겠다
			
			int data = 0;
			String str = "";
			while ((data = fr.read()) != -1) {
				// System.out.println(data + " : " + (char) data);
				// fw.write(data);
				// 요구사항 : 공백, 엔터, Tab 등 공백은 제거하고 파일을 쓰세요 (압축)
//				if (data != '\t' && data != '\n' && data != '\r' && data != ' ') {
//					fw.write(data);
//				}
				str += (char) data;
			}
			fw.write(str.replace("\r\n", "").replace(" ", ""));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
