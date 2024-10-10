package 트리;

import java.util.Scanner;

public class BaekJoon_14244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 총 노드 수
        int m = sc.nextInt(); // 리프 노드 수

        if (m == 2) {
            for (int i = 0; i < n - 1; i++) {
                System.out.println(i + " " + (i + 1));
            }
        } else {
            System.out.println("0 1");

            for (int i = 2; i <= m; i++) {
                System.out.println("1 " + i);
            }

            for (int j = m; j < n - 1; j++) {
                System.out.println(j + " " + (j + 1));
            }
        }
        sc.close();
    }
}