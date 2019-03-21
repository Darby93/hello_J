
public class HazelnutMaterial extends Material {
	public int hznSyrup = 100;
	
	@Override
	public void make() {
		this.hznSyrup--;
		this.paperCup--;
		this.coffeePowder--;
		this.hotWater--;
		System.out.println("«Ï¿Ã¡Ò≥”");
	}

	@Override
	public boolean canMakeCoffee() {
		int[] material = { hotWater, hznSyrup, paperCup };
		swap(material);
		return material[0] <= 0;
	}

	@Override
	public int countOfCoffee() {
		int[] material = { hotWater, hznSyrup, paperCup };
		swap(material);
		return material[0];
	}

}
