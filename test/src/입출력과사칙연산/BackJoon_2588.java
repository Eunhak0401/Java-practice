package 입출력과사칙연산;

import java.util.Scanner;

public class BackJoon_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); //472
        int b = sc.nextInt(); //385

        int b1 = b % 10;         // b의 마지막 자리 숫자 (1의 자리)
        int b2 = (b / 10) % 10;  // b의 두 번째 자리 숫자 (10의 자리)
        int b3 = b / 100;        // b의 첫 번째 자리 숫자 (100의 자리)

        System.out.println(a * b1); // 472 * 5 (1의 자리 숫자와 곱셈)
        System.out.println(a * b2); // 472 * 8 (10의 자리 숫자와 곱셈)
        System.out.println(a * b3); // 472 * 3 (100의 자리 숫자와 곱셈)
        System.out.println(a * b);  // 472 * 385 (전체 곱셈 결과)
    }
}
