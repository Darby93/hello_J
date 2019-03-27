package DTO;

public class Department {
	//dept 테이블 컬럼들
		private int deptno;
		private String dname;

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
		@Override
		public String toString() {
			return "Department [deptno=" + deptno + ", dname=" + dname + "]";
		}

		//내용 확인용
		
}
