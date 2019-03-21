
class Data{
	int i;
}




public class Ex10_Method_Call {
	public static void main(String[] args) {
		Data d  = new Data();
		d.i = 100;
		System.out.println("d.i : " + d.i);
		
		scall(d);
		System.out.println("d.i : " + d.i);
		vcall(d.i); //값을 넘겨줌
		System.out.println("d.i : " + d.i);
	}
	
	static void scall(Data momomomomomo) { //주소값 참조
		System.out.println("함수 : " + momomomomomo.i);
		momomomomomo.i = 1111;
	}
	
	static void vcall(int x) { //값 전달
		System.out.println("before : " + x);
		x = 8888;
		System.out.println("after : " + x);
	}
	
}
