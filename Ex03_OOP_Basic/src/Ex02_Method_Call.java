import kr.or.bit.FunctionClass;
import kr.or.bit.Tv;

public class Ex02_Method_Call {

	public static void main(String[] args) {
		
		//long hex = 0XFFFF_FFFF_FFFF_FFFFL;
		
		FunctionClass fc = new FunctionClass();
		fc.m();
		fc.m2(100);
		
		int result =  fc.m3(); //return type ������ .....
		System.out.println("result : " + result);
		
		result = fc.m4(1000);
		System.out.println("result 2 : " + result);
		
		result = fc.sum(100);
		System.out.println("result3 : " + result);
		
		result = fc.sum2(200);
		System.out.println("result4 : " + result);
		
		int result5 = fc.sum3(10, 20, 30);
		System.out.println("result5 : " + result5);
		
		System.out.println(fc.max(1, 3));
		
		//////////////////////////////////////////////////////
		Tv tv = new Tv();
		tv.brandname = "LG";
		
		fc.objMethod3(tv);
		
		
		
	}

}
