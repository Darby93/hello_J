package Study_class;

public class Fan {
	private String brand;
	private String model;
	private String color;
	public int speed;
	public boolean power;
	public static int price;
	public static int n = 0;
	
	Motor mo;
	
	
	
	
	
	public void powerOn() {
		power = true;
		System.out.println("전원이 켜졌습니다");
	}

	public void powerOff() {
		power = false;
		System.out.println("전원이 꺼졌습니다");
	}
	
	public void speed(int speed) {

		System.out.println(speed + "단계입니다.");
	}
	
	public void fanInfo() {
		System.out.printf("    브랜드 : %s , 모델 : %s , 색상 : %s" , brand , model, color);
	}

	
	
	
	
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
	

	
	
	

	
	    

}


