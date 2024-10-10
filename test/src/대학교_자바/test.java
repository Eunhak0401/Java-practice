package 대학교_자바;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        System.out.println("정수를 5개 입력하시오");

        for (int i = 0; i < 5; i++) {
        int a = sc.nextInt();
        sum += i;
        }
        System.out.println("양수의 합은 " + sum);
    }
}
