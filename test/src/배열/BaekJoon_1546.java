package 배열;

import java.util.Scanner;

public class BaekJoon_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double b = 0;

        int a = sc.nextInt();
        int[] A = new int[a];

        double max = 0;
        double sum = 0;

        for (int i = 0; i < a; i++) {
            A[i] = sc.nextInt();

            if (A[i] > max){
                max = A[i];
            }
        }

        for (int j = 0; j < a; j++) {
            b = A[j] / max * 100;

            sum += b;
        }
        double avg = sum / a;
        System.out.println(avg);
        sc.close();
    }
}
