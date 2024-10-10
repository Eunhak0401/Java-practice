package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BaekJoon_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    deque.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}