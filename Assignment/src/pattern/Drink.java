package pattern;

public abstract class Drink {
	
	public void method() {
		boil();
		input();
		make();
		pour();
	}
	
	
	public void boil() {
		System.out.println("물을 끓인다");
	}
	
	protected abstract void input();
	protected abstract void make();
	
	public void pour() {
		System.out.println("음료를 따른다");
	}
}
