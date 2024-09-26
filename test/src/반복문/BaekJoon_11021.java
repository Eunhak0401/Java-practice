package 반복문;

import java.util.Scanner;

public class BaekJoon_11021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int a = sc.nextInt();

        for (int i = 1; i < a + 1; i++) {
            int b = sc.nextInt();
            int c = sc.nextInt();

            sum = b + c;

            System.out.println("Case #" + i + ": " + sum);
        }
        sc.close();
    }
}
