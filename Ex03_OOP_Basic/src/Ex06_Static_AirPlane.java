import kr.or.bit.AirPlane;

/*
�츮ȸ��� ����⸦ �ֹ� ���� �Ǹ��ϴ� ȸ���Դϴ�
�츮ȸ��� ����⸦ �����ϴ� ���赵�� �ۼ��Ϸ��մϴ�

������� �䱸����
1. ����⸦ �����ϸ� ����⸦ �̸��� ��ȣ�� �ο��ؾ� �մϴ�.
2. ����Ⱑ �����Ǹ� ������� �̸��� ��ȣ�� �°� �ο��Ǿ����� Ȯ�� �ϴ±���ʿ�(�������)
3. ����Ⱑ ��� �� �� ���� ������� ��������� Ȯ�� �� �� �ֽ��ϴ�

����⸦ ����� (AirPlane air = new AirPlane();)

���赵�� ���ݱ��� ��� �ڵ�� �ۼ�.... (�ּ��� 3�� �����)
kr.or.bit.AirPlane
*/
public class Ex06_Static_AirPlane {

	public static void main(String[] args) {
		//������ �ϰ� this�� ����� �ʾ��� ��
//		AirPlane air = new AirPlane();
//		air.number = 101;
//		air.name = "�غ�1";
//		air.airInfo();
//
//
//		AirPlane air2 = new AirPlane();
//		air2.number = 102;
//		air2.name = "�غ�2";
//		air2.airInfo();
//
//
//		AirPlane air3 = new AirPlane();
//		air3.number = 103;
//		air3.name = "�غ�3";
//		air3.airInfo();
		
		//������ �ϰ� this�� ����� ��
		AirPlane air = new AirPlane(707, "�����װ�");
		air.airPlaneInfo();
		air.airPlaneTotalCount();
		
		AirPlane air2 = new AirPlane(808, "�ƽþƳ�");
		air.airPlaneInfo();
		air.airPlaneTotalCount();
		

	}

}