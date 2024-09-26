package 배열;

import java.util.Scanner;

public class BaekJoon_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[9];

        for (int i = 0; i < 9; i++) {
            a[i] = sc.nextInt();
        }

        int max = a[0];
        int index = 0;

        for (int i = 1; i < 9; i++) {
            if (a[i] > max){
                max = a[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index + 1);
        sc.close();
    }
}
