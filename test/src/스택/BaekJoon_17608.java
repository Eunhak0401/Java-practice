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

        stack.push(heights[a - 1]);
    }
}
