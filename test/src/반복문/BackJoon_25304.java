package 반복문;

import java.util.Scanner;

public class BackJoon_25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // 총 가격
        int b = sc.nextInt(); // 물건 갯수
        int sum = 0;

        for (int i = 0; i < b; i++){
            int c = sc.nextInt(); // 물건 가격
            int d = sc.nextInt(); // c의 갯수

            sum += c*d; // 물건 가격 더하기
        }
        if (a == sum){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
