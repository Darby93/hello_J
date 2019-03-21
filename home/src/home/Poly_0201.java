package home;

class Drink2{
	int price;
	int sales;
	
	Drink2(int price){
		this.price = price;
	}
}

class Coffee2 extends Drink2{
	Coffee2(int price){
		super(price);
	}
}

class Tea2 extends Drink2{
	Tea2(int price){
		super(price);
	}
}

class Americano2 extends Coffee2{
	Americano2(){
		super(2000);
	}

	@Override
	public String toString() {
		return "?ïÑÎ©îÎ¶¨Ïπ¥ÎÖ∏";
	}
}

class CaffeLatte2 extends Coffee2{
	CaffeLatte2(){
		super(3000);
	}

	@Override
	public String toString() {
		return "Ïπ¥Ìéò?ùº?ñº";
	}
}

class Chamomile2 extends Tea2{
	Chamomile2(){
		super(4000);
	}

	@Override
	public String toString() {
		return "Ïº?Î™®Îßà?ùº";
	}
}

class MilkTea2 extends Tea2{
	MilkTea2(){
		super(5000);
	}

	@Override
	public String toString() {
		return "Î∞??Å¨?ã∞";
	}
}

class Shop2{
	int sales = 0;
	
	void sell (Drink2 d) {
		
		sales += d.price;
		System.out.println(d.toString());
		System.out.println(d.price);
		System.out.println(this.sales);
		
		
		
	}
	
}


public class Poly_0201 {

	public static void main(String[] args) {
		CaffeLatte2 ca2 = new CaffeLatte2();
		Chamomile2 ch2 = new Chamomile2();
		MilkTea2 m2 = new MilkTea2();
		Americano2 a2 = new Americano2();
		
		Shop2 s2 = new Shop2();
		s2.sell(ca2);
		s2.sell(ch2);
		
	}

}
