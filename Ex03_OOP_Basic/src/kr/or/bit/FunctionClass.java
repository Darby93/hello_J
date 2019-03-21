package kr.or.bit;


/*	
함수 : 기능의 최소 단위(method)		

함수의 종류

*void (돌려주는 값이 없다) : return value 가 없다
*return Type : [8가지 기본 타입] + String + 사용자 정의(class) + Array + Collection + Interface
** 함수가 return Type( ex. public int calc(){ return 100; } 있다면
    반드시 { 실행블럭 } 안에 return 구문을 가지고 있어야 한다 !!!!☆★☆★
    
*parameter :  [8가지 기본 타입] + String + 사용자 정의(class) + Array + Collection + Interface
    
    
1. void, prameter(0) 파라미터존재 : public void print (String str){ System.out.println(str) }
2. void, prameter() 파라미터존재x : public void print(){ System.out.println("hello") }
3. return Type, parameter(0) 파라미터존재 : public int call(int i) { return i + 100; }
4. return Type, parameter() 파라미터존재x : public int call( ) { return 1000; }
                 (매개변수)
함수(method) 반드시 호출 (Call) 되어야 실행 한다 : ...........

*/	
public class FunctionClass {	
	
	public void m() { //함수의 이름은 의미있는 단어의 조합 : getChannelNumber()
		System.out.println("일반함수 : void , prameter(x)");
	}
	
	public void m2(int i) {
		System.out.println("prameter value : " + i);
		System.out.println("일반함수 : void , prameter(o)");
	}
	
	public int m3() { //m3 함수를 호출하면 100라는 값을 돌려줨
		return 100;
	}
	
	public int m4(int data) {
		return data + 100;
	}
	
	//접근자(한정자) : private 함수
	//어떤 의미의 코드 : class 내부에서 사용 (다른 함수를 도와주는 역활)
	//다른 여러개의 함수가 가지는 [공통적인 내용]을 한 곳의 함수에 모아서 기능을 제공
	//유지보수 (수정) 용이
	private int operationMethod(int data) {
		return data * 100;
	}
	
	public int sum(int data) {
		return operationMethod(data); // 현자 상황으로는 적당한 코드! 별도의 조건이 붙어 있지 x
	}
	
	public int sum2(int data) {
		int result = operationMethod(data);
		return result;
	}
	
	//확장함수 (parameter 개수 여러개)
	public int sum3(int i, int j , int k) {
		return i + j + k; //안쪽의 로직은 맘대롱!
	}
	
	// 개별 Quiz 뿌뿌!
	//a 와 b 둘중에 큰 값을 return 하는 함수를 만드세요
	// public int max(int a , int b){ }
	//호출 : max(100, 3) --> 100
	/*	
	30점
	if(a > b){
	   return a;
	}else{
	   return b;
	}
    
    60점
    int result = 0;
    if(a > b){
      result = a;
    }else{
      result = b;
    return result;
	*/	
	public int max (int a, int b) { //삼항 연산자 활용
		return (a > b) ? a : b; // a가크니 b가크니 a가크면  a b가크면 b
	                            // 조건 ? 맞으면 앞 틀리면 뒤
		//return은 되도록 하나만
		//int max = (a > b) ? a : b
		//return max;
	}
	
	public String concat(String s, String s2, String s3) {
		return s + "/" + s2 + "/" + s3;
	}
	
	//여기까지는 쉬운편
	// 클래스 == 타입이다 (Tv t; t = new Tv();
	//public int call() {return 100;}
	//public Tv call() {Tv t = new Tv(); return t;} //주소값
	//public Tv call() {return new Tv();} //주소값
	
	//public void call(Tv t){ System.out.println(t.name); }
	//Tv tt = new Tv();
	//tt.name = "삼성";
	//call(tt);
	
	public Tv objMethod() { //Tv 타입을 갖는 주소값을 return
		Tv tt = new Tv(); //heap 객체 만들고 주소값 tt 에 할당
		tt.brandname = "중저가";
		return tt;
	}
	
	public Tv objMethod2() {
		return new Tv(); //heap 객체 만들고 주소값 return
	}
	
	public void objMethod3(Tv t) {
		System.out.println("Tv 타입 정보 : " + t);
		System.out.println("채널 정보 : " + t.ch);
		System.out.println("브랜드이름 : " + t.brandname);
	}
	

	
	
	
}
