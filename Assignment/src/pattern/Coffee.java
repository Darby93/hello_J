package pattern;

public class Coffee extends Drink{
	@Override
	public void input() {
		System.out.println("원두를 넣는다");
		
	}

	@Override
	public void make() {
		System.out.println("커피를 만든다");
	}
}
