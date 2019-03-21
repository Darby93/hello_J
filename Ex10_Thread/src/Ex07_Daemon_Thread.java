// 개념 : 보조 쓰레드 ex) 한글 작업 시 3초마다 자동 저장

public class Ex07_Daemon_Thread implements Runnable{
  static boolean autosave = false;
  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(3000);
      } catch (Exception e) {
      }
      if (autosave) {
        autoSaveFunction();
      }
    }
  }
  
  public void autoSaveFunction() {
   System.out.println("문서가 3초 간격으로 자동 저장됩니다"); 
  }
  
  public static void main(String[] args) {
    Thread th = new Thread(new Ex07_Daemon_Thread()); // Runnable 인터페이스를 구현하고 있는 객체의 주소
    th.setDaemon(true); // 보조 쓰레드로 설정
    th.start();
    
    // main 함수 (Ex07_Daemon_Thread 보조)
    // main 함수 : 글쓰기
    for (int i = 0; i <= 30; i++) {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
      }
      System.out.println("Main Thread : " + i);
      if (i == 5) { // i가 5가 되는 시점부터
        System.out.println(i);
        autosave = true;
      }
    }
  }
}
