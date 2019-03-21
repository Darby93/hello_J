import kr.or.bit.Person;
import kr.or.bit.Tv;

public class Ex01_Ref_Type {
	public static void main(String[] args) {
		Person person; //STACK 영역에 4 Byte 빈 공간 (person) null 
		person = new Person(); 
		//HEAP 메모리에 Person 객체 만들고 person 변수에 주소값을 할당
		System.out.println("person : " + person); //person : kr.or.bit.Person@15db9742
		
		person.name = "홍길동";
		person.age = 100;
		person.print();
		
		Person person2 = new Person(); //선언과 할당
		person2.name = "김유신";
		person2.age = 120;
		person2.print();
		
		//person, person2 (참조타입 : Ref Type)
		
		int num = 100; // main 함수 안에 있는 local variable (반드시 초기화)\
		System.out.println("값 : " + num); //(value Type)
		
		Person you;  //The local variable you may not have been initialized
		             //참조 타입(Ref Type)초기화는 주소값을 갖는 것
		
		//1. 참조변수의 초기화 (new 연산자 사용)
		//  you = new Person();
		
		//2. 다른 참조 변수가 가지는 값을 할당
		you = person; //person과 new  같은 주소값을 공유함!!
		System.out.println("you : " + you);
		System.out.println("person : " + person);
		System.out.println(you == person); //== 값비교 !
		
		//******************************************** TV 생산
		Tv t = new Tv();
		
		t.tn_on(); //호출한다 (함수는 이름을 불러주었을때 실행)
		System.out.println("전원정보 : " + t.tn);
		
		t.brandname = "삼성";
		
		System.out.println("기본채널 : " + t.ch); //0
		System.out.println("브랜드명 : " + t.brandname); //String의 기본값은 null

		t.ch_up();
		t.ch_up();
		t.ch_up();
		System.out.println("변경된 채널 : " + t.ch);
		
		t.ch_down();
		System.out.println("변경된 채널 : " + t.ch);
		
		t.tn_off();
		System.out.println("전원정보 : " + t.tn);
		
		
		
	}

}