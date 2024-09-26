package 배열;

import java.util.Scanner;

public class BackJoon_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int[] a = new int[A];

        for (int i = 0; i < A; i++) {
            a[i] = sc.nextInt();
        }

        int max = a[0];
        int min = a[0];

        for (int i = 0; i < A; i++) {
            if (a[i] > max){
                max = a[i];
            }
            if (a[i] < min){
                min = a[i];
            }
        }
        System.out.println(min + " " + max);
    }
}
