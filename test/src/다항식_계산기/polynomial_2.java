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

            // 다자릿수 숫자 처리
            if (Character.isDigit(c)) {
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    sb.append(input.charAt(i));
                    i++;
                }
                sb.append(' '); // 숫자 사이에 구분을 위해 공백 추가
                i--; // for loop에서 i가 이미 증가하므로 하나 감소
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                // 우선순위가 같거나 클 때 스택에서 pop
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    sb.append(stack.pop()).append(' ');
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop()).append(' ');
                }
                stack.pop(); // 여는 괄호 제거
            }
        }

        // 스택에 남은 연산자 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println("후위 표기식: " + sb.toString().trim());

        // 후위 표기식을 계산하는 부분
        String postfix = sb.toString().trim();
        System.out.println("다항식 결과: " + evaluatePostfix(postfix));
    }

    // 연산자의 우선순위를 반환하는 함수
    private static int precedence(char operator) {
        switch (operator) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // 후위 표기식을 계산하는 함수
    private static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) { // 숫자라면
                stack.push(Integer.parseInt(token)); // 다자릿수 숫자 처리
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "^":
                        stack.push((int) Math.pow(operand1, operand2));
                        break;
                }
            }
        }

        // 스택에 남은 하나의 값이 최종 결과
        return stack.pop();
    }
}
