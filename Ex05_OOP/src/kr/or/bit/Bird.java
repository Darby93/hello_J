package kr.or.bit;

//protected 목적 : 상속관계에서 재정의 했으면 좋겠음
//당신이 필요하다면 재정의해 .... 아마 필요할 걸.....

//공통 : 새는 날 수 있다, 새는 빠르다
public class Bird {
	public void fly() {
		System.out.println("I am fly...");
	}
	
	//재정의 했으면 좋겠어
	protected void movefast() {
		fly();
	}
}
