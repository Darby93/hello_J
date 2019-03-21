// main 함수를 가지고 있는 클래스 
// Tip) c# : public static void Main()

// 변수 : variable
// 변수 Scope (유효범위) : 선언되는 위치에 따라서
// 1. instance varible : 전역변수


// 2. local variable : 지역변수 (함수안에 선언된 변수)

// class Test{ public void run(){ int speed=0;} }
// 지역변수는 무조건 초기값을 가져야한다

// 3. static variable : 공유변수 (객체간 공유자원)

// {설계도 == 클래스 == 타입(사용자 정의 타입)} ★☆

class Test{

	int iv; //instance variable
	// 이 변수는 초기화를 하지 않아도 된다 (기본값 : default) 가지고있다
	// why : int iv = 100; 초기화를 하지 않아도 사용가능하게 했을까요
	// 객체마다 다른 값을 (아파트 마다 다른 층수를) 갖게 하기 위해서
	
	void print(int i) {
	}
	
	String print2(int i) {
		return "포켓몬";
	}
	
	void print3() {
		int i = 100; // 함수안에 있는 변수를 local variable
		             // 함수가 호출되면 그때  stack 메모리에 생성되고 함수가 종료되면 같이 소멸
		             // 지역변수는 반드시 초기화를 하여야 한다★☆
		System.out.println(i);
	}
	
// 하나의 클래스 안에 public이 붙은 class는 하나밖에 못씀	
	void write() {
		System.out.println("iv 전역변수(객체변수) : " + iv);
		//System.out.println(i);
		//Error : i 변수의 scope : print() 함수 내부
		int i = 200; // 언제라도 가능함
		// int iv = 300; Error 는 아니지만 의미가 없다  ! 그냥하지마세요
	}
  	
}

public class Ex01_variable { 
	
	public static void main(String[] args) {

		
		
		// 프로그램의 시작점을 가지고 있는 클래스
		Test t1 = new Test();
		t1.iv = 10;
		
		Test t2 = new Test();
		System.out.println(t1.iv);
		
		t1.write();
		t1.write();
		
		int s = 0; // local variable
		System.out.println("지역변수 : s = " + s);
		
		int s2; // 선언부
		s2 = 100; // 초기화
		System.out.println(s2);
		
		s2 = 300;
		

	}

}
