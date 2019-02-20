import java.util.Scanner;

public class ArrayTest {
    static Scanner sc = new Scanner(System.in);
    static int[] intarray = { 1,2,3,4,5,6,7,8,9,10 };
    static int[] score = new int[3];

    public static void main(String[] args) {
        //1.
        int sum1 = 0;
        for (int i = 1; i < intarray.length; i+=2) {
            sum1 += intarray[i];
        }
        System.out.println(sum1);

        //2.
        int sum2 = 0;
        for (int i = 0; i < intarray.length; i++) {
            if (i % 2 == 0) {
                sum2 += i;
            }
        }
        System.out.println(sum2);

        //3.
        int sum3 = 0;
        for (int i = 0; i < score.length; i++) {
            System.out.println("점수를 입력하세요");
            score[i] = Integer.parseInt(sc.nextLine());
            sum3 += score[i];
        }
        System.out.println("평균 : " + (sum3 / score.length));
    }
}