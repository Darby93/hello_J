//2. this(객체 >> 생성자를 호출하는 this)

//원칙 : 생성자는 객체 생성시 한개만 호출
// 예외적으로 this를 사용하면 여러개의 생성자 함수를 호출할 수 있다

//this.....
//생성자안에 있는 코드가 반복적으로 사용
//default : this.color = "red";
//overloading : this.color = color;
class Zcar{
	String color;
	String geartype;
	int door;
	
	Zcar(){
		//생성자안에 있는 코드가 반복적으로 사용
		//this.color = "red";
		//this.geartype = "auto";
		//this.door = 4;
		
		// new Zcar()
		//     this()
		this("red", "auto", 4); //자기 자신을 호출한다 (생성자 함수 호출 가능)
		
		System.out.println("default constructor");
	}
	
	Zcar(String color, String geartype, int door){
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println(this.color + "," + this.geartype + "," + this.door);
		System.out.println("overloading constructor");
	}
	
	void print () {
		System.out.println(this.color + "," + this.geartype + "," + this.door);
	}
	
}

//자동차 영업 사원 (자동차 판매 기본 옵션) : default, 기본값....
//
class Zcar2{
	String color;
	String geartype;
	int door;
	
	Zcar2(){
		this("red", 2);
		System.out.println("default constructor");
	}
	
	Zcar2(String color , int door){ //차량의 색상과 문의 개수 선택 가능 (옵션 B)
		this(color, "auto", door);
		System.out.println("overloading constructor param  2개");
	}
	
	Zcar2(String color, String geartype, int door){ //차량의 색상, 기어, 문 개수 선택가능 (옵션 C)
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading constructor param  3개");
	}
	
	void print () {
		System.out.println(this.color + "," + this.geartype + "," + this.door);
	}
	
	
	
}



public class Ex16_this_Constructor_Call {

	public static void main(String[] args) {
		Zcar z = new Zcar();
		z.print();
		
//		Zcar z2 = new Zcar("blue","auto",10);
//		z2.print();
		
		Zcar2 car = new Zcar2();
		car.print();
		
//		Zcar2 car2 = new Zcar2("gold", 2);
//		car2.print();
		
//		Zcar2 car3 = new Zcar2("hot pink", "manual" ,132);
//		car3.print();
		
		
		
		
		
	}

}
