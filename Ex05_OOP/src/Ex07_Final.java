// 변수 <-> 상수
// 상수 : 한번 값이 정해지면 변경 불가
//시스템에서 한번 값이 정해지면 변경 되지 말아야 될 것 : 시스템 버전 번호
//일반상식선에 값이 정해지면 병경 되지 말아야 될 것 : 주민번호, PI

//상수 관용적으로 대문자로 쓴다
//Java : final int Num = 100;
//C# : const int Num = 200;

//final 키워드
//클래스 앞에 : final class Car{}   --> 상속 불가(extends 불가)
//함수 앞에 : public final void print(){} >> 상속관계에서 재정의 하지마   >> 거의 안씀  private 로 쓰면 그만임

class Vcard{
	final String KIND = "heart";
	final int NUM = 10;
	void method() {
		//시스템 상수 ( static final double PI = 3.14159......)
		System.out.println(Math.PI);
	}
}


//질문 : Vcard 타입으로 만드는 모든 객체는 결국 같은 상수값을 가진다
//객체마다 다른  상수값을 갖고 싶어용 ??
//상수 값이 한번 설정되면 변경 불가

class Vcard2{
	final String KIND; //객체 만들고 초기화 안하면 어캄?
	final int NUM;
	
//	Vcard2(){
//		this.KIND = "heard";
//		this.NUM = 10;
//	}
	
	//강제적으로 초기화를 할수 있는 코드를 제공 (생성자)
	//디포트생성자 만들어두면 안됨
	//강제로 값지정을 할 수 가 없음  -- 어처피 에러나긴함
	//parameter 변수는 소문자로 관습
	Vcard2(String kind, int num){
		this.KIND = kind;
		this.NUM = num;
	}
	
}

public class Ex07_Final {

	public static void main(String[] args) {
		Vcard v = new Vcard();
		// v.KIND = "AAA";   >> 안됨 파이날이라 
		System.out.println(v.KIND);
		v.method();
		
		//☆★객체마다 다른 상수값을 가지게 할 수 있다 ☆★☆★☆★
		Vcard2 v2 = new Vcard2("space", 10) ;
		System.out.println(v2.KIND + " / " + v2.NUM);
		
		Vcard2 v3 = new Vcard2("cloba", 10) ;
		System.out.println(v3.KIND + " / " + v3.NUM);
		
	}

}
