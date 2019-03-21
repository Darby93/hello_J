package Group_2;

public class Coffee {
	private String coffeeName; // Ŀ�� �̸�
	private int coffeeId; // Ŀ�� ������ȣ
	private int coffeePrice; // Ŀ�� ����

	private int[] recipe; // Ŀ�� ��� ��뷮
	
	public Coffee() {}

	public Coffee(String coffeeName, int coffeeId, int[] recipe, int coffeePrice) { // Ŀ�� ������ �Լ�
		this.coffeeName = coffeeName;
		this.coffeeId = coffeeId;
		this.recipe = recipe;
		this.coffeePrice = coffeePrice;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public int getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public int getCoffeePrice() {
		return coffeePrice;
	}

	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	public int[] getRecipe() {
		return recipe;
	}

	public void setRecipe(int[] recipe) {
		this.recipe = recipe;
	}
	
	
	
	
	
}