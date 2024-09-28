package 문자열;

import java.util.Scanner;

public class BaekJoon_9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char firstChar = 0;
        char finalChar = 0;

        int a = sc.nextInt();

        for (int i = 0; i < a; i++) {
            String b = sc.next();

            firstChar = b.charAt(0);
            finalChar = b.charAt(b.length() - 1);

            System.out.print(firstChar);
            System.out.println(finalChar);
        }
        sc.close();
    }
}
