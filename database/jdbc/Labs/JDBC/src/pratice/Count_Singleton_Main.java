package pratice;

public class Count_Singleton_Main {
	
	private static final int maxNumber = 10;
	
	public static void main(String[] args) {
		
		Count_singleton cs = Count_singleton.getInstance();
		Count_singleton cs2 = Count_singleton.getInstance();
		
		while(cs.getNumber() < maxNumber) {
			cs.counting();
			System.out.println("cs : " + cs.getNumber());
			
			// 주소값이 같아서  같이 올라감
			
			System.out.println("cs2 : " + cs2.getNumber());
		}
		
		
	}

}
