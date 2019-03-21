
public class produce_1 {

	public static void main(String[] args) {
		int score = 86;
		String grade = ""; // 문자열 초기화
		System.out.println("당신의 점수는 : " + score);

		// 85 95 A
		// 75 85
		if (score >= 86) {
			grade = "A";
			if (score < 90) {
				grade += "-";
			} else if (score < 95) {
				grade = "A";
			} else {
				grade += "-";
			}

			
		} else if (score >= 76) {
			grade = "B";
			if (score < 80) {
				grade += "-";
			} else if (score < 85) {
				grade = "A";
			} else {
				grade += "-";
			}
		}

		System.out.println(grade);

	}

}
