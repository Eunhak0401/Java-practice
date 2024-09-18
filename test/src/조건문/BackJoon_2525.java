package 조건문;

import java.util.Scanner;

public class BackJoon_2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();  // 시작 시간 (시)
        int b = sc.nextInt();  // 시작 시간 (분)
        int c = sc.nextInt();  // 요리하는 데 걸리는 시간 (분)

        sc.close();

        int totalMinutes = a * 60 + b + c;  // 전체 시간을 분으로 변환하여 계산
        int h = (totalMinutes / 60) % 24;  // 24시간으로 나눈 나머지를 구해 시간을 계산
        int m = totalMinutes % 60;  // 남은 분 계산

        System.out.println(h + " " + m);
    }
}
