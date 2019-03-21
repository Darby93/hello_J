//Inner Class
//클래스 안에 클래스가 있다

//Inner Class 개념
//AWT, SWING, Android(event) 처리 : 버튼 클릭, 마우스 오버, ......

class OuterClass{
	public int pdata = 10;
	public int data = 20;
	
	//Innerclass 목적
	//1. 자원에 접근을 편하게 하기 위해서
	//2. member field 가 선언되는 곳에 
	
	//장점 : [[[[ Outerclass가 가지고 있는 자원에 대한 접근이 용이 ]]]]
	class InnerClass{
		void msg() {
			System.out.println("outerclass data : " + data);
			System.out.println("outerclass pdata : " + pdata);
		}
	}
}

public class Ex11_InnerClass {

	public static void main(String[] args) {
		OuterClass outobj = new OuterClass();
		System.out.println("outobj.padata : "+outobj.pdata);
		
		OuterClass.InnerClass innerobj = outobj.new InnerClass();
		innerobj.msg();
	}
}
