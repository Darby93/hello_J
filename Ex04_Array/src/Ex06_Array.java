class Car{
	int door;
	String color;
}


public class Ex06_Array {

	public static void main(String[] args) {
		//2����(��� ��) : index : 0
		//[��][��]
		int[][] score = new int [3][2];
		System.out.println(score[0][0]);
		System.out.println(score[2][1]);
//		System.out.println(score[2][2]);
		
		score[0][0] = 100;
		score[0][1] = 200;
		
		score[1][0] = 300;
		score[1][1] = 400;
		
		score[2][0] = 500;
		score[2][1] = 600;
		
		System.out.println(score.length); //���� ����
		System.out.println(score[0].length); //���� ����
		
		//���� ���� : �迭�̸�.length >> score.length
		//���� ���� : �迭�̸�[i].length >> score[0].length
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				System.out.printf("score[%d][%d] = %d\n", i,j,score[i][j]);
			}
			System.out.println();
		}
		
		//Today Point (Array(���� : ����) >> Collection(����))
		//������ for��
		//C# : for(Type������ in �迭){��±���}
		//Java : for(Type������ : �迭){��±���}
		//Javascript : for(Type������ in �迭){��±���}
		
		int[] arr3 = {5,6,7,8,9,10};
		
//		for(int i = 0; i < arr3.length; i++) {
//			System.out.println(arr3[i]);
//		}
		
		for(int value : arr3) {
			System.out.println(value);
		}
		
		
		String[] strarr = {"A","B","C","D","FFF"};
		
		for(String a : strarr) {
			System.out.println(a);
		}
		
		//���� ����
		//1�� (Ŀ�� : 4000)
		int[][] score3 = new int [][] {
			                             {11,12},
			                             {13,14},
			                             {15,16},
		};
		
		
		//11,12,13,14,15,16
		for(int[] value : score3) {
			for(int row : value) {
			System.out.println(row);
			}
		}
		
		//��ü �迭
		Car[] cararr = new Car[2];
		cararr[0] = new Car();
		cararr[0].color = "red";
		cararr[0].door = 4;
		
		cararr[1] = new Car();
		cararr[1].color = "blue";
		cararr[1].door = 2;
		
		//�Ϲ� for ���� ����ؼ� �ڵ����� ����� ���� ���� ���
		for (int i = 0; i < cararr.length; i++) {
			System.out.println(cararr[i].color + "/" + cararr[i].door);
		}
		
		//������ for ���� ����ϼ���
		for(Car value : cararr) {
			System.out.println(value.color + "-" + value.door);
		}
		
		
		
		
		
	}

}