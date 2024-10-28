package 스텍_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BaekJoon_28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();

        int a = Integer.parseInt(br.readLine());

        for (int i = 0; i < a; i++) {
            String[] inputs = br.readLine().split(" ");
            int A = Integer.parseInt(inputs[0]);

            if (A == 1 && inputs.length > 1) { // 1이 입력되면
                int b = Integer.parseInt(inputs[1]);
                deque.addFirst(b);
            } else if (A == 2 && inputs.length > 1) {
                int c = Integer.parseInt(inputs[1]);
                deque.addLast(c);
            } else if (A == 3) {
                if (!deque.isEmpty()) { // 정수가 있다면
                    System.out.println(deque.pollFirst());
                } else {
                    System.out.println("-1");
                }
            } else if (A == 4){
                if (!deque.isEmpty()){
                    System.out.println(deque.pollLast());
                }else {
                    System.out.println("-1");
                }
            } else if (A == 5) {
                System.out.println(deque.size());
            } else if (A == 6) {
                if (!deque.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println("1");
                }
            } else if (A == 7) {
                if (!deque.isEmpty()){
                    System.out.println(deque.peekFirst());
                } else {
                    System.out.println("-1");
                }
            } else if (A == 8) {
                if (!deque.isEmpty()){
                    System.out.println(deque.peekLast());
                } else {
                    System.out.println("-1");
                }
            }
        }
    }
}
