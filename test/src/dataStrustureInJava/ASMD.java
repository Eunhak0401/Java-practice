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
            }
            else if (expr.charAt(i) == ')') {
                mystack.pop();
                if (mystack.isEempy()) {
                    if (i == (expr.length() - 1)) return true;
                    else                          return false;
                }
            } else {
                ;
            }
        }
        return result;
    }

    static String inFix(String expr) {
        if (!isGoodPair(expr)) return "fail";

        String buff = "";
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(');
            else if (expr.charAt(i) == ')') ;
            else buff += expr.charAt(i);
        }
        return buff;
    }

    static String postFix(String expr) {
        if (!isGoodPair(expr)) return "fail";

        String buff = "";
        StackSL mystack = new StackSL();

        for (int i = 0; i < expr.length(); i++) {
            if      (operators.contains("" + expr.charAt(i))) mystack.push(expr.charAt(i));
            else if (expr.charAt(i) == '(') ;
            else if (expr.charAt(i) == ')') buff += mystack.pop();
            else                            buff += expr.charAt(i);
        }
        return buff;
    }

    static int evaluatePostFix(String formula) {
        StackSL mystack = new StackSL();
        if (ASMD.isGoodPair(formula) == false)
            return 0;

        String postFix = postFix(formula);
        char c;
        int result = 0;

        for (int i = 0; i < postFix.length(); i++) {
            c = postFix.charAt(i);

            if (numbers.contains("" + postFix.charAt(i)))
                mystack.push(c);
            else if(operators.contains("" + postFix.charAt(i))) {
                int num2 = mystack.pop().charAt(0) - '0';
                int num1 = mystack.pop().charAt(0) - '0';

                if      (postFix.charAt(i) == '+') result = num1 + num2;
                else if (postFix.charAt(i) == '-') result = num1 - num2;
                else if (postFix.charAt(i) == '*') result = num1 * num2;
                else if (postFix.charAt(i) == '/') result = num1 / num2;
                else if (postFix.charAt(i) == '^') result = (int) Math.pow(num1, num2);

                System.out.println("             " + num1 + " " + postFix.charAt(i) + " " + num2 + " = " + result);

                mystack.push(result);
            }
        }
        result = mystack.pop().charAt(0) - '0';

        return result;
    }
}