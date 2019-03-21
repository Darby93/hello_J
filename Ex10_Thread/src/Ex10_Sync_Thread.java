// 은행계좌 하나 (012-16541-0233) >> 1000 입금
// 입출금 처리

// 친구 5명 (똑같은 카드 복제)
// 동시에 계좌 출금

// ATM 동시에 출금

// 누군가 (출금 행위) : 행위를 LOCK (다른 사람은 대기)

class Account { // 계좌
  int balance = 1000; // 잔액

  synchronized void withdraw(int money) { // 출금 >> 잠금장치가 필요한 대상
    // 권한 확인, 인증 확인..... (호출)
    System.out.println("고객 : " + Thread.currentThread().getName());
    System.out.println("현재 잔액 정보 : " + this.balance);
    if (this.balance >= money) {
      try {
        Thread.sleep(1000); // 은행 업무 처리되는 시간(인증, 권한 등등) : 다른 함수 호출
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      this.balance -= money;
    }
    System.out.println("인출 금액 : " + money);
    System.out.println("인출 후 잔액 : " + balance);
  }
}


class Bank implements Runnable {
  Account account = new Account();

  @Override
  public void run() {
    while (account.balance > 0) {
      int money = ((int) (Math.random() * 3) + 1) * 100;
      // 100, 200, 300
      // 실출금처리
      account.withdraw(money);
    }
  }
}


public class Ex10_Sync_Thread {
  public static void main(String[] args) {
    Bank bank = new Bank();

    Thread thread = new Thread(bank, "Park");
    Thread thread2 = new Thread(bank, "Kim");
    Thread thread3 = new Thread(bank, "Lee");

    thread.start();
    thread2.start();
    thread3.start();
  }
}
