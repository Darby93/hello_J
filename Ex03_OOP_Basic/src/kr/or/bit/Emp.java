package kr.or.bit;

/*
만든이 : 홍길동
날짜 : 2019-02-08
파일 : Emp.java(사원정보)

class = 설계도 = 타입
설계도의 기본적인 구성요소는 (상태, 고유정보 + 행위정보)
                   (속성(필드, 변수) + 기능(함수, method))
                                      
*/
public class Emp {
	public int empno; // 사번 (정보 > 변수 > member field > instance variable)
	public String ename; //이름
	public String job; //직종
	
	private int sal; //급여 (캡슐화, 은닉화 : 간접할당)
	//sal 값을 write(set), read(get)
	
	public int getSal(){ //read
		return sal;
	}
	
	public void setSal(int sal) { //write
		if(sal < 0) {
			this.sal = 0;
		}else {
			this.sal = sal;
		}
	}
	
	private int ngr; //관리자 사번

	public int getNgr() { //read (getter)
		return ngr;
	}

	public void setNgr(int ngr) { //write 자동으로 하는걸 권장 (setter)
		this.ngr = ngr;
	}
	
	//기능 (함수)
	public String getEmpInfo() {
		return empno + "/" + ename + "/" + job + "/" + sal;
	}
	
	
	
	
}
