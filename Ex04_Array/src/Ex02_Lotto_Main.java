/*
1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요
3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요
4. 위 결과를 담고 있는 배열을 출력하세요


*/
public class Ex02_Lotto_Main {

	public static void main(String[] args) {
		//1, 2 버어어어어어어어어어언!
		
		int [] lotto = new int[6];
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45+1);  // 추출
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
