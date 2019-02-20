import java.util.Scanner;

import Kr.or.bit.Car;

public class WooseTest {

	public static void main(String[] args) {

//		//1. 주석문제 
//		//한줄주석을 사용하여 다음 내용을 전체 주석처리하시오.
//		//Car car = new Car();
//		//car.name = "현대";
//		/*
//		 범위주석을 사용하여 다음 내용을 전체 주석처리하시오.
//	     Car car = new Car();
//	     car.name = "현대";
//		 */
//		
//		//2. 출력문제
//		//출력결과: 
//		//나는 "'자바'는 재밌다!"고 (줄바꿈) 
//		//말했다.
//		//목적) 특수기호까지 출력되게 하세요.
//		String str = "자바가";
//		char ch = '!';
//		System.out.println("나는 " + str + " 재밌다"+'!'+"\n");  //나는 자바가 재밌다!
//		System.out.println("나는\"\'자바가\'\"재밌다!\n 말했다");
//		System.out.printf("나는 %s 재밌다 %s",str,ch);  //나는 자바가 재밌다!
//		
//		//3. 타입문제
//		//- Byte타입에 10과, 20을 변수 a,b를 생성하고, 둘의 합을 출력해보세요.
//		//- char타입에 'A'와 1 변수 a,b를 생성하고, 둘에 합을 char로 출력하세요(묵시적, 강제적 형변환 둘다 사용할 것)
//		byte a = 10;
//		byte b = 20;
//		int c = a+b;
//		System.out.println(a+b);  //30
//		
//		char a2 = 'A';
//		int b2 = 1;
//		int c2 = a2+b2;
//		System.out.println(a2+b2);  //66
//    	System.out.println((char)c2);  //B
//    	
//    	//4. 클래스생성문제
//    	//- Car클래스를 만들어 (원하는 타입으로) 색상과, 자동차번호 필드를 생성하세요.
//    	//- Car클래스 객체를 main메소드에 생성하고, 색상과, 자동차 번호에 red, 2022를 삽입한뒤 결과를 출력하세요.
//    	//- 두번째 Car클래스 객체를 생성하고, 출력 시 주소값 할당 없이 위의 결과와 똑같이 나오게 하세요.
//    	
//    	Car car = new Car();
//    	car.makeCar("red", 2022);
//    	
//    	
//    	//5. 연산자
//    	//- x가 1이고, y가 -1일때 x>0 && y<0 출력 결과는?
//    	int x = 1;
//    	int y = -1;
//    	System.out.println(x>0 && y<0);  // true
//    	
//    	
//    	//5. 연산자
//    	//- '100 * 2 / 3 % 5'의 출력 결과는?
//    	System.out.println(100 * 2 / 3 % 5);  // 1
//    	
//    	
//    	//5. 연산자
//    	//- 'a=b=c=5'의 a,b,c 출력 결과는?
//    	//a,b,c = 5
//    	
//    	
//    	//5. 연산자
//    	//- x가 12일때, z=x++의 결과와, y=++x의 z와 y의 출력 결과는?
//    	int x2 = 12;
//    	int z = 0;
//    	int y2 = 0;
//    	z = x2++;
//    	System.out.println(z=x2++); //13
//    	System.out.println(y2=++x2);  //
//    	
//    	
//    	//5. 연산자
//    	//- boolean b = true;를 선언하고 논리연산자를 사용하여 false이 출력 되게 하세요.
//    	boolean b3 = true;
//    	System.out.println(!b3);
//    	
//    	
//    	//5. 연산자
//    	//- 사다리꼴 넓이구하기 (윗변=10, 밑변=5, 높이=2)일때 넓이를 구하고 출력 하세요.
//    	int top = 10;
//    	int down = 5;
//    	int high = 2;
//    	double a3 = 0.5;
//    	System.out.println(a3*(top+down)*high);  //15
//    	
//    	
//    	//5. 연산자
//    	//대입연산자만을 사용하여 '3더하기, 3빼기, 3곱하기, 3나누기, 3나머지' 한 값을 각각 출력 하세요.
//    	int a4 = 11;
//    	a4+=1;
//        System.out.println(a4);  //12
//
//    	a4-=1;
//        System.out.println(a4);  //11
//
//    	a4*=3;
//        System.out.println(a4);  //33
//    	
//    	a4/=3;
//        System.out.println(a4);  //11???????!!!!!!!
//    	
//        //5. 연산자
//        //- 연필이 534개, 학생이 30명일때, 학생 한명이 가질 수 있는 연필의 수와 남은 연필 수는 몇 개 인가요?
//        int pencil = 534;
//        int student = 30;
//        int ps = pencil/student;
//        int ps2 = pencil%student;
//        System.out.println("연필 : " + ps);
//        System.out.println("나머지 연필 : " + ps2);//학생 한명당 연필 17개씩 가지고 24개가 남는다
//   
//    	
//        //6. 조건문
//        //- a가 10이고 b가 ++10일때, 둘이 같으면 "같습니다." , 다르면 "다릅니다"를 출력하세요.
//        // ( 삼항 연산자를 이용해서도 풀어보세요. : (조건문) ? 참 : 거짓 )
//        int a5 = 10;
//    	int b5 = 10;
//    	if(a5==++b5) {
//    		System.out.println("같습니다");
//    	}else {
//    		System.out.println("다릅니다");
//    	}
//    	
//    	
//		String result = (a5==++b5)? "같습니다" : "다릅니다";
//		System.out.println("으익:" + result);  //으익:11??????!!!!!
//		
//		
//	    //6. 조건문
//	    //- if-else를 사용하여, 점수가 85점일때 90점 이상이면 "a등급", 80점 이상이면 "b등급" 아니면 "c등급"을 출력 하세요.
//		int i = 85;
//		String score = "";
//	    if (i>=90) {
//	    	 score = "a등급";
//	    }else if(i>=80) {
//	    	 score = "b등급";
//	    }else {
//	    	 score = "c등급"; 
//	    }
//  	    System.out.println(score);  //b등급

		// - 중첩 if를 사용하여, 국어, 수학, 영어점수를 입력 받아서 평균이 95이상이면 "a+", 평균이 90이상이면 "a",
		// 평균이 85이상이면 "b+", 평균이 80이상이면 "b"을 출력되게 하세요.

		// 1.국어 수학 영어 점수를 입력받는다
		// 2.국어 수학 영어 입력받은 값에 평균을 구한다
		// 3.if문을 사용해서 90점이상이면 에이 80점이상이면 비를 만든다
		// 4.그 이프문안에 이프문을 사용해서 90점
		// 학점

//		Scanner sc3 = new Scanner(System.in);
//		System.out.println("당신의 국어 점수를 입력하세요");
//		System.out.println("당신의 수학 점수를 입력하세요");
//		System.out.println("당신의 영어 점수를 입력하세요");
//		int jumsu7 = Integer.parseInt(sc3.nextLine());
//		int jumsu8 = Integer.parseInt(sc3.nextLine());
//		int jumsu9 = Integer.parseInt(sc3.nextLine());
//		int ess = (jumsu7 + jumsu8 + jumsu9) / 3;
//		String grade = "";
//		System.out.println(ess);
//
//		if (ess >= 90) {
//			grade = "a";
//			if (ess >= 95) {
//				grade = "a+";
//			}
//		} else if (ess >= 80) {
//			grade = "b";
//			if (ess >= 85) {
//				grade = "b+";
//			}
//
//		} else {
//			System.out.println("zzzzz");
//		}
//		System.out.println(grade);

		// 6. 조건문
		// - 0~100의 점수를 랜덤으로 받아, 점수가 90점이상이면 "a등급", 80점 이상이면 "b등급" 아니면 "c등급"을 switch문으로
		// 풀어 보세요.
		// (힌트: 점수값을 나누기 10한 몫을 기억하세요.)
//		int jumsu2 = (int) (Math.random() * 101);
//		System.out.println(jumsu2);
//		String score2 = "";
//
//		int i2 = jumsu2 / 10;
//		switch (i2) {
//		case 10:
//			score2 = "a+";
//			break;
//		case 9:
//			score2 = "a";
//			break;
//		case 8:
//			score2 = "b";
//			break;
//		default:
//			score2 = "c";
//			break;
//		}
//		System.out.printf("당신의 점수는 %s 학점은 %s입니다 \n", jumsu2, score2); 

		// 6 .조건문
		// - 1~6을 랜덤으로 받아 1이면 "1번 나왔습니다." 2이면"2번나왔습니다." ... :6번 나왔습니다"까지 출력 하세요.
//		int num = (int) ((Math.random() * 6) + 1);
//		
//		if(num == 1) {
//			System.out.println("1번이 나왔습니다.");
//		}else if(num == 2) {
//			System.out.println("2번이 나왔습니다");
//		}else if(num == 3) {
//			System.out.println("3번이 나왔습니다");
//		}else if(num == 4) {
//			System.out.println("4번이 나왔습니다");
//		}else if(num == 5) {
//			System.out.println("5번이 나왔습니다");
//		}else {
//			System.out.println("6번이 나왔습니다");
//		}
//		
//		System.out.printf("%s번이 나왔습니다", num);

		// 6. 조건문
		// - 1~10을 사용자에게 입력받아 짝수이면 "짝수", 홀수이면 "홀수"를 출력 하세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("1~10번 까지 중 하나만 적어주세요 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		String str2 = "";

		if (0 <= num2 && num2 <= 10) {
			if (num2 % 2 == 0) {
				str2 = "짝수 입니다";
			} else if (num2 % 2 != 0) {
				str2 = "홀수 입니다";
			}
		} else {
			System.out.println("다른값을 입력하세요");
		}

		System.out.printf("%s", str2);

		// 6. 조건문
		// - Switch문을 사용하여 학점을 입력 받은 값이 A또는a이면 "최고" B또는b이면"멋지다" 다른 값은 "훌륭해"를 출력 하세요.
		Scanner sc2 = new Scanner(System.in);
		System.out.println("당신의 학점을 입력해주세요 : ");
		String jumsu3 = sc2.nextLine();
		String res = "";

		switch (jumsu3) {
		case "A":
		case "a":
			res = "최고";
			break;
		case "B":
		case "b":
			res = "멋지다";
			break;
		default:
			res = "훌륭해";
			break;
		}
		System.out.printf("%s", res);

	}

}