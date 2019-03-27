package DTO;

//DTO(VO) DOMAIN 클래스
//DB 테이블과 1:1 매핑 구조
//DEPT 테이블의 데이터를 담을 수 있는 클래스 생성

public class Dept {
	//dept 테이블 컬럼들
	private int deptno;
	private String dname;
	private String loc;
	
	
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	//내용 확인용
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
}
