// Thread : 프로세스에서 하나의 최소 실행 단위(method)

// Thread 생성 방법 == 여러 개의 stack 생성 방법
// 1. Thread 클래스를 상속 -> class Test extends Thread
// Thread라는 클래스를 상속하면 반드시 run()을 재정의해야 한다 >> 다른 stack의 main() 역할

// 2. implements Runnable -> class Test implements Runnable
// 반드시 run() 추상 함수 재정의

// 왜 2가지나 제공할까?
// class Test extends Car implements Runnable {}
// 이미 상속하고 있는 클래스를 Thread로 만들기 위한 방법

// Thread 추상 클래스가 아닌 일반 클래스
// Thread 독자적으로 객체 생성 가능

class Thread_1 extends Thread { // 별도의 stack 운영 가능
	@Override
	public void run() { // main 함수 역할 >> 별도의 call stack을 만들면 run()이 가장 먼저
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread_1 : " + i + this.getName());
		}
		System.out.println("Thread_1 run() END");
	}
}

class Thread_2 implements Runnable { // 이 상태는 일반 클래스
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread_2 : " + i);
		}
		System.out.println("Thread_2 run() END");
	}
}

public class Ex02_Multi_Thread {

	public static void main(String[] args) {
		System.out.println("Main Start");
		
		// 1. Thread_1 객체 생성
		Thread_1 th = new Thread_1();
		th.start(); // POINT >> stack 메모리를 만들고 stack에 run()을 로드하는 것까지 하고 소멸
		
		// 2번
		Thread_2 th2 = new Thread_2();
		Thread thread = new Thread(th2);
		thread.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("main : " + i);
		}
		
		System.out.println("main END");
	}

}
