import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object_KeyPoint2 {

	public static void main(String[] args) {
		
		//1. 사원 1명의 정보를 담으세요
		Emp emp = new Emp(1,"장","IT");
		
		//2. 사원 2명의 정보를 담으세요
		Emp[] emparr = {new Emp(1,"장","IT"), new Emp (1,"장","IT"), new Emp(1,"장","IT")} ;
		
		//실수 했어요 한명이 입사를 더 했음....
		//위 정적배열에 추가하는건 불가(x) -> 새로 new하지 않으면 불가
		
		//3. 동적(ArrayList)
		ArrayList arr = new ArrayList();
		arr.add(new Emp(1,"장","IT"));
		//일반 for문을 사용해서 사원 정보를 출력하세요 (down casting)
		
		
		//개선된 for
		
		
		//사실은 ...위 코드가 불편해요
		//generic (현대적인 .. 99%가 사용)
		
	
	}
}
