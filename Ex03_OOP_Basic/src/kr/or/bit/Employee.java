package kr.or.bit;
/*
����� ��� , �̸� , ����(job)�� ������ �ֵ� => ��Ģ(ĸ��ȭ) => read, write ����  setter/ getter
��� ������ default �� ��� =9999, �̸�=�ƹ���, ����=����
������ �Լ��� ���(��, ��� ������) ���, �̸�, ���� �� �Է��Ͽ� ��� ���� �����ϸ�
��������� ���, �̸�, ������ �ѹ��� Ȯ�� �� �� �ְ� 
(������ ������ Ȯ�� �Ұ� �ϴ�) ���������� ����� �̸������� ���� ��ȸ �����ϴ�. ��µǴ� ������ �ݵ�� ���̶�� ���ڰ� ���;��Ѵ�

*/



public class Employee {
	private int empno;
	private String ename;
	private String job;

	
	public Employee(){
		empno = 9999;
		ename = "�ƹ���";
		job = "����";
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
		return ename + "��";  // ���� ....(����ó��)
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
	
	//�Ϲ��Լ�
	public void EmployeeInfoPrint() {
		System.out.printf("��� : [%d]  �̸� : [%s]  ���� : [%s]\n",empno,ename,job);
	}
	
	
	
	
}
