/*자바는 시스템에서 기본적으로 제공하는 8가지 기본 타입을 가지고 있다.
 * 8가지 기본 타입은 값을 저장한다.
 * Tip) [값] 과 [주소값]를 저장할 수 있다.
 * 
 * 숫자 -> 정수(음의정수, 0, 양의정수) -> byte(-128 ~ 127)
 *                             -> char(한문자를 포현하는 자료형 : 한문자는 2byte)
 *                                    unicode 체계를 따른다
 *                             -> short....(c언어의 호환성 ->무시)
 *                             -> int(-21억 ~ 21억)*** java정수 연산의 기본타입
 *                             -> long(8byte) int보다 큰값
 *      -> 실수(부동소수점) -> float(4byte), double(8byte)                       
 *                       정밀도가 높다 = 표현범위가 크다 *** 실수 연산 기본타입은 double    
 *      -> boolean(true, false) : 프로그램의 논리를 제어할 때 사용
 *      
 * 궁금해요 : 문자열의 표현 : 홍길동, 안녕하세요 어디에 담을까                            
 * String 는 클래스 : String s = new String("안녕하세요");
 * 앞 예제 : String s = "안녕하세요"; 
 * String 대해서 별도의 언급이 있기 까지는 String 도 int 처럼 쓰세요!               
 * 
 * 값타입 : 메모리에 값이 (숫자, 논리)
 * 참조타입 : 클래스, 배열 메모리에 값이 (주소 번지)
 * 
 * class == 설계도 == 타입 ★☆★☆
 * class 작은 타입을 모아 놓은 큰타입
 * 
 * class 는 반드시 메모리에 올려놓고 사용해야함(new)
 * class 첫 글자  대문자로쓰기
 */

//최소한 설계도라 할려면  >> 속성(상태정보)과 행위(기본)라는 정보를 가지고 있어야 함
//                       속성은 변수로 표현

class Car{
	String color; //색상을 담겠다
	int window; //자동차의 창문 개수
}


public class Ex03_DateType {

