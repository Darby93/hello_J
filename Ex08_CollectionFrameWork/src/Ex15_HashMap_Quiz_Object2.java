import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class QuizProgram {
	HashMap<String, String> quizList;
	int score;
	Set<String> quizSet;
	Iterator<String> i;
	Scanner sc;
	int quizNumber;
	
	QuizProgram() {
		sc = new Scanner(System.in);
		score = 0;
		quizNumber = 1;
		quizList = new HashMap<String, String>();
		
		quizList.put("ㅅㅇㅅㅇㄷㅅㅋㄷ", "수어사이드스쿼드");
		quizList.put("ㄷㅋㄴㅇㅌ", "다크나이트");
		quizList.put("ㅂㅌㄹ", "베테랑");
		quizList.put("ㅇㄷㅅㅍㅌㄷ", "언디스퓨티드");
		quizList.put("ㅇㅅㅎㄴㄹㅇㅇㄹㅅ", "이상한나라의앨리스");
		quizList.put("ㅁㅁㅁㅇ", "맘마미아");
		quizSet = quizList.keySet();
		i = quizSet.iterator();
	}
	
	void quizGame() {
		while (i.hasNext()) {
			System.out.println("영화 제목 초성 퀴즈");
			String quiz = i.next();
			String answer = printQuiz(quiz);
			if (checkAnswer(quiz, answer)) {
				System.out.println("정답입니다!");
				System.out.println();
				score++;
			} else {
				System.out.println("땡!");
				System.out.println("정답은 " + quizList.get(quiz) + "입니다.");
				System.out.println();
			}
		}
		System.out.println("퀴즈 게임이 끝났습니다.");
		System.out.println("점수는 " + score + "점입니다.");
	}
	
	String printQuiz(String quiz) {
		System.out.println(quizNumber + "번 퀴즈");
		System.out.println(quiz);
		
		System.out.print("답: ");
		String answer = sc.nextLine();
		return answer;
	}
	
	boolean checkAnswer(String quiz, String answer) {
		quizNumber++;
		return quizList.get(quiz).equals(answer); 
	}
}

public class Ex15_HashMap_Quiz_Object2 {
	public static void main(String[] args) {
		QuizProgram q = new QuizProgram();
		q.quizGame();
	}
}