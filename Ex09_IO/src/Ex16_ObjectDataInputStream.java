import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.or.bit.UserInfo;

// UserData.txt에 직렬화된 내용을 read >> 역직렬화 >> 다시 조립 >> 제품 확인

public class Ex16_ObjectDataInputStream {
	public static void main(String[] args) {
		String fileName = "UserData.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream(fileName);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis);
			
//			UserInfo r1 = (UserInfo) in.readObject();
//			UserInfo r2 = (UserInfo) in.readObject();
			
//			System.out.println(r1.toString());
//			System.out.println(r2.toString());
			
			// 객체 단위의 read... 객체가 없다면 null값 반환
			Object users = null;
			while ((users = in.readObject()) != null) {
				System.out.println(users.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				in.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
