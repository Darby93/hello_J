package kr.or.bit;

public class AirPlane {
	private int airnum;
	private String airname;
	private static int airtotalcount;
	
	public AirPlane(int airnum, String airname) {
		this.airnum = airnum;
		this.airname = airname;
		airtotalcount++; //static = this �Ⱥ��ε���
	}
	
	public void airPlaneInfo() {
		System.out.printf("\n�̸� : %s , ��ȣ : %d" , airname ,airnum);
	}
	
	public void airPlaneTotalCount() {
		System.out.print("\n�� ���� ����� �� : " + airtotalcount);
		
	}
	
	
	

	
}
