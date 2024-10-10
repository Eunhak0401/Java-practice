package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < a; i++) {
            String input = br.readLine();
            String[] parts = input.split(" ");

            if (parts[0].equals("push")) {
                int value = Integer.parseInt(parts[1]);
                queue.offer(value);
            } else if (parts[0].equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n"); // pop
                } else {
                    sb.append("-1\n");
                }
            } else if (parts[0].equals("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek()).append("\n"); // front
                } else {
                    sb.append("-1\n");
                }
            } else if (parts[0].equals("back")) {
                if (!queue.isEmpty()) {
                    // back을 가져오려면 모든 요소를 임시 저장해야 함
                    Integer back = null;
                    for (Integer num : queue) {
                        back = num; // 마지막 값을 업데이트
                    }
                    sb.append(back).append("\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (parts[0].equals("size")) {
                sb.append(queue.size()).append("\n"); // size
            } else if (parts[0].equals("empty")) {
                sb.append(queue.isEmpty() ? "1\n" : "0\n"); // empty
            }
        }
        System.out.println(sb.toString());
    }
}