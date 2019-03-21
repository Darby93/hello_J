package kr.or.bit;

public class AirPlane {
	private int airnum;
	private String airname;
	private static int airtotalcount;
	
	public AirPlane(int airnum, String airname) {
		this.airnum = airnum;
		this.airname = airname;
		airtotalcount++; //static = this 안붙인데용
	}
	
	public void airPlaneInfo() {
		System.out.printf("\n이름 : %s , 번호 : %d" , airname ,airnum);
	}
	
	public void airPlaneTotalCount() {
		System.out.print("\n총 제작 비행기 수 : " + airtotalcount);
		
	}
	
	
	

	
}
