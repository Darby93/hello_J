

public class MilkcoffeeMaterial extends Material{
	public int milk = 100;
	
	@Override
	public void make() {
		this.milk--;
		this.paperCup--;
		this.coffeePowder--;
		this.hotWater--;
		System.out.println("밀크커피");
	}

	@Override
	public boolean canMakeCoffee() {
		int[] material = { hotWater, milk, coffeePowder, paperCup };
		swap(material);
		return material[0] <= 0;
	}

	@Override
	public int countOfCoffee() {
		int[] material = { hotWater, milk, coffeePowder, paperCup };
		swap(material);
		return material[0];
	}

}
