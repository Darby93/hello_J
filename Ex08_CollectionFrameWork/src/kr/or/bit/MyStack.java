package kr.or.bit;

//stack 이라는 자료구조를 직접 설계
// 배열만들고
// 자료의 형태 object


public class MyStack {	
	
	private int top; //값이 변해요(이동 : 커서)
	private Object[] stackarr;  //데이터를 담을 공간
	
	
	
	public int getTop() {
		return top;
	}

	public MyStack(int maxsize) {
		stackarr = new Object[maxsize];
	}
	
	public boolean empty() {
		boolean m = false;
		if (stackarr[0] == null) {
			m = true;
		}
		return m;
	}
	
	public boolean full() {
		boolean m = false;

		if (stackarr[stackarr.length-1] != null) {
			m = true;
		}
		
		return m;
	}
	
	public void push(Object obj) {
		
		
		
		if (full()) {
			System.out.println("꽉참");
			return;
		} else {
			stackarr[top] = obj;
			top++;
		}

	}
	
	public Object pop() {
		
		Object a = 0;

		if (empty()) {
			System.out.println("텅비었음");
		} else {
			a = stackarr[top];
			top--;
		}
		
		return a;
	}
	
	//기능 (함수)
	//스택 비어 있니?
	
	//스택 full 되어 있니?
	
	//스택 push
	
	//스택 pop
}