	public static void main(String[] args) {
		
		Car c = new Car(); // 스택메모리에 c변수가 만들어지고 heap메모리에 색깔 창문이 올라감
		System.out.println("c라는 변수의 값 : " + c); 
		                   //Car@566776ad 주소값  
		
		//c. ~~~       . = 주소를 찾는 연산자 !! 
		
		Car c2;
		c2 = c;
		System.out.println("c2라는 변수의 값 : " + c2);
		System.out.println(c==c2);
//		c2 = c;
//		
//		c2.color = "red"; // c의 컬러도  레드로 바뀜  같은 주소를 공유함
		
		Car c3;  // 선언
		c3 = new Car(); //할당 분리
		System.out.println("c3라는 변수의 값 : " + c3);
		System.out.println(c==c3);
	    c3.color = "gold";
	    c3.window = 10;
		// c3 는 c랑 같지 않다
		System.out.println(c3.color);
		System.out.println(c3.window);
		
		
		int i = 200;
		System.out.println(i);
		//200 메모리안에 값이 들어있음  // 
		
		int j ; // 선언
		//j = i;
		j = 1000;
		//i값의 변화가 없다 그대로 200
		
		int a, b; //반드시 초기화 작업을 거쳐야 한다.
		a= 10;
		b= 20;
		
		int k = 1111;
		int k2 = k;
		k = 2222; // k2의 값은 변화가 없다 !! 
		
		//int (-21억 ~ 21억)
		//int number = 10000000000; 오류(컴파일 에러) 
		//정수 리터럴의 표현범위는 [int] 까지 ★☆★☆★☆★☆
		//정수 리터럴 >> 표현할 수 있는 숫자값
		//접미사 L
		long number = 100000000000L; //정수 리터럴 값에 L을 붙여 long 으로 인지 
		
		System.out.println("long 타입 : "+ number);
		
		//char : 정수값을 가지고 있다 (2byte)
		//문자를 표현하는 타입
		//1. 한문자 > 2byte 통일 
		//2. 한글한자 : 2byte
		//3. 영문자, 숫자, 특수문자, 공백 : 1byte
		//   한글, 영문 모두다 한문자 표현을 하기위해 2byte
		
		//java 문자열 : "가" : String s = "가";, String s2 = "slfknsldfs";
		//java 문자(한문자) : char c = '가';
		
	    char single = '가';
	    System.out.println(single);
	    
	    char ch = 'A';
	    System.out.println(ch);
	    System.out.println((int)ch); //casting 타입변환 // 아스키 코드표 10진수값
	    // A : 65 , a : 97
	    
	    char ch2 = 'a';
	    System.out.println((int)ch2);
	    
	    int ch3 = 65;
	    char c4 = (char)ch3; //명시적 형변환 >> 암시적 형변환도 존재
	    System.out.println(c4);
	    
		int cint2 = c4; //암시적 형변환 사실은 컴파일러가 알아서 (int)c4;
		                
		//Today Point
		//변수가 가지고 있는 [값을 보지 말고] [변수의 타입을] 봐야함!! ★☆★☆★☆
		// 그리고 타입의 크기를 보자
		//큰 타입에는 작은 타입의 값을 넣을 수 있다
		//작은 타입에는 큰 타입의 값을 넣을 수 없다
		
//		int intvalue = 103029970;
//		byte bytevalue = (byte)intvalue; //데이터의 손실이 일어남
//		System.out.println(bytevalue); //쓰레기 값 
		
		int intvalue = 10;
		byte bytevalue = (byte)intvalue; 
		System.out.println(bytevalue); 
		
		//String (문자열) 타입
		//String 클래스
		//String str = new String("홍길동");
		//★☆ String 일반 값 타입 쓰셔도 문제가 없다 아직까진★☆★☆( int, double 처럼)
		
		String s = "A";
		s += "B";
		s += "C";
		s += "D";
		
		String str = "hello world";
		System.out.println(str);
		
		String str2 = str +" = 배고프다";
		System.out.println(str2);
		
		String str3 = "1000";
		String str4 = "10";
		
		String result = str3 + str4; // + >> 문자열 + 문자열 (결합연산자)
		System.out.println(result);
		
		System.out.println("100" + 100); // 100100
		System.out.println(100 + "100"); // 100100
		System.out.println(100+100+"100"); //200100
		System.out.println(100+(100+"100")); //100100100
		System.out.println(100+"100"+100); //100100100
		
        //실수(부동소수점)
		//float (4byte)
		//double(8byte) ★☆ 실수의 기본 리터럴은 double(정밀도가 높다-> 소수부를 더많이 포함)
		
		float f = 3.14f; //접미사 (F, f)
		float f2 = 1.123456789f;
		System.out.println(f2); //반올림처리 7자리까지 표현가능 (대락적으로)
		
		double d = 1.123456789123456789;
		System.out.println(d);// 반올림처리 16자리 표현
		
		double d2 = 100;
		//컴파일러는 내부적으로 자동으로 형변환 (암시적 형변환)
		//double d3 = (double)299
		
		
		//1232323 >> 숫자 리터럴은 무조건 int
		//1.123123 >> 실수 리터럴은 무조건 : double
		
		//Quiz
		double d3 = 100;
		int i5 = 10;
				
		// int result2 = d3+i5;
		//double result = d2 + i5;// 데이터 손실 없이 담을 수 있다
		//데이터 손실 없이 담을 수 있다
		int result2 = (int)d3 + i5;
	    
		//2. 지금은 맞을 수 있지만 값이 손상될 수 있다
//		int result2 = (int)d3 + i5;
				
		
		//3. 값이 손상될 수 있다
//		int result2 = (int)(d3+i5);
				
				
	    //Topday Point
		//작은 타입 + 큰 타입 => 큰타입
		//int + double => double
		//int short => int
		//타입간 형변환 >> 변수가 가지는 값을 보지 말고 변수의 타입으로 판단
		
		int i6 = 100;
		byte b2 = (byte)i6;
		System.out.println(i6);
		
		byte b3 = 20;
		int i7 = b3; //사실은 내부적으로 형변환
		             //컴파일러는 int i7 (int
				
				
		
		
		
		
		
		

	}

}
