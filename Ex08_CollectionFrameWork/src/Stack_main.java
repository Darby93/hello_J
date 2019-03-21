import kr.or.bit.MyStack;

public class Stack_main {

	public static void main(String[] args) {
		MyStack mystack = new MyStack(3);
		
		System.out.println(mystack.full());
		
		System.out.println(mystack.empty());
		
		mystack.push(300);
		mystack.push(100);
		mystack.push(200);
		mystack.push(400);
		
		System.out.println(mystack.getTop());
		
		mystack.pop();
		System.out.println(mystack.pop());
		
		System.out.println(mystack.full());


		

		
	}

}
