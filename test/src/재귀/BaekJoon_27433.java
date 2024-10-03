package 재귀;

import java.util.Scanner;

public class BaekJoon_27433 {

    public static long factorial(int n){
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long result = factorial(n);

        System.out.println(result);
    }
}
