
/*
  클래스 == 설계도 == 타입 이다
  클래스의 기본 구성요소 : 필드(고유값, 상태값, 참조값), 함수(기능)
  접근자(한정자) : public, private, default(쓰지 않는것), protected(상속)
  
  1. public class Test{}
  
  2. class Test{} >> default 접근자가 생략되었다 
  (default 접근자 : 같은 폴더 안에 공유가능, 다른 폴더(package)에 있으면 사용 불가)
  
  3. default class 는 언제 사용 : 같은 폴더내에서 다른 클래스의 참조 목적
                                           연습목적으로
  
  4. 하나의 자바 파일은 (a.java) 여러개의 클래스를 가질 수 있지만
      >>Ex01_main.java
      >>class Test{ } 코딩 연습 .... 실제로는 쓰면 안됨!
      >>단 여러개의 클래스를 만들 때 public을 가지는 클래스는 하나만
     
     
  default : 같은 폴더 내에서 사용시
  
  
*/


import kr.or.bit.*; // 가독성이 떨어지므로  클래스를 붙여준다  관용적으로!
import kr.or.bit.apt;
import kr.or.bit.Emp;

class Test{  //default class
	int i;   //default int
	
	void print() {   //default void print()
		System.out.println("default");
	}
}

public class Ex01_main {

	public static void main(String[] args) {
		Person p = new Person();
		p.name = "연습"; //같은 패키지라 사용가능
		
		// kr.or.bit 폴더 안에 있는 Car 클래스 사용
		apt apt = new apt();
		apt.aptname = "현대"; //다른패키지 이지만 public 사용해서 쓸 수 있음

		
		
		apt.write_window(0);
		System.out.println(apt.readwindow());
		
		Test t = new Test();
		t.i = 100;
		
		
		//************************************************************
		
		Emp e = new Emp();
		e.setEmpno(-8888);
		System.out.println(e.getEmpno());
		
		e.mgr = -8888;
		System.out.println(e.mgr);
		
		
		
		
	}

}
