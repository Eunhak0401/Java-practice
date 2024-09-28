package 대학교_자바;

import java.util.Scanner;

public class for_0927_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        int a = sc.nextInt();

        for (int i = 1; i < a; i++) {
            int j = 0;
            for (j = 2; j < i; j++) {
                if (i%j==0){
                    break;
                }
            }
            if (i == j){
                count++;
            }
        }
        System.out.println("소수의 개수는 " + count + "개 입니다.");
    }
}
