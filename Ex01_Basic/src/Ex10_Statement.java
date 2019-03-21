
public class Ex10_Statement {
	public static void main(String[] args) {
		/*
		 제어문
		 조건문(분기문) : if(단일, else, else if), switch() case break....
		 반복문 : for(반복횟수가 명확), while(조건만일치하면 무한루프), do~while()강제적실행
         break(블럭탈출), continue(아래 구문 skip)
		*/
		
		int count = 0; // local variable (초기화 필요)
		if (count < 1) {
			System.out.println("True");
		}
		
		
		if (count < 1) System.out.println("True {생략}"); 
		// 중가로 없이도 가능함
		
		char data = 'A';  //조건값으로 : 숫자, char, String 가능
		switch(data) {
			case 'A' : System.out.println("문자비교");
				break;
			default : System.out.println("default");
		}
		
		//반복문
		int sum = 0;
		for(int i = 0; i <= 10; i++) {
			//System.out.println("i :" + i);
			//sum = sum + i
			sum += i;
		}
		System.out.println("1부터 10까지 합 : " + sum);
		
		
		//for 문을 사용해서 1~10 까지의 홀수의 합을 구해보세요
		//for문 외에 다른 제어구문은 사용하지 마세요 (if(x))
		
		int sum1 = 0;
		for (int i = 1; i <= 10; i+=2) {
			//System.out.println("i :" + i);
			sum1 += i;
		}
		System.out.println(sum1); // (1~10까지 홀수의 합)
		
		//1~100까지 짝수의 합
		
		int sum2 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i%2 != 0) {
				sum2+=i;
			}
			
		}
		System.out.println(sum2);
		
		//입사시험 대표적인 문제 (구구단) : 변형
		//for문 (중첩) >> 행과열
		
		for (int i = 2; i<=9; i++) {
			for (int j = 1; j<=9; j++) {
				//System.out.println("i : " + i+"  j : "+j);
				System.out.printf("[%d]*[%d] = [%d]\t\n", i, j, i*j);
			}
			System.out.println();
		}
		System.out.println("****************************************************");
		
		// Key Point (break(탈출), continue(스킵))
		for (int i = 2; i<=9; i++) {
			for (int j = 1; j<=9; j++) {
				//if( i == j)
				//	continue; //아래 구문을 skip (그냥 넘어가라)
				if (i == j) break;
				System.out.printf("[%s]\t", "*");
				//System.out.printf("[%d]*[%d] = [%d]\t", i, j, i*j);
			}
			System.out.println();
		}
		
		
		for (int i = 2 ; i <= 9; i++) {
			for(int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 100; i >= 0; i--) { //시작값을 큰 값으로
			System.out.println("i : " + i);
			
		}
		
		//재미로 ..(피보나치).. 정보처리
		System.out.println("피보나치");
		int a = 0, b = 1, c = 0;
		
		for(int i = 0; i <= 9 ; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println(" " + c);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
