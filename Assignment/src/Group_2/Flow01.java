package Group_2;

import java.util.Scanner;

public class Flow01 {

	public static void main(String[] args) {
		int unit = 10000;
		int num = 0;
		int sw = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("�Ӵϸ� �Է��ϼ���");
		int money = Integer.parseInt(sc.nextLine());
		

		
		while (true) {
			num = (int) (money / unit);
			System.out.printf("���� :  %d   �ż� : %d\n",unit,num);
			if (unit > 100) {
				money = money - unit * num;
				if (sw == 0) {
					unit = unit / 2;
					sw = 1;
				} else {
					unit = unit / 5;
					sw = 0;
				}
			} else {
				return;
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		}
	}
}