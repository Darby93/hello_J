import java.util.Stack;

import kr.or.bit.Coin;

public class Ex05_Stack_Collection {

	public static void main(String[] args) {
		//LIFO
		//Stack : Collection Framework 제공하는 클래스
		
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		//꺼내올게 없으면 나는 오류
		//java.util.EmptyStackException
		//System.out.println(stack.pop());
		
		System.out.println(stack.isEmpty());
		
		//동전 케이스
		//stack 자료구조 원하는 형태 .......
		Stack<Coin> coinbox = new Stack<Coin>();
		coinbox.push(new Coin(100));
		coinbox.push(new Coin(50));
		coinbox.push(new Coin(500));
		
		//System.out.println(coinbox.pop().getValue());
		
		while(!coinbox.isEmpty()) {
			Coin coin = coinbox.pop();
			System.out.println("커낸 동전 : " + coin.getValue()+ "원") ;
			
		}
		
	}

}
