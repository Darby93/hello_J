import java.util.Scanner;

public class assignment01 {

	public static void main(String[] args) {
        int score = ((int)(Math.random()*10)+1)*100;
		System.out.println(score);
		Scanner sc = new Scanner(System.in);
		String gift = "";
	//	int score = sc.nextInt();

		//
		
		switch (score) {
		case 1000 : 
			gift += "Tv, ";
			System.out.println("점수: " +score+"  상품 : "+gift);
		case 900 :
			gift += "Notebook, ";
			System.out.println("점수: " +score+"  상품 : "+gift);
		case 800 :
			gift += "냉장고, ";
			System.out.println("점수: " +score+"  상품 : "+gift);
		case 700 :
			gift += "한우세트, ";
			System.out.println("점수: " +score+"  상품 : "+gift);
		case 600 :
			gift += "휴지";
			break;
		default :
			gift = "칫솔";

		}
		
		System.out.println("점수: " +score+"  상품 : "+gift);
		
	}

}
