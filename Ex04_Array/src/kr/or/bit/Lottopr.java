package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

//설계도
//Lotto lotto = new Lotto();
//lotto.SelectLottoNumber(); >>
//1 값 입력 >> selectBasicNumber()  함수 호출 (실번호 추출) >> 출력
//2 값 입력 >> 프로그램 종료

public class Lottopr {
	private Scanner scanner; // 부품
	private Random r; // 부품
	private int[] numbers;

	// static{} , {} 초기자
	public Lottopr() { // 특수한 목적 : member field 초기화 : (생성자 함수), constructor
		scanner = new Scanner(System.in); // 초기화 (참조 변수는 주소값을 갖는 것)
		r = new Random();
		numbers = new int[6];
	}

	// 기능을 구현하세요
	//

	// r.nextInt(45)+1 >> 1~45

//	public void SelectLottoNumber() {
	private String displayMenu() {
		String menu;

		do {
			System.out.println("*******************");
			System.out.println("*******로또*******");
			System.out.println("1. 로또 번호 뽑기 ");
			System.out.println();
			System.out.println("2. 정렬하기 ");
			System.out.println();
			System.out.println("3. 출력하기");
			System.out.println();
			System.out.println("4. 프로그램 종료");
			System.out.println();
			try {
				menu = scanner.nextLine();
				if (menu.equals("1") || menu.equals("2") || menu.equals("3") || menu.equals("4")) {
					break;
				} else {
					throw new Exception("문제 발생 ^^");
				}
			} catch (Exception e) {
				System.out.println("메뉴를 잘못 선택");
				System.out.println("메뉴(1~4)까지 선택");
			}

		} while (true);
		return menu;

	}

	private void lottoNumber() {
		System.out.println("로또 번호");

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt(45) + 1; // 추출
			for (int j = 0; j < i; j++)
				if (numbers[i] == numbers[j]) {
					i--; // point
					break;
				}

		}

	} // inputRecord end

	private void lottoSort() {
		System.out.println("로또 정렬");

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	} // deleteRecord end

	private void lottoPrint() {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	} // sortRecord end

	public void menu1() {
		a: while (true) {
			switch (displayMenu()) {
			case "1":
				lottoNumber();
				break;
			case "2":
				lottoSort();
				break;
			case "3":
				lottoPrint();
				break;
			case "4":
				System.out.println("프로그램 종료");
				break a;
			}
		}

	}
	
	//검증(기능 함수) (6개의 합을 구해서 6으로 나눈 평균의 범위가 5보다 크거나 같고
	//10보다 작거나 같으면 번호 추출
	//(avg > = 5 && avg <= 10) true리턴 ... 이범위가 아니면 재추출하겠다
//	private boolean checkAverage(int[] numbers) {
//		int sum = 0;
//		int average=0;
//		for(int i = 0; i < numbers.length; i++) {
//			sum+= numbers[i];
//		}
//		average = sum/numbers.length;
//		
//	}
//	
	

} // end Lotto
