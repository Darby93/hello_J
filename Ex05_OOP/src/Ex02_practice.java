class Shape2 {
	String color;
	
}

class Point2{
	int x;
	int y;
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


class Quadrangle extends Shape2{
	Point [] quadra;
	
	public Quadrangle() {
		this(new Point[] {new Point(1,2), new Point(3,4), new Point(5,6), new Point(7,8)});
	}
	
	public Quadrangle(Point [] quadra) {
		this.quadra = quadra;
	}
	
	public void QuadraPrint() {
		for (Point arr : quadra) {
			System.out.println(arr.x + " / " + arr.y);
		}
	}
	
	
}


public class Ex02_practice {

	public static void main(String[] args) {
		
		Quadrangle q = new Quadrangle();
		q.QuadraPrint();
		
		Point[] quadra = {new Point(1,2),new Point(1,2),new Point(1,2),new Point(1,2)};
		Quadrangle q2 = new Quadrangle(quadra);
		q2.QuadraPrint();
	}

}
