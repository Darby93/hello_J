// 동기화
// 한강 화장실 (공유 자원) : 다수의 사용자가 화장실을 사용
// Lock 잠금장치

// 잠금장치의 대상 : 객체...
// POINT : 잠금의 대상은 주로 함수

// 김씨가 화장실에서 일을 보다가 손을 씻고 싶어서 문 열고 나가서 손을 씻고 다시 들어왔다
// synchronized는 다른 사람이 못들어오게 하는 것
// 끝까지 다 하고 나가는 것이 아니다
class Wroom {
  public synchronized void openDoor(String name) {
    System.out.println(name + "님 화장실 입장");
    for (int i = 0; i < 100; i++) {
      System.out.println(name + " 사용 : " + i);
      if (i == 10) {
        System.out.println(name + "님 끙!!");
      }
    }
    System.out.println("시원하다 ^^.........");
  }
}


class User extends Thread {
  private Wroom wr;
  private String who;

  public User(String name, Wroom w) {
    wr = w;
    who = name;
  }

  @Override
  public void run() {
    wr.openDoor(who);
  }
}


public class Ex09_Sync_Thread {
  public static void main(String[] args) {
    // 한강 둔치
    Wroom w = new Wroom(); // 화장실 1개

    // 사람
    User kim = new User("김씨", w);
    User lee = new User("이씨", w);
    User park = new User("박씨", w);

    // 모든 사람들이 배탈
    kim.start();
    lee.start();
    park.start();
  }
}
