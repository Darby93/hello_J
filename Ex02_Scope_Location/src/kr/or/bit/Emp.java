package kr.or.bit;

public class Emp {
	private int empno;
	private String name;
	private int sal;
	private String job;
	public int mgr;
	
	
	
	
	public int getEmpno() { //getter 캡슐화된(감추어진) 자원에 대해서 read 하게해주는 함수!
		return empno;
	}
	public void setEmpno(int empno) { //setter 캡슐화된(감추어진) 자원에 대해서 write 하게해주는 함수!
		if (empno <=0) {
			this.empno = 9999;
		}else {
		this.empno = empno;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
	
	
	
	
}
