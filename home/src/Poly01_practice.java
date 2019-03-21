import java.util.Scanner;

class Machine{
	int price;
	Machine(int price){
		this.price = price;
	}
}

class S10 extends Machine{
	S10(){
		super(1000);
	}

	@Override
	public String toString() {
		return "갤럭시s10";
	}
}

class  Ip extends Machine{
	Ip(){
		super(2000);
	}

	@Override
	public String toString() {
		return "아이폰7";
	}
}

class V40 extends Machine{
	V40(){
		super(500);
	}

	@Override
	public String toString() {
		return "V40";
	}
}

class Customer{
	
//	Scanner sc = new Scanner(System.in);
//	int money = sc.nextInt();
	int money = 50000;
	Machine [] cart = new Machine[10];
	int number = 0;
	
	
	void Buy(Machine machine){
		
		
		if(this.money < machine.price) {
			System.out.println("고객님 잔액이 부족합니다");
			return;
		}
		
		cart[number++] = machine;
		
		if(this.number > 10) {
			System.out.println("너무 많이 담았어요");
			return;
		}
		
		this.money -= machine.price;
		System.out.println(machine.price + "원 입니다");
		
	}	
	
	void Calculate(){
		int totalprice = 0;
		String totalname = "";
		
		for(int i = 0; i < number; i++) {
			totalprice += cart[i].price;
			totalname += cart[i].toString()+ " ";
		}
		
		System.out.println(totalprice);
		System.out.println(totalname);
		
		
	}
	
}



public class Poly01_practice {

	public static void main(String[] args) {
		Customer c = new Customer();
		V40 v = new V40();
		S10 s = new S10();
		Ip i = new Ip();
		
		c.Buy(v);
		c.Buy(v);
		c.Buy(v);
		c.Buy(i);
		c.Buy(s);
		
		c.Calculate();
	}

}
