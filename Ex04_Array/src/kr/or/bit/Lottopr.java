package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

//���赵
//Lotto lotto = new Lotto();
//lotto.SelectLottoNumber(); >>
//1 �� �Է� >> selectBasicNumber()  �Լ� ȣ�� (�ǹ�ȣ ����) >> ���
//2 �� �Է� >> ���α׷� ����

public class Lottopr {
	private Scanner scanner; // ��ǰ
	private Random r; // ��ǰ
	private int[] numbers;

	// static{} , {} �ʱ���
	public Lottopr() { // Ư���� ���� : member field �ʱ�ȭ : (������ �Լ�), constructor
		scanner = new Scanner(System.in); // �ʱ�ȭ (���� ������ �ּҰ��� ���� ��)
		r = new Random();
		numbers = new int[6];
	}

	// ����� �����ϼ���
	//

	// r.nextInt(45)+1 >> 1~45

//	public void SelectLottoNumber() {
	private String displayMenu() {
		String menu;

		do {
			System.out.println("*******************");
			System.out.println("*******�ζ�*******");
			System.out.println("1. �ζ� ��ȣ �̱� ");
			System.out.println();
			System.out.println("2. �����ϱ� ");
			System.out.println();
			System.out.println("3. ����ϱ�");
			System.out.println();
			System.out.println("4. ���α׷� ����");
			System.out.println();
			try {
				menu = scanner.nextLine();
				if (menu.equals("1") || menu.equals("2") || menu.equals("3") || menu.equals("4")) {
					break;
				} else {
					throw new Exception("���� �߻� ^^");
				}
			} catch (Exception e) {
				System.out.println("�޴��� �߸� ����");
				System.out.println("�޴�(1~4)���� ����");
			}

		} while (true);
		return menu;

	}

	private void lottoNumber() {
		System.out.println("�ζ� ��ȣ");

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt(45) + 1; // ����
			for (int j = 0; j < i; j++)
				if (numbers[i] == numbers[j]) {
					i--; // point
					break;
				}

		}

	} // inputRecord end

	private void lottoSort() {
		System.out.println("�ζ� ����");

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
				System.out.println("���α׷� ����");
				break a;
			}
		}

	}
	
	//����(��� �Լ�) (6���� ���� ���ؼ� 6���� ���� ����� ������ 5���� ũ�ų� ����
	//10���� �۰ų� ������ ��ȣ ����
	//(avg > = 5 && avg <= 10) true���� ... �̹����� �ƴϸ� �������ϰڴ�
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
