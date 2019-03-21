/*
1. 1~45������ ������ �߻����� 6���� �迭�� ��������
2. �迭�� ��� 6���� �迭���� �ߺ����� ������ �ȵǿ�
3. �迭�� �ִ� 6���� ���� ���� ������ ���� ��Ű����
4. �� ����� ��� �ִ� �迭�� ����ϼ���


*/
public class Ex02_Lotto_Main {

	public static void main(String[] args) {
		//1, 2 �������������!
		
		int [] lotto = new int[6];
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45+1);  // ����
			for(int j = 0; j < i; j++) 
				if(lotto[i] == lotto[j]) {
					i--; //point
					break;
				}
			
		}
		
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}
		
		
	}

}