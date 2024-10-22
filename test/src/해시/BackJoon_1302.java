package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> bookSales = new HashMap<>();

        int b = Integer.parseInt(br.readLine().trim()); // 책의 갯수

        // 책 제목을 입력받고 카운트하기
        for (int i = 0; i < b; i++) {
            String title = br.readLine().trim();
            bookSales.put(title, bookSales.getOrDefault(title, 0) + 1);
        }

        int maxSales = 0;
        List<String> mostSoldBooks = new ArrayList<>();

        // 가장 많이 팔린 책 제목 찾기
        for (Map.Entry<String, Integer> entry : bookSales.entrySet()) {
            String title = entry.getKey();
            int count = entry.getValue();

            if (count > maxSales) {
                maxSales = count;
                mostSoldBooks.clear(); // 새로운 최댓값 발견 시 리스트 초기화
                mostSoldBooks.add(title);
            } else if (count == maxSales) {
                mostSoldBooks.add(title);
            }
        }

        // 사전 순으로 정렬 후 첫 번째 제목 출력
        if (!mostSoldBooks.isEmpty()) {
            Collections.sort(mostSoldBooks);
            System.out.println(mostSoldBooks.get(0));
        }

        br.close(); // BufferedReader 자원 해제
    }
}
