import java.util.ArrayList;
import java.util.Iterator;

import kr.or.bit.CopyEmp;
import kr.or.bit.Emp;

public class Ex08_Generic_Quiz2 {

	public static void main(String[] args) {
		//1. Emp 클래스를 사용해서 사원 3명을 생성하세요
		//단, ArrayList 제너릭을 사용하세용
		
		ArrayList<Emp> emparr = new ArrayList();
		emparr.add(new Emp(1,"장","IT"));
		emparr.add(new Emp(2,"장지","IT"));
		emparr.add(new Emp(3,"장지훈","IT"));
		//2. 3명의 사원 정보 (사번, 이름, 직종 )을 개선된 포문을 사용해서 출력하세용
		
		for(Emp emp : emparr) {
			System.out.println(emp);
		}
		
		
		//3. 3명의 사원 정보 (사번, 이름, 직종 )을 일반 포문을 사용해서 출력하세용	
		
		for(int i = 0; i < emparr.size(); i++) {
			System.out.println(emparr.get(i));
		}
		
		
		//4. CopyEmp라는 클래스를 만들어용 (구조는 Emp랑 똑같고)
		//job member field 대신에 
		//private int sal 추가하고(getter, setter 구현)
		//ArrayList 제너릭 사용해서 사원3명 만들기
		//아래 데이터 그대로사용
		//100, "김", 1000
		//200, "이", 2000
		//300, "박", 3000
		
		ArrayList<CopyEmp> cemp = new ArrayList();
		cemp.add(new CopyEmp(100, "김", 1000));
		cemp.add(new CopyEmp(200, "이", 2000));
		cemp.add(new CopyEmp(300, "박", 3000));

		
	    //5. 200번 사원의 급여를 5000으로 수정해서 출력하세요 (일반 for문 사용하세요)
		
		for(int i = 0 ; i < cemp.size(); i++) {
			
			if(cemp.get(i).getEmpno()==200) {
				cemp.get(i).setSal(5000);
			}
			
			System.out.println("사번 : " + cemp.get(i).getEmpno()+ " 이름 : " + cemp.get(i).getEname()
					+ "   봉급 : " + cemp.get(i).getSal());
		}
		

		//6. 300번 사원의 이름을 "궁금해" 로 수정해서 출력하세요(개선된 for문 안에서....)
		
		for(CopyEmp c : cemp) {
			if(c.getEmpno()==300) {
				c.setEname("궁금해");
			}
			System.out.println("사번 : " + c.getEmpno()+ " 이름 : " + c.getEname()
					+ "   봉급 : " + c.getSal());
		}

		//7. 사원정보를 Iterator 인터페이스를 사용해서 출력하세요
		
		Iterator<CopyEmp> it = cemp.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
