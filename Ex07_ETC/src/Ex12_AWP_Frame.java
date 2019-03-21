import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//AWT (CS 프로그램을 만들 수 있는 class 제공)
//Java 라는 언어로 메모장, 계산기 등 ......(현재 JAVA WEP 중심)

//AWT >> SWING (순수 자바 코드로 버전업)

class MyFrame extends Frame{
	MyFrame(String title){
		super(title);
	}
}
//이벤트 구현 (이벤트는 이미 만들어져있다 
class BtnClick_Handler implements ActionListener{
	
	//click 대한 핸들러(함수)
	//버튼을 click 하면 actionPerformed
	@Override
	public void actionPerformed(ActionEvent e) { //버튼을 클릭하면 발생하는 이벤트
		System.out.println("개발자가 원하는 행위 구현");
	}
}

public class Ex12_AWP_Frame {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("LOGIN");
		frame.setSize(1280, 720);
		frame.setVisible(true);
		frame.setLayout(new GridLayout());
		
		Button btn = new Button("1번 버튼");
		Button btn2 = new Button("2번 버튼");
		Button btn3 = new Button("3번 버튼");
		
		frame.add(btn);
		frame.add(btn2);
		frame.add(btn3);
		
		/*
		 * 익명타입 (인터페이스를 직접 구혀하지 않고 바로 객체를 만들어 쓰는 방법
		 * - 코드량이 줄고
		 * - 일회성
		 * 
		 * btn.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) {
		 *  System.out.println("개발자가 원하는 행위 구현");
		 * 
		 * } });
		 */
		
		//ActionListener 구현하는 클래스의 객체 생성 >> 재사용 가능(btn, btn2도 사용)
		BtnClick_Handler handler = new BtnClick_Handler();
		btn.addActionListener(handler); //위에 주석이랑 똑같은 코드
		btn2.addActionListener(handler);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("인터페이스 직접 코딩... (익명타입) 실제 클래스가 없어");
				
			}
		});
	}

}
