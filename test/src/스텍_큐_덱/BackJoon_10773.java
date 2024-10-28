package 스텍_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BackJoon_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        Stack<Integer> zero = new Stack<>();

        for (int i = 0; i < a; i++) {
            int b = Integer.parseInt(br.readLine());

            if (b == 0 && !zero.isEmpty()) { // 0이 들어오면 직전 값을 제거
                zero.pop();
            } else {
                zero.push(b); // 0이 아니면 스택에 숫자 추가
            }
        }

        // 스택에 남아있는 값들을 모두 더함
        int sum = 0;
        for (int num : zero) {
            sum += num;
        }

        System.out.println(sum); // 결과 출력
    }
}
