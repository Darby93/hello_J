import javax.swing.JOptionPane;

// 단어 맞히기(구구단) 등등
// 요구사항
// 게임을 하는데 시간을 보여주고 싶다
// 문제 실행, 시간 동시에
public class Ex03_Single_Word_Game {
	public static void main(String[] args) {
		String inputData = JOptionPane.showInputDialog("값을 입력하세요");
		System.out.println("입력값 : " + inputData);
		timer();
	}
	
	static void timer() {
		for (int i = 10; i > 0; i--) {
			System.out.println("남은 시간 : " + i);
			try {
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
