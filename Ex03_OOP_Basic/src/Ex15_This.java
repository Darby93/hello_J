//this
//1. 객체 자신을 가리키는 this
//설계도에게 이야기 너 앞으로 객체로 생성될꺼지 ... 생성될꺼라고 가정하고
//너의 자원을 좀 명시할게

//2. this 객체 자심(생성자 호출이 가능하다) :
//원칙 : 객체 생성시 생성자 함수는 하나만 하출
//예외적으로 this를 사용하면 여러개의 생성자 호출이 가능

class Test6 extends Object{ //extends Object 쓰지 않아도 자동으로 생략되잇음 
	int i;
	int j;
	Test6(){}
	Test6(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	public void print() {
		System.out.println(i + " , " + j);
	}
	
	public void thisPrint() {
		System.out.println(this);
	}
	
}

class SoCar{
	String color;
	String gearType;
	int door;
	
	SoCar(){
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	
	SoCar(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	void print() {
		System.out.println(this.color + " / " + this.gearType + " / " + this.door);
	}
	
}


public class Ex15_This {

	public static void main(String[] args) {
		Test6 t = new Test6(100,200);
		t.print();
		System.out.println("t : " + t);
		t.thisPrint();
		
		SoCar so = new SoCar();
		so.print();
		
		SoCar so2 = new SoCar("blue","auto",4);
		so2.print();
		
		
	}

}
