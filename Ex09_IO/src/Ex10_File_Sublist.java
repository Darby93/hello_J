import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex10_File_Sublist {
	static int totalFiles = 0; // 객체 간 공유 자원이 아니고 static 변수
	static int totalDirs = 0;
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("사용법 : java 파일명 경로명");
			System.out.println("예시 : java Ex10_File_Sublist C:\\Temp");
			System.exit(0); // 프로세스 종료
		}
		
		File f = new File(args[0]);
		
		if (!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리");
			System.exit(0);
		}
		// 이 시점 (폴더라고 판단되는 시점)
		printFileList(f);
		System.out.println("총 파일 수 : " + totalFiles);
		System.out.println("총 폴더 수 : " + totalDirs);
	}
	
	static void printFileList(File dir) {
		System.out.println("[Full Path : " + dir.getAbsolutePath() + "]");
		
		List<Integer> subDir = new ArrayList<Integer>();
		File[] files = dir.listFiles(); // C:\Temp를 입력했다면 하위 자원을 배열로
		// C:\\Temp [0] a.txt
		//          [1] NEW
		//          [2] c.jpg
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getName(); // 폴더명 또는 파일명
			if (files[i].isDirectory()) {
				fileName = "<DIR> [" + fileName + "]";
				// POINT
				subDir.add(i);
			} else {
				fileName = fileName + " / " + files[i].length() + "byte";
			}
			System.out.println("  " + fileName);
		}
		
		// 질문
		int dirNum = subDir.size();
		int fileNum = files.length - dirNum;
		
		// 누적값
		totalDirs += dirNum; // 폴더 누적 개수
		totalFiles += fileNum; // 파일 누적 개수
		
		System.out.println("[Current dirNum] : " + dirNum);
		System.out.println("[Current fileNum] : " + fileNum);
		System.out.println("*************************************************");
		
		// 질문 for문 해석
		for (int j = 0; j < subDir.size(); j++) {
			int index = subDir.get(j);
			printFileList(files[index]);
		}
		// subDir.add(i) >> files 배열에서 디렉토리가 가지는 index값을 subDir에 추가
		// subDir.get(j)를 통해 얻은 index를 사용해 files에서 서브 폴더를 얻어냄
		// 서브 폴더에서 다시 printFileList()를 실행해 하위 파일, 폴더 출력
	} 
}
