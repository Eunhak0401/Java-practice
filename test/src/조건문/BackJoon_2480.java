package 조건문;

import java.util.Scanner;

public class BackJoon_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = 0;

        if(a > b && a > c){
            max = a;
        } else if (b > a && b > c) {
            max = b;
        } else if (c > a && c > b) {
            max = c;
        }

        if(a == b && a == c && b == c){
            System.out.print(10000 + (1000 * a));
        } else if (a != b && a != c && c != b) {
            System.out.print(100 * max);
        } else if (a == b && a != c || a == c && a != b || b == c && a != b ) {
            if(a == b){
                System.out.print(1000 + (100 * a));
            } else if (a == c) {
                System.out.print(1000 + (100 * a));
            } else if (b == c) {
                System.out.print(1000 + (100 * b));
            }
        }

    }
}
