import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//TreeSet 추가적으로 .. 알고 있으면 좋을 것 같아요




public class Ex11_Set_TreeSet {

	public static void main(String[] args) {
		//순서 (x), 중복 (x)
		HashSet<String> hs = new HashSet();
		hs.add("B");
		hs.add("A");
		hs.add("F");
		hs.add("K");
		hs.add("G");
		hs.add("D");
		hs.add("P");
		hs.add("A");
		System.out.println(hs.toString());
		
		//HashSet 확장 > LinkedHashSet (순서유지) : > Linked(주소값) > node개념
		Set<String> hs2 = new LinkedHashSet();
		hs2.add("B");
		hs2.add("A");
		hs2.add("F");
		hs2.add("K");
		hs2.add("G");
		hs2.add("D");
		hs2.add("P");
		hs2.add("A");
		System.out.println(hs2.toString()); //넣은 순서임  정렬아님 
		
		//순서(x), 중복(x), 정렬(sort) : 오름차순 기본적 제공
		//TreeSet : 검색에 용이
		//이진트리 : 정렬되고 많은 양의 데이터 저장 효율적
		//Lotto : 1~45 난수 >> 6개 >> 중복(x) >> 정렬(o)
		Set<String> hs3 = new TreeSet();
		hs3.add("B");
		hs3.add("A");
		hs3.add("F");
		hs3.add("K");
		hs3.add("G");
		hs3.add("D");
		hs3.add("P");
		hs3.add("A");
		System.out.println(hs3.toString()); //데이터 정렬
		
		List<String> list = new ArrayList(hs);
		Collections.sort(list);
		System.out.println(list);
		
		Set<Integer> lotto = new TreeSet<Integer>();
		for(int i = 0; lotto.size() < 6; i++) {
			lotto.add((int)(Math.random()*45)+1);
		}
		System.out.println(lotto);
		
		Iterator<Integer> it = lotto.iterator();
		int sum = 0;
		
		while(it.hasNext()) {
			//System.out.println(it.next());
			sum+=it.next();
		}
		System.out.println(sum);
		
		
		
	}

}
