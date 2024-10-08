package 다항식_계산기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class polynomial_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // 숫자(피연산자)는 바로 출력
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
            // 연산자 처리
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // 스택에 더 높은 우선순위의 연산자가 있으면 먼저 pop
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c); // 현재 연산자 스택에 넣기
            }
            // 여는 괄호는 무조건 스택에 push
            else if (c == '(') {
                stack.push(c);
            }
            // 닫는 괄호를 만나면 여는 괄호까지 스택에서 pop
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // 여는 괄호 제거
            }
        }

        // 스택에 남은 연산자 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

    // 연산자의 우선순위를 반환하는 함수
    private static int precedence(char operator) {
        switch (operator) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            default:
                return -1;
        }
    }
}



