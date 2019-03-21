/**
 * 카페의 매출을 관리하는 솔루션 개발 ================================= 카페는 2종류의 커피와 2종류의 차를 팔고
 * 있습니다.
 *
 * 커피와 차는 각각 고유의 가격을 가지고 있습니다. 커피는 Americano, CaffeLatte라는 이름을 가지고 있습니다. 차는
 * Chamomile, MilkTea라는 이름을 가지고 있습니다. Coffee 클래스와 Tea 클래스가 존재한다. 커피 2종류와 차 2종류는
 * Coffee 클래스와 Tea 클래스를 상속한다. ex) Americano - 2000원, MilkTea - 3000원
 *
 * 시뮬레이션 시나리오 카페 : 매출 정보를 가지고 있다. 예 : 현재까지 매출 5000원 카페는 음료(Drink)를 판다. 음료를 팔면
 * 매출이 증가한다. 매출은 0으로 시작한다. 음료를 파는 함수는 sell 하나만 만들어 사용한다. 음료를 팔면 어떤 음료를 판매했는지
 * 출력하고 현재 매출이 얼마인지 출력한다. (계층적 상속 사용) (edited)
 */

class Drink{
	
	int price;
	
	Drink(int price){
		this.price = price;
	}
}

class Coffee extends Drink{

	Coffee(int price) {
		super(price); //Drink()
	}

}

class Tea extends Drink{
	
	Tea(int price) {
		super(price); //Drink()
	}
	
}

class Chamomile extends Tea {
	Chamomile() {
		super(4000); // Tea(4000)
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Chamomile";
	}
}

class Americano extends Coffee {

	Americano() {
		super(1000);
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "Americano";
	}

}

class MilkTea extends Tea {
	MilkTea() {
		super(3000);
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "MilkTea";
	}
}



class CaffeLatte extends Coffee {

	CaffeLatte() {
		super(2000);
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "CaffeLatte";
	}

}

class Shop{
	int sales = 0;
	
	void sell(Drink n) {
		this.sales += n.price;
		System.out.println(n.toString());
		System.out.println(sales);
	}
	
}


public class POLY_02 {

	public static void main(String[] args) {
		
		Chamomile c = new Chamomile();
		MilkTea m = new MilkTea();
		Americano a = new Americano();
		CaffeLatte ca = new CaffeLatte();
		
		Shop s = new Shop();
		s.sell(c);
		s.sell(ca);
		s.sell(ca);
		s.sell(ca);
		s.sell(ca);
		s.sell(ca);
		s.sell(ca);
		
		
	}

}
