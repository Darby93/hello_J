import kr.or.bit.AirPlane;

/*
우리회사는 비행기를 주문 제작 판매하는 회사입니다
우리회사는 비행기를 생산하는 설계도를 작성하려합니다

사장님의 요구사항
1. 비행기를 생산하면 비행기를 이름과 번호를 부여해야 합니다.
2. 비행기가 생성되면 비행기의 이름과 번호가 맞게 부여되었는지 확인 하는기능필요(정보출력)
3. 비행기가 출고 될 때 마다 비행기의 누적대수를 확인 할 수 있습니다

비행기를 만든다 (AirPlane air = new AirPlane();)

설계도는 지금까지 배운 코드로 작성.... (최소한 3대 만들기)
kr.or.bit.AirPlane
*/
public class Ex06_Static_AirPlane {

	public static void main(String[] args) {
		//생성자 하고 this를 배우지 않았을 때
//		AirPlane air = new AirPlane();
//		air.number = 101;
//		air.name = "붕붕1";
//		air.airInfo();
//
//
//		AirPlane air2 = new AirPlane();
//		air2.number = 102;
//		air2.name = "붕붕2";
//		air2.airInfo();
//
//
//		AirPlane air3 = new AirPlane();
//		air3.number = 103;
//		air3.name = "붕붕3";
//		air3.airInfo();
		
		//생성자 하고 this를 배웠을 때
		AirPlane air = new AirPlane(707, "대한항공");
		air.airPlaneInfo();
		air.airPlaneTotalCount();
		
		AirPlane air2 = new AirPlane(808, "아시아나");
		air.airPlaneInfo();
		air.airPlaneTotalCount();
		

	}

}
