import java.util.ArrayList;

/*
 * 기본 타입 (8가지) : 값 타입 : Java API 8가지 기본 타입에 대해서 객체 형태로 사용 가능하도록 만든 클래스 ex) void run(Integer i)
 * 
 * 기본형 타입도 때로는 객체 형태로 다루어져할 때가 있다 
 * 1. 매개 변수로 객체 타입이 요구될 때 
 * 2. 기본형 값이 아닌 객체 타입으로 저장되어야 할 때 
 * 3. 객체 간의 비교가 필요할 때 
 * 4. wrapper class의 타입 정보 (최소 크기, 최대 크기) 
 * 
 * 이때 8가지 기본 타입에 대한 wrapper class 사용
 */
class AAA extends Object{
	@Override
	public String toString() {
		return "안뇽";
	}
}


public class Ex10_Wrapper_Class {
  public static void main(String[] args) {
    int i = 100;
    Integer n = new Integer(500); // Integer (int 타입의 wrapper class)
    System.out.println("i : " + i);
    System.out.println("주소 (재정의) n : " + n.toString());
    
    // ArrayList<int> li = new ArrayList<int>();
    ArrayList<Integer> li = new ArrayList<Integer>(); // POINT
    li.add(100);
    li.add(200);
    for (int r : li) {
      System.out.println(r);
    }
    Integer i3 = new Integer(100);
    Integer i4 = new Integer(100);
    System.out.println(i3 == i4); // 주소값 비교 >> false
    
    System.out.println(i3.equals(i4));
    // equals를 Integer 클래스가 재정의(주소값이 아닌 값 비교)
    
    Integer t = new Integer(500); // 참조변수
    integerMethod(t);
    intMethod(t);
    
    AAA aaa= new AAA();
    System.out.println(aaa.toString()); 
    
  }
  
  static void integerMethod(Integer i) {
    System.out.println("Integer param : " + i);
  }
  
  static void intMethod(int i) {
    System.out.println("int param : " + i);
  }
}