package pratice;

public class Count_singleton {
	
	//숫자 누적 시킬 변수
	private int number;
	
	//Count_singleton 타입 참조변수   주소값 할당
	public static Count_singleton count = null;
		
	//객체 생성시 number 초기화
	private Count_singleton(int number) {
		this.number = number;
	};
	
	// 객체 생성함수 1개만됨
	// 외부에서 객체생성 nono 하도록 막음
	public static Count_singleton getInstance() {
		if(count == null) {
			count = new Count_singleton(0);
			// 주소값 없으면 객체 하나 생성
			// 있으면 주소값 그대로 리턴
		} 
		
		//똑같은 주소값 리턴
		return count;
	}
	
	//숫자 더하기
	public void counting() {
		this.number ++;
	}
	
	//숫자 확인 
	public int getNumber() {
		return this.number;
	}


	
	
	
	
}
