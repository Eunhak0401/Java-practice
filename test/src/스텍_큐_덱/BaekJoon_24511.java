package 스텍_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BaekJoon_24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new PriorityQueue<>();

        int a = Integer.parseInt(br.readLine());

        for (int i = 0; i < a; i++) {
            int A = Integer.parseInt(br.readLine());

            stack.push(A);
        }
    }
}
