package 대학교_자바;

import java.util.Scanner;

public class Array_0927_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] A = new int[5];

        int sum = 0;
        int avg = 0;

        for (int i = 0; i < 5; i++) {
            A[i] = sc.nextInt();
            sum += i;
        }
        avg = sum/5;
        System.out.println("합계는 " + sum + " 평균은 " + avg);
    }
}
