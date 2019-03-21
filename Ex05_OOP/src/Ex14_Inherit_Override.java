
class Parent{
	int x = 100;
	void pmethod() {
		System.out.println("parent method");
	}
}

class Child4 extends Parent{
	int y = 200;
	
	int x = 2000; //c# 오버라이드 : 변수무시하기
	
	void parent_x() {
		System.out.println(super.x);
	}
	
	@Override
	void pmethod() {
		System.out.println("부모함수 재정의");
	}
	
	void parent_method() {
		super.pmethod();
	}
	
}

public class Ex14_Inherit_Override {

	public static void main(String[] args) {
		Child4 ch = new Child4();
		Parent pa = ch;
		//pa.y 접근 .... 부모껏만 사용가능
		System.out.println("ch.x " + ch.x);
		ch.parent_x();
		
		ch.pmethod();
		pa.pmethod();
		ch.parent_method();
	}

}
