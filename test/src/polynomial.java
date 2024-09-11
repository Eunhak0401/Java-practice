import java.util.Scanner;

public class polynomial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("계산 하고 싶은 다항식을 입력하시오: ");
        String polynomial = scanner.nextLine(); // 다항식 입력받기
        scanner.close(); // 스캐너 닫기

        String processedInput = roundBrackets(polynomial); // 괄호 처리
        double result = evaluatePolynomial(processedInput); // 최종 계산
        System.out.println("계산된 다항식 결과: " + result);
    }

    // 괄호를 처리하는 함수
    public static String roundBrackets(String input) {
        while (input.contains("(")) { // 괄호가 있을 동안 반복
            int openIndex = input.lastIndexOf("("); // 가장 안쪽의 '(' 위치
            int closeIndex = input.indexOf(")", openIndex); // 해당 '('에 대응하는 ')' 위치

            // 괄호 내부의 내용 추출
            String insideBrackets = input.substring(openIndex + 1, closeIndex);

            // 괄호 내부의 식을 계산
            double resultInside = evaluatePolynomial(insideBrackets);

            // 계산 결과로 원래 입력의 괄호 부분을 대체
            input = input.substring(0, openIndex) + resultInside + input.substring(closeIndex + 1);
        }
        return input;
    }

    // 다항식을 계산하는 함수 (덧셈과 뺄셈 처리)
    public static double evaluatePolynomial(String input) {
        input = input.replace(" ", ""); // 공백 제거

        // 곱셈과 나눗셈을 먼저 처리
        input = evaluateMultiplicationAndDivision(input);

        // 덧셈과 뺄셈 처리
        return evaluateAdditionAndSubtraction(input);
    }

    // 곱셈과 나눗셈을 처리하는 함수
    public static String evaluateMultiplicationAndDivision(String input) {
        String[] terms = input.split("(?=\\+)|(?=-)");
        StringBuilder result = new StringBuilder();

        for (String term : terms) {
            if (term.contains("*") || term.contains("/")) {
                String[] factors = term.split("(?=\\*)|(?=/)");
                double tempResult = Double.parseDouble(factors[0]);

                for (int i = 1; i < factors.length; i++) {
                    if (factors[i].startsWith("*")) {
                        tempResult *= Double.parseDouble(factors[i].substring(1));
                    } else if (factors[i].startsWith("/")) {
                        tempResult /= Double.parseDouble(factors[i].substring(1));
                    }
                }
                result.append(tempResult);
            } else {
                result.append(term);
            }
        }
        return result.toString();
    }

    // 덧셈과 뺄셈을 처리하는 함수
    public static double evaluateAdditionAndSubtraction(String input) {
        String[] terms = input.split("(?=\\+)|(?=-)");
        double result = 0;

        for (String term : terms) {
            term = term.trim();
            if (term.isEmpty()) continue;

            if (term.startsWith("+")) {
                result += Double.parseDouble(term.substring(1));
            } else if (term.startsWith("-")) {
                result -= Double.parseDouble(term.substring(1));
            } else {
                result += Double.parseDouble(term);
            }
        }
        return result;
    }
}



