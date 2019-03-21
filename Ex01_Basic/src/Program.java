
public class Program {
	//시작점 , 진입점
	//프로그램이 실행되면 가장 먼저 실행되는 영역

	public static void main(String[] args) {
		

           //시작점, 진입점
		   //프로그램이 실행되면 가장 먼저 실행되는 영역
           
		   
           System.out.println("hello");
		   
           Person kim = new Person(100, "김유신");
           kim.personInfo();
           
           Person park = new Person(10, "박씨");
           park.personInfo();
           
	} 

}