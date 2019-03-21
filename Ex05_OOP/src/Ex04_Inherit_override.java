/*
Today Point : [상속 관계]에서 override : 상속관계에서의 메서드 재 정의
- 상속관계에서 자식클래스가 부모클래스의 메소드를 재정의
- 재정의 : 함수의 형태는 변화가 없이 ..... 내용만 바뀌이이이이이이이는 것
       : 틀의 변화가 아나리 내용의 변화 {함수의 실행 블럭 내용 변경}

문법)
1. 부모함수의 이름과 동일
2. 부모함수의 parameter 동일
3. 부모함수의 return type 동일
4. 결국에는 { 괄호안에 내용 변경 } \

*/

class Point5 {
	int x = 4;
	int y = 5;
	String getPosition() {
		return " x : " + this.x + " y : " + this.y;
	}
}

//3개의 점이 필요하다
//2개의 점을 가지고 있는 설계도 ...

class Point3D extends Point5 {
	int z = 6;
	
//	마우스 우클릭 소스에 게터세터 처럼 오버라이드 만드는 거 있음
//	@Override
//	String getPosition() {
//		// TODO Auto-generated method stub
//		return super.getPosition();
//	}
	
    //	String getPosition() {return " x : " + this.x + " y : " + this.y +  " z : " + z}
	// 틀린건 아닌데 오버라이드를함을 함
	
	//재정의를 강제하는 방법
	//@Override 선언 (Annotation)
	//Annotation : JAVA code 만으로 전달할 수 없는 부가적인 정보
	//[컴파일러]나 [개발툴] 전달하는 기능
	
//	@Override : 재정의 검사.....
	@Override
	String getPosition() {
		return " x : " + this.x + " y : " + this.y + " z : " + z; //재정의!  내용만!
	}
	
	
	
}


public class Ex04_Inherit_override {

	public static void main(String[] args) {
		Point3D point = new Point3D();
		point.x = 3;
		point.y = 6;
		point.z = 9;
		
		String result = point.getPosition();
		System.out.println(result);
		
	}

}
