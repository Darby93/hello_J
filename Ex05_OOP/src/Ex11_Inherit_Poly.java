//상속관계에서 다형성

class Pbase{
	int p = 100;
}

class Cbase extends Pbase{
	int c = 200;
}

class Dbase extends Pbase{
	
}

//Cbase는 Dbase와  같은부모이당


public class Ex11_Inherit_Poly {

	public static void main(String[] args) {
		Cbase c = new Cbase();
		System.out.println(c.toString());
		//다형성 : 부모타입의 참조변수가 자식타입의 주소값을 가질 수 있다 (상속관계에서)
		//그렇지만  메모리에 모든 자원에 접근하는 것이 아니고 자신의타입(부모타입)만 접근가능하다
		
		Pbase p = c;//다형성
		System.out.println("p 부모타입 변수 : " + p);
		System.out.println("p 상속한 c타입 변수  : " + c);
		
		System.out.println(c.c + " / " + c.p);
		System.out.println("자신의 것만(부모타입) : " + p.p); //c는못봐융
		
		Dbase d = new Dbase();
		p = d; //p라는 부모타입 변수는 d의 주소도 가질 수 있고 c의 주소도 가질 수 있다. //p = c;
		//c,d 는 같은 부모를 가진다
		
		//////////////////////////////////////////////////////////////
		Dbase dd = (Dbase)p; //부모가 상위타입 ==> 하위타입인  자식에게 ....
		//부모타입의 주소값을 자식타입에게 전달(상위타입 --> 하위타입)
		//반드시 하위타입에 맞는 캐스팅을 해야한다
	}

}
