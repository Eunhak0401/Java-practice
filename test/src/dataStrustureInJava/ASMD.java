package dataStrustureInJava;

import java.util.StringTokenizer;

public class ASMD {
    private static String numbers = "123456789";

    private static String operators = "+-*/^";

    public ASMD() {

    }

    static boolean isGoodPair(String expr) {
        boolean result = false;
        StackSL mystack = new StackSL();

        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                mystack.push('(');
            } else if (expr.charAt(i) == ')') {
                mystack.pop();
                if (mystack.isEempy()) {
                    if (i == (expr.length() - 1)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                ;
            }
        }
        return result;
    }

    static String inFix(String expr) {
        if (!isGoodPair(expr)) {
            return "fail";
        }

        String buff = "";
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
            } else if (expr.charAt(i) == ')') {
            } else {
                buff += expr.charAt(i);
            }
        }

        return buff;
    }

    static String postFix(String expr) {
        if (!isGoodPair(expr)) {
            return "fail";
        }

        String buff = "";
        StackSL mystack = new StackSL();
        for (int i = 0; i < expr.length(); i++) {
            if (operators.contains("" + expr.charAt(i))) {
                mystack.push(expr.charAt(i));
            } else if (expr.charAt(i) == '(') {
            } else if (expr.charAt(i) == ')') {
                buff += mystack.pop();
            } else {
                buff += expr.charAt(i);
            }
        }
        return buff;
    }


    static int evaluatePostFix(String expr) {
        StackSL mystack = new StackSL();
        String[] tokens = expr.split(" ");

        // 입력 데이터 검증: 연산자와 피연산자의 개수 균형 확인
        int operandCount = 0;
        int operatorCount = 0;

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                operandCount++;
            } else if (operators.contains(token)) {
                operatorCount++;
            }
        }

        if (operandCount - 1 != operatorCount) {
            throw new IllegalArgumentException("후위 표기식이 잘못되었습니다. (피연산자와 연산자의 수 불균형)");
        }

        // 후위 표기식 평가
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                // 숫자를 스택에 푸시 (문자열로 저장)
                mystack.push(token);
            } else {
                // 연산자를 만난 경우 피연산자 2개를 스택에서 pop
                String op2 = mystack.pop(); // 스택에서 pop
                String op1 = mystack.pop(); // 스택에서 pop

                if (op1 == null || op2 == null) {
                    throw new IllegalStateException("스택에 충분한 피연산자가 없습니다.");
                }

                int operand2 = Integer.parseInt(op2);
                int operand1 = Integer.parseInt(op1);

                int result;
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    case "^":
                        result = (int) Math.pow(operand1, operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("알 수 없는 연산자: " + token);
                }

                // 결과를 문자열로 변환하여 스택에 푸시
                mystack.push(String.valueOf(result));
            }
        }

        // 스택의 최종 결과 반환
        String finalResult = mystack.pop();
        if (finalResult == null) {
            throw new IllegalStateException("스택이 비어 있습니다. 올바르지 않은 후위 표기식입니다.");
        }
        return Integer.parseInt(finalResult);
    }
}