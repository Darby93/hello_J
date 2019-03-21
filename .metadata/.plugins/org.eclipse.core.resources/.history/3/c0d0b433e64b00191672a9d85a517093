package dynamic_beat_4;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public DynamicBeat() { //생성자
		setTitle("Dynamic Beat"); //제목
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //창크기
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //화면을 껏을 때 프로그램종료
		setVisible(true); //창이 보이게 해준다
		
		introBackground = new ImageIcon(Main.class.getResource
				("../images/introBackground.jpg")).getImage();
		
		Music introMusic = new Music("introMusic.mp3", true);
		//음악은 종료전 계속 재생 , 시작화면 음악
		introMusic.start();
		
		
	}
	
	public void paint(Graphics g) { //약속된 메소드
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//1280/720 만큼의 이미지를 만들어주고 screenImage변수에 넣어줌
		
		screenGraphic = screenImage.getGraphics();
		//screenImage를 이용해 그래픽 개체를 얻어옴
		
		screenDraw(screenGraphic);
		//screenGraphic에 어떠한 그림을 그려줌
		
		g.drawImage(screenImage,0,0,null); //게임창에 스크린 이미지가 그려짐 중앙에!!
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); //
		this.repaint(); //전체화면 이미지를 바꿀 수 있게해줌
	}
	
}
