package 배열;

import java.util.Scanner;

public class BaekJoon_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        int b = sc.nextInt();
        int[] a = new int[b];

        for (int i = 0; i < b; i++) {
            a[i] = sc.nextInt();
        }

        int c = sc.nextInt();
        for (int i = 0; i < b; i++) {
            if (c == a[i]) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}

