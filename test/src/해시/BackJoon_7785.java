package 해시;

import java.util.HashMap;
import java.util.Scanner;

public class BackJoon_7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> employee = new HashMap<>();

        int N = sc.nextInt(); // 직원 수
        sc.nextLine(); // 개행 문자 제거

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine(); // 전체 입력을 한 줄로 받음
            String[] parts = input.split(" "); // 이름과 상태를 나눔
            String name = parts[0];
            String action = parts[1]; // "enter" 또는 "leave"

            // 직원의 상태에 따라 HashMap에 추가하거나 제거
            if (action.equals("enter")) {
                employee.put(name, action); // 직원이 들어오면 HashMap에 추가
            } else if (action.equals("leave")) {
                employee.remove(name); // 직원이 나가면 HashMap에서 제거
            }
        }

        // 현재 사무실에 남아 있는 직원의 이름을 출력
        employee.keySet().stream()
                .sorted((a, b) -> b.compareTo(a)) // 사전 역순으로 정렬
                .forEach(System.out::println); // 직원 이름 출력

        sc.close(); // Scanner 자원 해제
    }
}
