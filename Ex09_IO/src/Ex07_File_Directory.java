import java.io.File;

// File 클래스
// 파일(a.txt) > 생성, 수정, 삭제
// 디렉토리(폴더) (C:\Temp) : 생성, 삭제

// 사용 : 파일 정보, 폴더 정보

// C# : File 클래스, Directory 클래스

// POINT : FileOutputStream, FileWriter : 파일 생성 기능을 역시 가지고 있다

public class Ex07_File_Directory {
	public static void main(String[] args) {
		String path = "C:\\Temp\\file.txt"; // file.txt가 만들어져있다는 전제
		File f = new File(path); // file.txt 줄 테니까 분석해봐
		
		String filename = f.getName();
		System.out.println("파일명 : " + filename);
		System.out.println("전체경로 : " + f.getPath());
		System.out.println("절대경로 : " + f.getAbsolutePath());
		System.out.println("너 폴더니 : " + f.isDirectory());
		System.out.println("너 파일이니 : " + f.isFile());
		System.out.println("파일크기 : " + f.length());
		System.out.println("부모경로 : " + f.getParent());
		System.out.println("파일 존재 여부 : " + f.exists());
		
		// f.createNewFile(); 파일 생성
		// f.delete(); (return true or false)
		// f.canWrite(); 쓰기 가능?
	}
}
