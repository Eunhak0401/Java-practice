package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = 0;
        int sum = 0;
        int avg = 0;

        int[] a = new int[5];

        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        Arrays.sort(a);
        b = a[2];
        avg = sum / 5;
        System.out.println(avg);
        System.out.println(b);
    }
}
