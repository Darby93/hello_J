/*동물원의 먹이를 주고 관리하는 솔루션 개발

[A 동물원의 요구사항]
동물들은 먹이를 먹는 양을 공통적으로 가지고 있습니다.
각각의 동물들은 고유한 이름을 가지고 있습니다.
ex)
각각의 동물은 이름을 가지고 있다(Monkey, Lion, Tiger)
각각의 동물은 다른 양의 먹이를 먹는다(Monkey : 300, Lion : 500)

시뮬레이션 시나리오
사육사 : 동물에게 주는 먹이의 양 정보를 가지고 있다.
예 : 먹이 1000g
사육사는 먹이를 줄 수 있다. 먹이를 주면 가지고 있는 먹이는 감소한다
사육사는 초기 먹이를 가질 수 있다.
현재 동물원에는 원숭이(Monkey), 사자(Lion), 호랑이(Tiger) 3마리가 살고 있다
3마리에게 먹이를 주는 함수를 구현
3마리에게 모두 먹이를 주어야 한다.*/
class Animal{
	int feed;
	
	
	
	Animal(int feed){
		this.feed = feed;
	}
	
}

class Monkey extends Animal{
	
	
	Monkey(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Monkey";
	}
	
}

class Tiger extends Animal{
	
	
	Tiger(){
		super(300);
	}
	
	@Override
	public String toString() {
		return "Tiger";
	}
	
}

class Lion extends Animal{
	
	
	Lion(){
		super(400);
	}
	
	@Override
	public String toString() {
		return "Lion";
	}
	
}

class Trainer{
	int feedAmount = 1000;
	
	void give(Animal n){
		this.feedAmount -= n.feed;
		System.out.println("남은양 : " + this.feedAmount);
		
		if(this.feedAmount >= n.feed) {
			System.out.println("먹이를 줬습니다");
		}else {
			System.out.println("사료가 부족합니다");
		}
	}
	
	
	
}


public class POLY_01 {
	public static void main(String[] args) {
		Lion l = new Lion();
		Tiger t = new Tiger();
		Monkey m = new Monkey();
		
		Trainer tr = new Trainer();
		
		tr.give(l);
		tr.give(t);
		tr.give(t);
		tr.give(m);
		
	}

}
