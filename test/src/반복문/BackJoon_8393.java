package 반복문;

import java.util.Scanner;

public class BackJoon_8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < a+1; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
