package 입출력과사칙연산;

import java.math.BigInteger;
import java.util.Scanner;

public class BaekJoon_10757 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        BigInteger Num1 = new BigInteger(input[0]);
        BigInteger Num2 = new BigInteger(input[1]);

        BigInteger Sum = Num1.add(Num2);

        System.out.println(Sum);
    }
}