//static method
class StaticClass{
	public int iv; //멤버필드
	static int cv; //멤버필드
	
	//일반함수
	void m () {
		//일반함수 m() 에서 iv 값을 처리 : (0)
		iv = 100;
		//일반함수 m() cv값을 처리 : (0)
		//static 자원은 일반자원보다 먼저(항상) memory에 로드 된다
		cv = 200;
		
		System.out.println("iv : " + iv + " , " + "cv : " + cv);
		
	}
	
	static void sm() {
		//일반자원인 iv 자원을 (member field) 사용 : (x)
		//iv = 200; sm() 함수가 항상 일반자원보다 memory에 먼저 올라감
		//생성시점에 대한 문제
		cv = 200;
		//끼리끼리 놀면 에러가 없다
		//static 은 static끼리 놀면 문제가없다
		System.out.println("static 변수 : " + cv);

	}
}
/*
일반함수 : 일반자원, static 자원 모두 사용
static 함수 : static 자원만 사용 가능   memory 순서때문!(static 끼리 노셈)
*/

public class Ex07_Static_Method {

	public static void main(String[] args) {
		StaticClass s = new StaticClass();
		s.m();
		s.sm();
		
		StaticClass.sm();
		
		
		
		
	}

}
