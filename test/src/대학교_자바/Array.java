package 대학교_자바;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[5];

        int max = 0;
        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
            if (a[i] > max){
                max = a[i];
            }
        }
    }
}
