package 스택;

import java.util.Scanner;
import java.util.Stack;


public class BaekJoon_25497 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // 기술을 사용한 횟수
        String skills = sc.next(); // 기술 문자열

        Stack<Character> stackL = new Stack<>(); // 'L' 사전 기술을 저장하는 스택
        Stack<Character> stackS = new Stack<>(); // 'S' 사전 기술을 저장하는 스택

        int successCount = 0; // 정상적으로 발동한 기술의 수를 카운트

        for (int i = 0; i < a; i++) {
            char x = skills.charAt(i);
            if (Character.isDigit(x)) {
                successCount += 1; // 성공 카운트를 증가
            } else if (x == 'L') {
                stackL.add(x); // 'L'을 stackL에 추가
            } else if (x == 'S') {
                stackS.add(x); // 'S'를 stackS에 추가
            } else if (x == 'R') {
                if (!stackL.isEmpty()) {
                    stackL.pop(); // 'L'을 제거하고
                    successCount += 1; // 성공 카운트를 증가
                } else {
                    break; // 'L'이 없으면 반복 종료
                }
            } else if (x == 'K') {
                if (!stackS.isEmpty()) {
                    stackS.pop(); // 'S'를 제거하고
                    successCount += 1; // 성공 카운트를 증가
                } else {
                    break; // 'S'가 없으면 반복 종료
                }
            }
        }
        System.out.println(successCount);
    }
}
