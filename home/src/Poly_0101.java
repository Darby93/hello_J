
class Animal2{
	int feed;
	Animal2(int feed){
		this.feed = feed;	
	}	
}

class Monkey2 extends Animal2{
	
	Monkey2(){
		super(300);
	}
	
	@Override
	public String toString() {
		return "Monkey2";
	}
	
}

class Lione2 extends Animal2{
	
	Lione2(){
		super(500);
	}
	
	@Override
	public String toString() {
		return "Lione2";
	}
	
}

class Tiger2 extends Animal2{
	
	Tiger2(){
		super(400);
	}
	
	@Override
	public String toString() {
		return "Tiger2";
	}
	
}

class Trainer2{
	int feedamount = 1200;
	
	
	void feeding(Animal2 a) {
		if(this.feedamount < a.feed) {
			System.out.println("먹이가 부족다");
			return;
		}
		this.feedamount -= a.feed;
		System.out.println("먹이를 줬다");
		System.out.println(this.feedamount);
	    System.out.print("남았따\n");
	}
	
}





public class Poly_0101 {

	public static void main(String[] args) {
		Tiger2 t = new Tiger2();
		Monkey2 m = new Monkey2();
		Lione2 l = new Lione2();
		
		Trainer2 t2 = new Trainer2();
		
		t2.feeding(t);
		t2.feeding(m);
		t2.feeding(l);
		t2.feeding(t);
		
		
		
	}

}
