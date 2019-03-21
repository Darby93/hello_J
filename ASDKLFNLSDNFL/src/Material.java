

public abstract class Material { // 1당 1인분으로 가정..
	public  int hotWater = 300;
	public  int coffeePowder = 300;
	public  int paperCup = 300;
	
	abstract public boolean canMakeCoffee();
	abstract public void make();
	abstract public int countOfCoffee();
	
	public int swap(int[] material) {
		for (int i = 0; i < material.length; i++) {
			for (int j = i + 1; j < material.length; j++) {
				if (material[i] > material[j]) {
					int swap = material[j];
					material[j] = material[i];
					material[i] = swap;
				}
			}

		}
		return material[0];
	}
}