package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_25305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int[] A = new int[a];
        int b = sc.nextInt();
        int c = 0;

        for (int i = 0; i < a; i++) {
            A[i] = sc.nextInt();
            }
        Arrays.sort(A);
        if (b > 0){
            c = A[a-b];
        }
        System.out.println(c);
    }
}
