import kr.or.bit.Singleton;

public class Ex15_Singleton_main {

	public static void main(String[] args) {
		//Singleton single = new  안보여융
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();
		Singleton s5 = Singleton.getInstance();
		
		System.out.println(s + " , " +s2 + " , " +s3+ " , "+s4+ " , "+s5+ " , ");
		System.out.println(s==s2);
		System.out.println(s==s3);
		System.out.println(s==s4);
		System.out.println(s==s5);
	}

}
