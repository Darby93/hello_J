/*
현실세계 ... 설계도가 여러장 ... (연관성)

여러개의 설계도 작성시 .....(관련성)

기준점
상속관계 (is ~ a : 상속) 은 ~ 이다  (부모가 뒤쪽 )
>> 원은 도형이다(O)
>> 사각형은 도형이다(O)

포함관계 (has ~ a : 포함) 은 ~을 가지고 있다
>> 경찰은 총을 가지고 있다(O)
--------------------------------------------------
원클래스
도형클래스

>> 상속 (원 extends 도형)
--------------------------------------------------
원은 점이다 (x)
원은 점을 가지고 있다 (o) (has ~ a ) 포함관계

>> class 원 { 점 변수명 ;}
--------------------------------------------------
경찰, 총
경찰은 총을 가지고 있다 (o) (has ~ a ) 포함관계
class 경찰 {}
class 총 {}

class 경찰 {총 gun;}
--------------------------------------------------
원, 사각형, 삼각형 만드는 설계를 작성
원 : 한점과 반지름, 그리다 , 색상
삼각형 : 3개의 점을, 그리다 , 색상 
사각형 : 4개의 점을, 그리다 , 색상 
점 : (x,y)

정의
원은 도형이다
삼각형은 도형이다
사각형은 도형이다

도형 : (일반화, 추상화) 분모 : 색상, 그리다
원 : (구체화, 특수화) -> 점, 반지름

점 정의 (x,y)
원은 점이다 (x)
삼각형은 점이다 (x)

원은 점을 가지고 있다
삼각형은 점을 가지고 있다
사각형은 점을 가지고 있다
(has ~ a)

일반화, 추상화(공통분모) : shape (색상, 그리다)
                   : point(x, y)

class Shape{}
class Point{}

구체화, 특수화 (circle, triangle)

*/

//추상화, 일반화
class Shape{
	String color = "gold";
	void draw() {
		System.out.println("도형을 그리다");
	}
}

class Point {
	int x;
	int y;
	
	Point(){
		//this.x = 1;
		//this.y = 2;
		this(1,2);
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}




//원을 만드세요 (정의 : 한점과 반지름을 가지고  있다)
//원은 도형이다 ( is ~ a ) extends
//원은 점을 가지고 있다 (has ~ a) 참조변수

//원 특수성, 구체성 : 반지름

class Circle extends Shape{
	Point center; //member field(부품)  has ~ a
	int r; //member filed (특수성, 구체화)
	
	public Circle() {
		this.center = new Point(5,8);
		this.r = 10;
	}
	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
}

class Triangle extends Shape {
	Point[] pointarr;

	public Triangle() {
//		x = new Point(10, 20);
//		y = new Point(30, 40);
//		z = new Point(50, 60);
//		this(new Point(10,20), new Point(30, 40), new Point(50, 60));
		// Point [] parray = new Point[]{new Point(1,2....}
		this(new Point[] { new Point(1, 2), new Point(3, 4), new Point(5, 6) });

	}

	public Triangle(Point[] pointarr) {
//		this.x = x;
//		this.y = y;
//		this.z = z;
		this.pointarr = pointarr;
	}
	
	

	public void trianglePoint() {
//	System.out.printf("\nx : (%d,%d)",x.x,x.y);
//	System.out.printf("\ny : (%d,%d)",y.x,y.y);
//	System.out.printf("\nz : (%d,%d)",z.x,z.y);
		for (Point point : pointarr) {
			System.out.println(point.x + " , " + point.y);
		}
	}

}

// 문제 1)
// 삼각형 클래스 만들기
// 정의 : 삼각형은 세개의 점과 색상 그리고 그리다 기능을가짐
// Shape, point 활용해서 작업하세요
// 세개의 점은 (x,y), (x,y), (x,y)
// default 삼각형을 그릴 수 있고 3개의 자표값을 받아서 그릴 수 있다
public class Ex02_Inherit_Composite {

	public static void main(String[] args) {
//		Circle c = new Circle();
//		c.draw();
//		System.out.println(c.color);
//		System.out.println(c.r);
//		System.out.println(c.center.x);
//		System.out.println(c.center.y);
//		
//		Point point = new Point(10,15);
//		Circle c2 = new Circle(point, 20);
//		System.out.println();
//		System.out.println(c2.color);
//		System.out.println(c2.r);
//		System.out.println(c2.center.x);
//		System.out.println(c2.center.y);
//		c2.draw();
//		
		
		
		
		Point[] triarr = {new Point(1,2), new Point(3,4), new Point(100,102)};
		
		Triangle tri = new Triangle(triarr);
		System.out.println();
		tri.trianglePoint();
		tri.draw();

		
		Triangle tri2 = new Triangle();
		tri2.trianglePoint();
		
//		Point[] point2 = {new Point(1,2), new Point(3,4), new Point(5,6)};
//		Triangle tri4 = new Triangle();
		
		Triangle tri3 = new Triangle();
        tri3.trianglePoint();		

		
		
	}

}
