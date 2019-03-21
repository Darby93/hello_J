class Product{
	int price;
	int bonuspoint;
	
	Product(int price){
		this.price = price;
		this.bonuspoint = (int)(price/10.0);
	}
	
}

class Tv extends Product{
	Tv(){
		super(3000);
	}

	@Override
	public String toString() {
		return "Tv";
	}
	
}

class Audio extends Product{
	Audio(){
		super(1000);
	}

	@Override
	public String toString() {
		return "Audio";
	}
	
}

class Notebook extends Product{
	Notebook(){
		super(2000);
	}

	@Override
	public String toString() {
		return "Notebook";
	}
	
}

class Buyer{
	int money = 6000;
	int bonuspoint;
	
	 void buy(Product p) {
		if(money < p.price) {
		    System.out.println("잔액이 부족합니다");
			return;
		}
		
		this.money -= p.price;
		this.bonuspoint += p.bonuspoint;
		System.out.println(p.toString());
		System.out.println("남은돈 : " + this.money);
		System.out.println("누적 보너스포인트 : " + this.bonuspoint);
		
	}
	
}

public class Keypoint {

	public static void main(String[] args) {
		Notebook n = new Notebook();
		Audio a = new Audio();
		Tv t = new Tv();
		Buyer b = new Buyer();
		
		b.buy(n);
		b.buy(a);
		b.buy(t);
		b.buy(t);
		
	}

}
