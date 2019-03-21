package pattern;

public class GreenTea extends Drink {
	
	
	@Override
	public void input() {
		System.out.println("찻잎을 넣는다");
		
	}

	@Override
	public void make() {
		System.out.println("녹차를 만든다");
	}
	
}
