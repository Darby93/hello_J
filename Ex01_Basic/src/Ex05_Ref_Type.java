//클래스는 설계도 이다, 클래스는 타입이다
//클래스 == 설계도 == 타입
//클래스는 반드시 메모리에 올려야 사용할 수 있다(설계도를 기반으로 땅에 아파트)
//new 통해서 설계도를 기반으로 구체화된 산물(객체)을 만든다

//설계도 (속성(상태정보) + 행위(기능))
class Apt2{
	int door = 10; //객체변수 (instance variable) : 초기화를 할 필요가 없다
	int window;    //초기화를 해도 상관 x
	
}



public class Ex05_Ref_Type {

	public static void main(String[] args) {
		int i = 100; //i는 100이라는 값을 갖는다
		Apt2 lg = new Apt2();  // 타입뒤는 무조건 변수!!
		//Apt2 타입 (사용자가 정의한 타입 : 여러개의 타입을 모은 큰타입)
		//lg : 주소값을 가지고 있는 변수 : 참조 변수(객체 변수)
		System.out.println(lg);
		
		
		Apt2 ssapt = lg; //ssapt에  lg의 주소를 줘 !!     ssapt는  lg의 주소값을 가짐
		                 //ssapt와 lg는 주소를 공유함
		//참조변수의 할당은 주소값 할당
		ssapt.window = 50;
		
		System.out.println("창문의 개수는 : " + lg.window);
		
		
		
	}

}
