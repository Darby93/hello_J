package Study_class;

public class Card {
	public int num;
	public String shape;
	
	public static int h;
	public static int w;

	
	public static int n = 0;
	

	
	
	
	public void cardInfo() {
		n ++;
		System.out.print("\n����ī�� : " + n);
		System.out.printf("\n��� : %s , ���� : %d , ���� : %d",shape,h,w);
	}
	
	
}
