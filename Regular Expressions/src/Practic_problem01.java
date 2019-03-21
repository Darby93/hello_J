import java.util.Iterator;

import java.util.Scanner;

public class Practic_problem01 {

	

//지역 정적변수 - 패턴을 바꾸고 싶을 떄 여기를 바꾸세요. 더 갯수를 늘려 테스트하고싶으면

// for문 안에 있는 i(=4)를 맞게 늘려주시고, switch case에 추가해주세요.

    final private static String pattern1 = "^[가-힣]*$";
    final private static String pattern2 = "^[a-zA-Z]*$";
    final private static String pattern3 = "^[0-9]*$";
    final private  static String pattern4 = "^[a-zA-Z가-힣]*$";

	public static void main(String[] argrs) {
		Scanner scan=new Scanner(System.in);
		reInput(scan);
	}

	private static void reInput(Scanner scan){

		System.out.println("parameter을 입력해주세요.(한글 재입력시 숫자나 영어를 입력하고 지우고 입력해주세요. 바이트 문제로 인해 입력 불가능 문제");
		String parameter = scan.next();
		if(parameter.equals("exit")){
			System.out.println("종료합니다.");
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				validPattern(parameter, i);	
			}
			System.out.println("------------------------------");
			reInput(scan);
		}
	}

	

    //Pattern에 틀리면 True || 맞으면 False

    private static boolean validPattern(String parameter, int patternNo) {

        boolean validation = false;

        switch (patternNo) {

            case 0:

                validation = parameter.matches(pattern1);

                System.out.println("patternNo : "+patternNo+" : "+validation);

                break;

            case 1:

                validation = parameter.matches(pattern2);
                System.out.println("patternNo : "+patternNo+" : "+validation);
                break;

            case 2:

                validation = parameter.matches(pattern3);
                System.out.println("patternNo : "+patternNo+" : "+validation);
                break;

            case 3:

                validation = parameter.matches(pattern4);
                System.out.println("patternNo : "+patternNo+" : "+validation);
                break;
        }
        return validation;
    }
}
