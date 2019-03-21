package kr.or.bit;
//stack 이라는 자료구조를 직접 설계

//MyStack my = new MyStack(5);
public class MyStack_T {
	
	private int top; //값이 변해요(이동: 커서)
	private Object[] stackarr; //데이터를 담을 공간
	//추가적으로 필요한 변수는 추가 가능
	private int maxsize; // 최대크기 고정하기
	
	public MyStack_T(int maxsize) {
		stackarr = new Object[maxsize];
		this.maxsize = maxsize;
		top = -1;
	}
	
	//기능 (함수)
	//스택 empty 되어 있니
	public boolean empty() {
		return (top == -1);
	}
	
	//스택 full 되어 있니
	public boolean full() {
		return (top == maxsize -1); //배열의 마지막 방번호와 top 같으면
	}
		
	//스택 push 
	public void push(Object i) {
		//데이터 넣기
		if(full()) {
			System.out.println("스택이 가득차 있어요");
		}else {
			stackarr[++top] = i; //처음 top = -1 >> 로직 [0] 방에 값 넣기
		}
	}
	//스택 pop
	public Object pop() {
		Object output = null;
		if(empty()) {
			System.out.println("스택이 비어 있어요");
		}else {
			output = stackarr[top];
			top--; //point 
		}
		return output;
	}
	
}
