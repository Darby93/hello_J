import kr.or.bit.Book;

/*
  생성자 함수(constructor) : 초기화(member field) 함수
  1. 특수한 목적을 가지는 함수(초기화)
  2. 초기화(instance variable : member field)
  
  일반함수와 다른점
 1. 함수의 이름이 고정(class 이름과 반드시 동일하게 해야함)
      일반함수는 이름이 다양!
 2. 생성자 함수는 : return 타입이 (x), void(x)
    why : 생성시점 ...   객체 생성과 동시에 호출 값을 넘길 곳이 없다
 
 목적 : 생성되는 객체마다 다른 초기값을 가지고 싶을 때
 
 생성자 함수 : overloading이 가능하다(prameter의 개수와 타입을 달리해서)
 
 class Car{
 int door; 
 Car(){ door = 10;}
 }
 시점 : Car c = new Car();
     1. stack 변수 c 생성 > default > null 
     2. Heap Car 객체를 생성 > 영역을 만듬 > memberfield로딩(instance variable)
        > 생성자 함수 호출 (로딩된 member field 초기화)
     3. class 생성시 default 생성자는 생략가능
       (내가 직점 설계하지 않아도 컴파일러가 알아서 생성)
       
 Tip) 생성자 함수가 overloading 하지 않으면 잘 안쓸듯 ?
*/


class Car {
	String name;
	//당신이 직접 구현하지 않아도
	//컴파일러는 생성자가 있다고 가정
	//Car(){} 생략(default) 되있음
}

class Car2 {
	String name;
	Car2(){
		System.out.println("나는 생성자 함수");
		System.out.println("before : " + name);
		name = "mony";
		System.out.println("after : " + name);
	}
}

class Car3{
	int number;
	//권장사항 : 코드상에서 default 생성자는 일반적으로 생략
	Car3(){}
}

class Car4{
	int door;
	int wheel;
	
	Car4(){
		//default
		System.out.println("default");
	}
	
	Car4(int num){ //overloading
		door = num;
		System.out.println("overloading door : " + door);
	}
	
	Car4(int num, int num2){ //overloading
		door = num;
		wheel = num2;
		System.out.println("overloading door : " + door);
		System.out.println("overloading wheel : " + wheel);
	}
	
}

class Apt{
	String color;
	
	Apt(String color){
		this.color = color;
		//아파트를 지을때 무조건 색생을 선택 .... 강제성
		// Apt apt = new Apt();  사용 불가능
		// Apt apt = new Apt("blue");  사용 가능
	}
}

class Apt2{
	String color;
	Apt2(){
		System.out.println("default");
	}
	Apt2(String color){
		this.color = color;
		//아파트를 지을때 무조건 색생을 선택 .... 강제성
		// Apt apt = new Apt();  사용 불가능
		// Apt apt = new Apt("blue");  사용 가능
	}
}

public class Ex13_Constructor_Function {

	public static void main(String[] args) {
//		Car c = new Car();
//		Car2 c2 = new Car2();
//		Car3 c3 = new Car3();
		
		// new 치고   ctrl + space 보고 확인해보기
		Car4 c4 = new Car4(); //default 호출해서 객체 생성
		System.out.println();
		Car4 c5 = new Car4(2); //param 1개 호출해서 객체 생성
		System.out.println();
		Car4 c6 = new Car4(3, 4); //param 2개 호출해서 객체 생성
		
		//★☆★☆  오버로딩된 생성자를 만들었고 디포트 생성자를 만들지 않았다면 
		//  디포트생성자  사용 불가 >> 자동생성 xx
		// ex) Apt apt = new Apt();
		//설계도에 강제성을 부여한다 (overloading 을 강제 사용하게 하고싶음)
		
		Apt2 apt2 = new Apt2();
		Apt2 apt3 = new Apt2("gold");

//1. class 생성시 생성자 함수 구현하지 않으면 ... (default 생성자 자동생성)
//ex) class Tv{String name;}


//2. class 생성시 overloading 생성자 함수를 하나라도 구현했다면
// **default 생성자 사용 할 수 없다**
// 강제적 구현 목적
//ex) class Tv(String name; Tv(String n){name = n}
		
//3. class 생성 default, overloading 둘다구현...
//필요에 따라서 default 나 overloading 골라 쓰면 됨
//ex) class Tv{(String name; Tv(){} Tv(String n){name = n}}
		
		System.out.println();
		Book book = new Book("BB",50000);
		book.Print();
		System.out.println(book.getName());
		System.out.println(book.getPrice());
		
		Book book2 = new Book("CC",999999);
		book2.Print();
		
		
		
	}

}
