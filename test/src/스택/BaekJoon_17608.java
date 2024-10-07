package 스택;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon_17608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // 막대기 개수 입력
        int[] heights = new int[a];

        for (int i = 0; i < a; i++) {
            heights[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(heights[a - 1]); // 가장 오른쪽 막대를 스텍에 넣기

        //이제 오른쪽에서 왼쪽으로 막대기 확인하기
        for (int i = a - 2; i >= 0; i--) {
            // 현재 막대가 스택의 최상단 막대보다 높으면 스택에 추가
            if (heights[i] > stack.peek()) {
                stack.push(heights[i]);
            }
        }
        System.out.println(stack.size());

        sc.close();
    }
}
