package dynamic_beat_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	private Player player; // 라이브러리에 있는 클래스
	private boolean isLoop; // 반복재생하는지
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			// 파일위치를 가져옴

			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getTime() { //현재실행되고 있는 음악이  어떤 위치에서 실행되는지 알려주는 함수
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {
		isLoop = false;
		player.close(); //다른음악 듣고싶을때 끄게해줌
		this.interrupt(); //곡재생해주는 프로그램을 종료해줌
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play(); //곡실행
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop); //true면 해당곡이 무한반복 
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
