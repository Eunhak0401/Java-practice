package 입출력과사칙연산;

import java.math.BigInteger;
import java.util.Scanner;

public class BaekJoon_1271 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        BigInteger n = new BigInteger(input[0]);
        BigInteger m = new BigInteger(input[1]);

        BigInteger divide = n.divide(m);
        BigInteger mod = n.mod(m);

        System.out.println(divide);
        System.out.println(mod);
    }
}
