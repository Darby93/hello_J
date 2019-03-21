/*
���Ǽ��� ... ���赵�� ������ ... (������)

�������� ���赵 �ۼ��� .....(���ü�)

������
��Ӱ��� (is ~ a : ���) �� ~ �̴�  (�θ� ���� )
>> ���� �����̴�(O)
>> �簢���� �����̴�(O)

���԰��� (has ~ a : ����) �� ~�� ������ �ִ�
>> ������ ���� ������ �ִ�(O)
--------------------------------------------------
��Ŭ����
����Ŭ����

>> ��� (�� extends ����)
--------------------------------------------------
���� ���̴� (x)
���� ���� ������ �ִ� (o) (has ~ a ) ���԰���

>> class �� { �� ������ ;}
--------------------------------------------------
����, ��
������ ���� ������ �ִ� (o) (has ~ a ) ���԰���
class ���� {}
class �� {}

class ���� {�� gun;}
--------------------------------------------------
��, �簢��, �ﰢ�� ����� ���踦 �ۼ�
�� : ������ ������, �׸��� , ����
�ﰢ�� : 3���� ����, �׸��� , ���� 
�簢�� : 4���� ����, �׸��� , ���� 
�� : (x,y)

����
���� �����̴�
�ﰢ���� �����̴�
�簢���� �����̴�

���� : (�Ϲ�ȭ, �߻�ȭ) �и� : ����, �׸���
�� : (��üȭ, Ư��ȭ) -> ��, ������

�� ���� (x,y)
���� ���̴� (x)
�ﰢ���� ���̴� (x)

���� ���� ������ �ִ�
�ﰢ���� ���� ������ �ִ�
�簢���� ���� ������ �ִ�
(has ~ a)

�Ϲ�ȭ, �߻�ȭ(����и�) : shape (����, �׸���)
                   : point(x, y)

class Shape{}
class Point{}

��üȭ, Ư��ȭ (circle, triangle)

*/

//�߻�ȭ, �Ϲ�ȭ
class Shape{
	String color = "gold";
	void draw() {
		System.out.println("������ �׸���");
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




//���� ���弼�� (���� : ������ �������� ������  �ִ�)
//���� �����̴� ( is ~ a ) extends
//���� ���� ������ �ִ� (has ~ a) ��������

//�� Ư����, ��ü�� : ������

class Circle extends Shape{
	Point center; //member field(��ǰ)  has ~ a
	int r; //member filed (Ư����, ��üȭ)
	
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

// ���� 1)
// �ﰢ�� Ŭ���� �����
// ���� : �ﰢ���� ������ ���� ���� �׸��� �׸��� ���������
// Shape, point Ȱ���ؼ� �۾��ϼ���
// ������ ���� (x,y), (x,y), (x,y)
// default �ﰢ���� �׸� �� �ְ� 3���� ��ǥ���� �޾Ƽ� �׸� �� �ִ�
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
