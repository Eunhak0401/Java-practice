package 심화1;

import java.util.Scanner;

public class BaekJoon_2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        for (int i = 1; i < a; i++) {
            System.out.print(" ");
            for (int j = 0; j < i; j++) {

                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
