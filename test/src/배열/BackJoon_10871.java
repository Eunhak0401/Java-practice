package 배열;

import java.util.Scanner;

public class BackJoon_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            if (a[i] < X) {
                System.out.print(a[i] + " ");  // X보다 작은 값만 출력
            }
        }
    }
}

