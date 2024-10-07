package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine().trim();  // 공백 제거
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) { // 입력된 문자열 수까지 반복
            char c = input.charAt(i);

            // 피연산자(알파벳은 바로 출력)
            if (Character.isLetter(c)) {
                sb.append(c);
            }
            // 연산자 처리
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // 스택이 비어있지 않고, 현재 연산자보다 우선순위가 높은 연산자가 있을 때 pop
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
                // 여는 괄호가 나올 때까지 스택에서 연산자를 pop
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                // 여는 괄호 제거 (스택에서 pop)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
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
