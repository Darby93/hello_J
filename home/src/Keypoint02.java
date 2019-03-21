
class Product2{
	int point;
	int price;
	
	Product2(int price){
		this.price = price;
		this.point = (int)(price/10.0);
	}
	
}

class Keyboard extends Product2{
	Keyboard(){
		super(3000);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "키보드다";
	}
}

class Mouse extends Product2{
	Mouse(){
		super(2000);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "마우스다";
	}
}

class speaker extends Product2{
	speaker(){
		super(1000);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "스피커다다";
	}
}

class Buyer2{
	int money = 6000;
	int point = 0;
	
	void Buy2(Product2 p) {
		if(this.money < p.price) {
			System.out.println("돈부족해");
			return;
		}
		
		this.money -= p.price;
		this.point += p.point;
		System.out.printf("[%s]가 판매되었습니다\n", p.toString());
		System.out.println("가격 : " + p.price);
		System.out.println("누적포인트 : " + this.point);
	}
	
}

public class Keypoint02 {

	public static void main(String[] args) {
		Keyboard k = new Keyboard();
		Mouse m = new Mouse();
		speaker s = new speaker();
		Buyer2 b = new Buyer2();
		
		b.Buy2(k);
		b.Buy2(m);
		b.Buy2(s);
		b.Buy2(s);
		
	}

}
