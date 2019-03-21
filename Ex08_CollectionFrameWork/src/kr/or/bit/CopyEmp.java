package kr.or.bit;

//DTO, VO, DOMAIN
//Data Transfer Object
//Value Object

//Emp e = new Emp(); //사원 1명의 정보를 담을 수 있는 객체

public class CopyEmp {
	private int empno;
	private String ename;
	private int sal;
	
	public CopyEmp(int empno, String ename, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
	
	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "CopyEmp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + "]";
	}
	
	
}
