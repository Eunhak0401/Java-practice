package 배열;

import java.util.Scanner;

public class BaekJoon_10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] basket = new int[N];

        for (int m = 0; m < M; m++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            for (int b = i - 1; b < j; b++) {
                basket[b] = k;
            }
        }

        for (int n = 0; n < N; n++) {
            System.out.print(basket[n] + " ");
        }
        sc.close();

    }
}
