package kr.or.bit;
/*
사원은 사번 , 이름 , 직종(job)을 가지고 있따 => 원칙(캡슐화) => read, write 지원  setter/ getter
사원 생성시 default 로 사번 =9999, 이름=아무개, 직종=인턴
별도의 함수를 사용(단, 사원 생성시) 사번, 이름, 직종 을 입력하여 사원 생성 가능하며
사원정보는 사번, 이름, 직종을 한번에 확인 할 수 있고 
(각각의 정보는 확인 불가 하다) 예외적으로 사원의 이름정보를 각각 조회 가능하다. 출력되는 형식은 반드시 님이라는 글자가 나와야한다

*/



public class Employee {
	private int empno;
	private String ename;
	private String job;

	
	public Employee(){
		empno = 9999;
		ename = "아무개";
		job = "인턴";
	}
	
	public Employee(int no, String name, String jobdate) { //overloading constructor
		empno = no;
		ename = name;
		job = jobdate;
	}
	
	
//	public int getEmpno() { //read : getter
//		return empno;
//	}
	
	public void setEmpno(int empno) { //write : setter
		this.empno = empno;
	}
	
	public String getName() {
		return ename + "님";  // 강제 ....(간접처리)
	}
	
	public void setName(String name) {
		this.ename = name;
	}
	
//	public String getJob() {
//		return job;   
//	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	//일반함수
	public void EmployeeInfoPrint() {
		System.out.printf("사번 : [%d]  이름 : [%s]  직종 : [%s]\n",empno,ename,job);
	}
	
	
	
	
}
