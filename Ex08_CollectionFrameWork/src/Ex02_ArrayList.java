import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

//Today KeyPoiny
public class Ex02_ArrayList {

	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		System.out.println(arraylist.toString());
		
		for(int i = 0; i < arraylist.size(); i++) {
			System.out.println(arraylist.get(i));
		}
		
		System.out.println("현재 : [0]" + arraylist.get(0));
		//add 데이터 추가 하는 함수(기본적인 추가 순차적으로)
		//비순차적으로 데이터 추가, 삭제
		arraylist.add(0, 100000);
		System.out.println("add : " + arraylist.toString());
		
		//기존에 있던 자원 자리 이동
		//데이터를 삽입 add default (맨뒤 순차적으로 넣어줌...)
		//데이터 삽입 add 중간에 추가, 삭제 .. 될 수 있다
		//ArrayList 중간에 데이터를 추가 하거나, 삭제하는 작업은 성능에 ...좋지않아여
		//순차적인 데이터 추가 삭제 좋아요	
		
		arraylist.remove(0);
		System.out.println("size : " + arraylist.size());
		System.out.println("remove : " + arraylist.toString());
		
		//ArrayList 함수 ...
		System.out.println(arraylist.contains(200));
		System.out.println(arraylist.contains(3300)); // 이거들었니?
		
		System.out.println(arraylist.isEmpty());//너 비어 있니? false
		arraylist.clear(); //데이터를(값) 다지운다
		System.out.println(arraylist.isEmpty());//너 비어 있니? true
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		
		System.out.println(arraylist.toString());
		Object value = arraylist.remove(0); //필요하다면 지워지는 값을 받을 수 있따
		System.out.println("value : " + value);
		System.out.println("remove : " + arraylist.toString());
		
		ArrayList list = new ArrayList();
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("가");
		
		System.out.println("ArrayList : 순서유지 " + list.toString());
		list.remove("가"); //순차적으로 찾아서 걸리면 삭제
		System.out.println("ArrayList : remove " + list.toString());
		
		//이 코드는 ... 매우 중요 합니다
		List li = new ArrayList(); // 코드 패턴 다형성(부모타입)
		//li = new Vector();
		//List 인터페이스를 부모 타입으로
		
		li.add("가");
		li.add("나");
		li.add("다");
		li.add("라");
//		System.out.println(li.toString());
		
		//fromIndex - low endpoint (inclusive) of the subList
		//toIndex - high endpoint (exclusive) of the subList
		
		List li4 = li.subList(0, 3); //subList 원하는 값을 가져와서 arraylist를 만들어서 주소값을 넘겨줌
		System.out.println(li4.toString());
		
		ArrayList alist = new ArrayList();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(7);
		alist.add(15);
		System.out.println("before : " + alist.toString());
//		Arrays.sort()
		Collections.sort(alist);
		System.out.println("after : " + alist.toString());
		
	}

}
