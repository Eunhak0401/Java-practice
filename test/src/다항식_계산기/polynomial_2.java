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

        System.out.println("후위 표기식: " + sb.toString());

        // 후위 표기식을 계산하는 부분
        String postfix = sb.toString();
        System.out.println("후위 표기식 결과: " + evaluatePostfix(postfix));

        // 스택에 남은 연산자 출력
        while (!stack.isEmpty()) {
        sb.append(stack.pop());
    }
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
    
    // 후위 표기식을 계산하는 함수
    private static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // 피연산자일 경우 스택에 push
            if (Character.isDigit(c)) {
                stack.push(c - '0'); // 문자에서 숫자로 변환
            }
            // 연산자를 만나면 스택에서 두 개의 피연산자를 꺼내서 계산 후 다시 스택에 push
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        // 스택에 남은 하나의 값이 최종 결과
        return stack.pop();
    }
}




