
public class Ex04_DateType {
	
	public static void main(String[] args) {
		//안에 선언되는 변수 지역변수 (main 함수 안쪽)
		
		byte b = 100;
		System.out.println(b);
		
		int i = 12345;
		System.out.println(i);
		
		long l = 10000000000000L; //정수 리터럴은 int
		System.out.println(l);
		
		float f = 3.14f; // 실수 리터럴은 double
		System.out.println(f);
		
		double d = 3.1415934567;
		System.out.println(d);
		
		boolean bo = true;
		System.out.println(bo);
		
	    char ch = 'A';
	    System.out.println(ch);
	    
		String str = "홍길동";
		System.out.println(str);
		
		//Tip) java 특수문자 사용  : \ 역슬래시를 사용
		char sing = '\''; //내가 입력한 것은 값이야
		System.out.println(sing);
		
		//홍"길"동 >> 자체로 데이터(값) 나타내고 싶을 때
		String name = "홍\"길\"동";
		System.out.println(name);
		
		//화면에 C:\Temp 라는 문자열 출력
		String str1 = "C:\\Temp";
		System.out.println(str1);
		
		
		
		
		
	}

}
