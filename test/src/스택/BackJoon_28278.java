package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BackJoon_28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a; i++) {
            String input = br.readLine();
            String[] parts = input.split(" ");

            if (parts[0].equals("1")){
                int value = Integer.parseInt(parts[1]);
                stack.push(value);
            } else if (parts[0].equals("2")) {
                if (!stack.isEmpty()){
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if (parts[0].equals("3")) {
                sb.append(stack.size()).append("\n");
            } else if (parts[0].equals("4")) {
                if (!stack.isEmpty()){
                    sb.append("0").append("\n");
                } else {
                    sb.append("1").append("\n");
                }
            } else if (parts[0].equals("5")) {
                if (!stack.isEmpty()){
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
