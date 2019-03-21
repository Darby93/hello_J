

public class Coffee {
	private String coffeeName; // 커피 이름
	private int[] recipe;      // 커피 재료 사용량
	private int coffeePrice;   // 커피 가격
	private boolean ice = false;

	public Coffee(String coffeeName, int[] recipe, int coffeePrice) { // 커피 생성자 함수
		this.coffeeName = coffeeName;
		this.recipe = recipe;
		this.coffeePrice = coffeePrice;
	}

	public boolean isIce() {
		return ice;
	}

	public void setIce(boolean ice) {
		this.ice = ice;
	}
	
	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public void setRecipe(int[] recipe) {
		this.recipe = recipe;
	}

	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	public int[] getRecipe() {
		return recipe;
	}

	public int getCoffeePrice() {
		return coffeePrice;
	}
}