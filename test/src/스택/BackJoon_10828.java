package 스택;

import java.util.Scanner;
import java.util.Stack;

public class BackJoon_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            if (parts[0].equals("push")){ // push가 들어오면
                int value = Integer.parseInt(parts[1]);
                stack.push(value);
            } else if (parts[0].equals("top")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek()); // 스택이 비어 있지 않으면 top 출력
                } else {
                    System.out.println("-1"); // 스택이 비어 있으면 -1 출력
                }
            } else if (parts[0].equals("size")) {
                System.out.println(stack.size());
            } else if (parts[0].equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop()); // 스택이 비어 있지 않으면 top 출력
                } else {
                    System.out.println("-1"); // 스택이 비어 있으면 -1 출력
                }
            } else if (parts[0].equals("empty")) {
                if (!stack.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println("1");
                }
            }
        }
        sc.close();
    }
}
