package 스택;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon_12605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= a; i++) {
            String b = sc.nextLine();
            String[] words = b.split(" ");

        Stack<String> stack = new Stack<>();

        for (String word : words) {
            stack.push(word);
        }

        System.out.print("Case #" + i + ": ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

        sc.close();
    }
}
