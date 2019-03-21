package home;

import java.util.Scanner;

/*
Quiz
만들려고 하는 시스템은 백화점 경품 추첨 시스템입니다
경품 추천시 1000 점수가 나오면
경품으로 Tv, Notebook, 냉장고, 한우세트, 휴지
경품 추천시 900 점수가 나오면
경품으로 NoteBook, 냉장고, 한우세트, 휴지
경품 추천시 800 점수가 나오면
경품으로 냉장고, 한우세트, 휴지
경품 추천시 700 점수가 나오면
경품으로 한우세트, 휴지    
경품 추천시 600 점수가 나오면
경품으로 휴지  
그외는 100 ~ 500 까지는 칫솔

사용자가 와서 경품 시스템 사용하게 되면 랜덤하게 100 ~ 1000 까지의 점수가 나옴


*/

public class home_1 {
	public static void main(String[] args) {
		int score =  ((int)(Math.random()*10)+1)*100;
		System.out.println(score);
		Scanner sc = new Scanner(System.in);
		String gift = "";
		
		System.out.println("1누르면 경품시작");
		while(true) {
			int r = sc.nextInt();
			if ( r != 1) {
				System.out.println("다시누르세요");
			}else {
				System.out.println("경품추첨이 시작됩니다");
			} 
			switch(score) {
			case 1000: 
				break;
			case 900: 
				break;
			case 800: 
				break;
			case 700: 
				break;
			case 600: 
				break;
			default : gift = "칫솔";
				break;
				
			}
	
			
		}
		
		
		
		
		
	}

}
