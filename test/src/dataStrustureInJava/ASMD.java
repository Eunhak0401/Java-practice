package dataStrustureInJava;

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


//    static int evaluatePostFix(String expr) {
//        // 계산을 위한 스택 생성
//        StackSL mystack = new StackSL();
//        String operators = "+-*/^";
//
//        // 수식을 한 글자씩 읽어들여 계산
//        for (int i = 0; i < expr.length(); i++) {
//            char ch = expr.charAt(i);
//
//            // 숫자인 경우 스택에 추가
//            if (Character.isDigit(ch)) {
//                mystack.push(ch - '0');  // char를 int로 변환하여 푸시
//            }
//            // 연산자인 경우 스택에서 두 값을 꺼내 연산 수행
//            else if (operators.contains("" + ch)) {
//                if (mystack.isEempy())  // 오타 수정: isEmpty()가 맞습니다
//                    throw new IllegalArgumentException("Invalid postfix expression: insufficient operands.");
//
//                int b = mystack.pop();  // pop() 메서드가 int 값을 반환합니다.
//                int a = mystack.pop();  // pop() 메서드가 int 값을 반환합니다.
//                int result = 0;
//
//                // 연산자에 따른 계산 수행
//                switch (ch) {
//                    case '+':
//                        result = a + b;
//                        break;
//                    case '-':
//                        result = a - b;
//                        break;
//                    case '*':
//                        result = a * b;
//                        break;
//                    case '/':
//                        if (b == 0) throw new ArithmeticException("Divide by zero error.");
//                        result = a / b;
//                        break;
//                    case '^':
//                        result = (int) Math.pow(a, b);
//                        break;
//                    default:
//                        throw new IllegalArgumentException("Unsupported operator: " + ch);
//                }
//                mystack.push(result);  // 연산 결과를 다시 스택에 푸시
//            } else if (!Character.isWhitespace(ch)) {
//                throw new IllegalArgumentException("Invalid character in expression: " + ch);
//            }
//        }
//
//        // 최종 결과는 스택의 마지막 값
//        if (mystack.isEempy()) {  // 오타 수정: isEmpty()가 맞습니다
//            throw new IllegalArgumentException("Invalid postfix expression: no result.");
//        }
//        return mystack.pop();  // pop() 메서드는 이제 int 값을 반환합니다.
//    }


}