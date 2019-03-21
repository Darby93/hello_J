import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

// 구구단이 랜덤으로
// 시간이 늘어남
// 문제를 많이 맞히면 적게 늘어남
// 타이머가 끝나면 종료
// 문제를 맞힐 때마다 점수 증가

class GuGuDan implements Runnable {
  static boolean isRight = false;
  static Map<String, Integer> answers = new HashMap<>();

  @Override
  public void run() {
    while (true) {
      Random r = new Random();
      int a = r.nextInt(9) + 1;
      int b = r.nextInt(9) + 1;
      int answer = a * b;
      answers.put((a + " X " + b), answer);
      String inputData = JOptionPane.showInputDialog(a + " X " + b + "?");
      try {
        if (answer == Integer.parseInt(inputData)) {
          isRight = true;
          Quiz_Team2.OX.add("O");
        } else {
          Quiz_Team2.OX.add("X");
        }
      } catch (NumberFormatException e) {
        inputData = "0";
      }
      if (Quiz_Team2.gameOver) {
        break;
      }
    }
  }
}


public class Quiz_Team2 {
  static List<String> OX = new ArrayList<>();
  static boolean gameOver = false;

  public static void main(String[] args) {
    Thread gugu = new Thread(new GuGuDan());

    gugu.start();

    for (int i = 10; i >= 0; i--) {
      try {
        System.out.println("남은 시간 : " + i);
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (GuGuDan.isRight) {
        if (OX.size() < 5) {
          i += 2;
          System.out.println("2초 추가");
        } else if (OX.size() < 10) {
          i += 1;
          System.out.println("1초 추가");
        }
        GuGuDan.isRight = false;
      }
    }
    
    try {
      gugu.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    gameOver = true;
    System.out.println("게임 종료");
    System.out.println("풀었던 문제와 답");
    for (String s : GuGuDan.answers.keySet()) {
      System.out.println(s + " : " + GuGuDan.answers.get(s));
    }
    System.out.println("정오 : " + OX);
    int result = 0;
    for (String s : OX) {
      if (s.equals("O")) {
        result++;
      }
    }
    
    System.out.println("결과 : " + result + "점");
    System.out.println("최고 기록 21점");
  }
}

// class Score extends Thread {
// int count = 1;
// @Override
// public void run() {
// while (true) {
// try {
// Thread.sleep(1000);
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// System.out.println("현재 점수 : " + Quiz_Team2.OX.size() + "점");
// }
// }
// }
// Score score = new Score();
//
// score.setDaemon(true);
// score.start();

