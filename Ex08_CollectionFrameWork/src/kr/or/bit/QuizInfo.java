package kr.or.bit;

import java.util.HashMap;

class QuizInfo {
	String question;
	String answer;
	String result;

	public QuizInfo() {
		this.question = "내 이름은?";
		this.result = "장지훈";
		
		HashMap<String, String> hs = new HashMap();
		hs.put(question, answer);
	}


	public String toString() {
		return "문제:" + this.question + " 쓴답:" + this.answer + " 채점:" + this.result;
	}
}
