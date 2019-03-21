
public class Ex06_operation {
	
	public static void main(String[] args) {
		
		int result = 100/100;
		System.out.println(result);
		
		
		result = 13/2;
		System.out.println(result);
		
		result =  13%4;
		System.out.println(result);
		
		//증가감 연산자 (++, --) 1씩 증가, 1씩 감소
		int i = 10;
		++i; //전치 증가
		System.out.println(i);
		
		i++; //후치 증가
		System.out.println(i);
		
		//변수 1개 : 전치, 후치 동일
		
		//POINT : 전치와 후치가 연산자와 결합하면 다름
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2; //j2 1증가시키고 + 연산
		System.out.println(result2);
		// 여기까지 i2 = 5,  j2 = 5, result2 = 10
	    result2 = i2 + j2++;
		// i2 = 5, j2 = 6, result2 = 10
		System.out.println(result2);
		System.out.println(j2);
		
		//POINT
		//자바의 연산 규칙
		//정수의 모든 [연산]은 int로 변환 후 처리
		//byte + byte => 컴파일러는 int + int로 인지
		byte b = 100; // -128 ~ 127
		byte c = 1;
		byte d = (byte)(b + c);
		int e = b + c;
		// 1. byte d = (byte)(b + c); 쓰레기 값이 나올 수 있다.
		// 2. int d = b + c; 정답
		System.out.println(e);
		
		//byte + short => int + int
		//char + char => int + int
		//POINT : 연산에 int 보다 작은 타입은 int 형 변환(long 제외)
		//byte, char, short => int 바꾸어서 연산 처리
		
		//byte + short => int + int >> 결과 int
		//char + char => int + int >> 결과 int
		//int + long => long + long >> 결과 long
		
		//정수와 실수 >> 실수
		//float + int >> float + float >> float
		//long + float >> flaot + float >> float
		//float + double >> double + double >> double
		
		float num2 = 10.45f;
		int num3 = 20;
		
		// num2 + num3
		float num4 = num2 + num3;
		System.out.println(num4);
		
		//char 는 정수타입
		char c2 = '!';
		char c3 = '!';
		
		//c2+c3
		int c4 = c2+c3;
		System.out.println(c4);
		
		char c5 = (char)c4;
		System.out.println(c5);
		System.out.println((char)c4);
		
		//제어문
		//중소기업 시험문제 (구구단) ==> 별찍기
		int sum = 0;
		for(int j = 1; j <= 100; j++) {
			//System.out.println(j);
			sum = sum + j;
			
		}
		
		System.out.println(sum);
		
		
		//1~100 까지 짝수의 합
		int sum1 = 0;
		for(int l = 1; l <= 100; l++) {
			
			if(l%2 ==0) {
				
			sum1 += l;
			
			}
		}
		
		System.out.println(sum1);
		
		//== 연산자 (값(value) 비교하는 연산자)
		//javascript (===)   아직몰라도됨
		if(10 == 10.0f) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		//! 부정연산자
		if('A' != 65) { //같지 않니?
			System.out.println("같은 값이 아니야");
		}else {
			System.out.println("같은 값이야");
		}
		
		
		//암기하기(POINT)
		//제어문처럼 쓰는 연산자(삼항연산자)☆★☆★
		int p = 10;
		int k = -10;
		int result4 = (p==k)?p:k; 
		//? 앞에있는 조건식이 참이라면  : 앞에 있는 값을
		//? 앞에있는 조건식이 거짓이라면 : 뒤에 있는 값을
		System.out.println("result4 : " + result4);
		
		//위 삼항 연산자를 if문으로 바꾸어 보세요!    삼항연산자가 더 효율적인코드!
		if(p==k) {
			result4 = p;
		}else {
			result4 = k;
		}
		
		/*
              진리표
         0 : false
         1 : true
		        OR 둘중에 하나만 참이여도 참      AND 둘다 참이여야 참
		 0 0     0                       0
		 0 1     1                       0
		 1 0     1                       0
		 1 1     1                       1
		 
		 sql(oracle)
		 select *
		 from emp
		 where job='sales' and sal > 2000; 
		 
		 select *
		 from emp
		 where job='sales' or sal > 2000;
		 */
		
		
		//연산자 ( | (or) , & (and) )
		//0 과 1 의 bit 연산
		int x = 3;
		int y = 5;
		System.out.println("x|y : " + (x|y));
		System.out.println("x&y : " + (x&y));
		//십진수 3을 -> 2진수값으로 변환
		// 128 64 32 16 8 4 2 1 
		//   0  0  0  0 0 0 1 1 (2진수 : 3)
		//              0 1 0 1 (2진수 : 5)
		//OR            0 1 1 1 -> 1 + 2 + 4 > 7    x|y 는 7의 값이나옴
		//AND           0 0 0 1 -> 1    x&y 는 1의 값이 나옴
		
		//POINT 논리연산 (|| (or), && (and)) 연산자 return boolean
		//중요한 이유 !! ☆★☆★
		//if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1) {실행문}
		//if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1) {실행문}
		
	}

}
