package Group_2;

public class Vacuum {
		public String company;
		public String modelName;
		public String color;
		public String date;
		public int maxBattery;
		
		public int level;
		public boolean power;
		public int currentBattery;
		public int motorSpeed;
		
		Motor motor = new Motor();
		Charger charger = new Charger();
		Head head = new Head();
		
		public void powerOn() {
			power = true;
		}
		public void powerOff() {
			power = false;
		}
		
		public void showBattery() {
			int battery = (currentBattery / maxBattery) * 100;
			System.out.println("현재 배터리 : " + battery + "%");
		}
		
		public void setLevel(int buttonlevel) {
			switch (buttonlevel) {
			case 1:
				level = 1;
				break;
			case 2:
				level = 2;
				break;
			case 3:
				level = 3;
				break;
			default:
				level = 0;
			}
		}
		
		public void brushmethod(String a) {
			System.out.println(a+ "로 교체 되었습니다.");
		}
	
}
