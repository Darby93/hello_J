

public class AmericanoMaterial extends Material {
	@Override
	public void make() {
		this.paperCup--;
		this.coffeePowder--;
		this.hotWater--;
		System.out.println("아메리카노");
	}

	@Override
	public boolean canMakeCoffee() {
		int[] material = { hotWater, coffeePowder, paperCup };
		swap(material);
		return material[0] <= 0;
	}

	@Override
	public int countOfCoffee() {
		int[] material = { hotWater, coffeePowder, paperCup };
		swap(material);
		return material[0];
	}
	
}
