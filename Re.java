import java.util.Arrays;
import java.util.Scanner;

/*
 * 객체란 힙 메모리에 해당하는 것만인건가?
 * 객체란 클랴스만 
 * 
 */

class Person9 {
	String name;
	int age;
}

public class Re {
	public static void main(String[] args) {
		int[] intarr = new int[10];
		System.out.println(Arrays.toString(intarr));
		boolean[] booarr = new boolean[5];
		System.out.println(Arrays.toString(booarr));
		String[] sarr = new String[3];
		System.out.println(Arrays.toString(sarr));

		Person9[] objarr = new Person9[3];
		System.out.println(Arrays.toString(objarr));

		objarr[0] = new Person9();
		System.out.println(Arrays.toString(objarr));

		// 객체는 배열을 자리를 만들고, 주소값을 넣고
		// 2번 작업해야한다.
		objarr[0].name = "홍길동";
		objarr[0].age = 100;
		System.out.println(objarr[0].name + objarr[0].age);

		
		
		// 1. 1~10까지의 짝수의 합을 출력하시오.
		int[] num = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < num.length; i++) {
			if (i % 2 != 0) {
				num[i] += i;
				System.out.println("1~10까지의 짝수의 합:" + num[i]);
			}
		}

		// 2. 1~10까지 숫자 중 2의 배수의 합을 출력하시오.
		int[] num2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < num2.length; i++) {
			if (i % 2 != 0) {
				num2[i] += i;
				System.out.println("1~10까지의 2의 배수의 합:" + num2[i]);
			}
		}
		
		// 3. 수학,영어,국어 점수를 입력받아 평균을 구하고 출력하시오
		int[] score = {mat,eng,kor};
		Scanner sc = new Scanner(System.in);
		System.out.println("수학점수입력: ");
		score[0] = Integer.parseInt(sc.nextLine());
		System.out.println("영어점수입력: ");
		score[1] = Integer.parseInt(sc.nextLine());
		System.out.println("국어점수입력: ");
		score[2] = Integer.parseInt(sc.nextLine());
		
		int sum=0;
		double avg=0.0;
		
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		avg = (double)sum / score.length-1;
		System.out.println("수학: "+score[0]+"/ 영어: "+score[1]+"/ 국어: "+score[2]
				+"\n/총합: "+sum+"/ 평균:"+avg);
				
		
	}
}
