package Study_class;

public class Motor {
	private String brand;
	private String model;
	private String color;
	public static int n = 0;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void motorInfo() {
		n ++;
		System.out.print("\n누적대수 : " + n);
		System.out.printf("    브랜드 : %s , 모델 : %s , 색상 : %s" , brand , model, color);
	}

	
	
	
	
	
}
