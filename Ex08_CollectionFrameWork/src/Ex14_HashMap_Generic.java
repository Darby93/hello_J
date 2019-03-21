import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Today Point
//HashMap<k,v>
//HashMap<String, String>
//HashMap<Integer, String>
//HashMap<String, Emp>  Point >> value 값으로 객체가 올 수 있다. 

//IO, Network, thread >> ArrayList<Emp>, HashMap<String, Emp> 코드 활용

class Student{
	int kor = 100;
	int math = 80;
	int eng = 20;
	String name;
	
	Student(String name){
		this.name = name;
	}
}

public class Ex14_HashMap_Generic {

	public static void main(String[] args) {
		HashMap<String, Student> student = new HashMap<String, Student>();
		student.put("hong", new Student("홍길동"));
		student.put("kim", new Student("김유신"));
		
		Student hongstd = student.get("hong");
		System.out.println(hongstd.eng);
		System.out.println(hongstd.kor);
		System.out.println(hongstd.math);
		System.out.println(hongstd.name);
		
		
		//Map은 기본적으로 key 가지고 value 값 얻기
		//예외적으로 (key, value) 모두 출력하고 싶을 때
		
		Set set = student.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//예외적인 CASE : vlaue 객체(Object) 일 때
		//Map.Entry 타입을 통해서
		//getKey(), getValue() 각각의 정보를 출력 가능
		for(Map.Entry m : student.entrySet()) {
			System.out.println(m.getKey() + " = " + ((Student)m.getValue()).name
					+ "/" + ((Student)m.getValue()).kor);
		}
		
	}

}
