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
			System.out.println("����: " +score+"  ��ǰ : "+gift);
		case 900 :
			gift += "Notebook, ";
			System.out.println("����: " +score+"  ��ǰ : "+gift);
		case 800 :
			gift += "�����, ";
			System.out.println("����: " +score+"  ��ǰ : "+gift);
		case 700 :
			gift += "�ѿ켼Ʈ, ";
			System.out.println("����: " +score+"  ��ǰ : "+gift);
		case 600 :
			gift += "����";
			break;
		default :
			gift = "ĩ��";

		}
		
		System.out.println("����: " +score+"  ��ǰ : "+gift);
		
	}

}
