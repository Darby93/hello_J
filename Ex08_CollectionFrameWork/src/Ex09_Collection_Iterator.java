import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

//Collection Framework
//나열된 자원에 대해 순차적으로 접근해서 값을 리턴하는 표준 정의
//Iterator 인터페이스 설계

//예를 들어서 A 클래스 Iterator 구현
//        B 클래스 Iterator 구현
//내가 보장받는 것은 : hasnext()가 구현되어 있따. next();구현되어 있다

//ArrayList >> Iterator 구현하고 있다
//for문을 쓰면 안되나요 ? 써도 되는데 
// 우리가 원하는 것은 표준화된 접근이라 쓴다한닼

//Iterator : 순방향 데이터 read 표준
//ListIterator : 양방향 데이터 read 표준

public class Ex09_Collection_Iterator {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(10);
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(300);
		list.add(300);
		list.add(300);
		list.add(300);
		list.add(300);
		list.add(300);
		list.add(300);
		list.add(300);
		
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//표준화된 인터페이스를 사용해서 출력하고싶다면?
		//밑에꺼가 표준화된 방법
		//Iterator
		//Collection{Interator iterator()} //추상자원
		//List extends Collection
		//ArrayList implements List
		//ArrayList >> iterator() 함수의 {실행블럭을 구현}
		//Iterator (부모타입) 접근 ....
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//generic
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		intlist.add(44);
		intlist.add(55);
		intlist.add(66);
		
		Iterator<Integer> list2 = intlist.iterator();
		
		while(list2.hasNext()) {
			System.out.println(list2.next());
		}
		
//		while(intlist.iterator().hasNext()) {
//			System.out.println("****************************");
//			System.out.println(intlist.iterator().next());
//		}
		
		//역방향
//		for(int i = intlist.size()-1; i >=0; i--) {
//			System.out.println(intlist.toString());
//		}
//		
//		//ListIterator(순방향도 역방향도 가능함)
//		//역방향 조회시 순방향이 선행 되어야 한다
//		ListIterator<Integer> li2 = intlist.listIterator();
//		
//		//순방향
//		while(li2.hasNext()) {
//			System.out.println(li2.next());
//		}
//		
//		//역방향
//		while(li2.hasPrevious()) {
//			System.out.println(li2.previous());
//		}
		
		System.out.println("abc");

		System.out.printf("A");
	}

}
