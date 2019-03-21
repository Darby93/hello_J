package Study_class;

public class Card {
	public int num;
	public String shape;
	
	public static int h;
	public static int w;

	
	public static int n = 0;
	

	
	
	
	public void cardInfo() {
		n ++;
		System.out.print("\n누적카드 : " + n);
		System.out.printf("\n모양 : %s , 높이 : %d , 넓이 : %d",shape,h,w);
	}
	
	
}
