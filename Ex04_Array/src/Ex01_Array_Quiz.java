
public class Ex01_Array_Quiz {

	public static void main(String[] args) {
		//수학과 학생들의 기말고사 시험점수 
		int [] score = new int[] {79,88,97,54,54,95};
		int max = score[0]; //79
		int min = score[0]; //79
		
		/*
		제어문을 사용해서 max 변수에 최대값 (최고점수) min 변수에는 최소값(최하점수)
		값이 들어가게 하세요!
		결과) max > 97   , min > 54
		*/
		
		for(int i = 1; i < score.length; i++) {
			if(max < score[i]) {
				max = score[i];
			}
			if(min > score[i]) {
				min = score[i];
			}
			System.out.println();
			
		}
		System.out.println(max);
		System.out.println(min);
		
		for(int i = 1; i < score.length; i++) {
			max = (max > score[i]) ? max : score[i];
			min = (min < score[i]) ? min : score[i];
		}
		System.out.println(max);
		System.out.println(min);
		
		int[] number = new int[10];
		
		//10개 방의 값을 1~10까지 초기화 하고 싶어요
		//number[0]
		
		for(int i = 0; i < number.length; i++) {
			number[i] = i+1;
		}
		for(int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
		}
		
		//어느 학생의 기말고사 시험 점수 입니다(5과목)
		int sum = 0;
		float average = 0f;
		int[] jumsu = {100,55,90,60,78};
		
		/*
		1. 총 과목수
		2. 과목의 합 (총점)
		3. 과목의 평균
		단) 2,3 문제는 하나의 for문을 사용하세요
		*/
		
		for (int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];
			if (i == jumsu.length-1) {
				average = (float)sum/jumsu.length;	
			}
		}
		
		
		//System.out.printf("총과목수 : [%d] , 총점 : [%d]", number.length, sum);
		System.out.printf("총과목수 : [%d] , 총점 : [%d], 평균 : [%f]", jumsu.length, sum, average);
		
		
		
		
		
	}

}
