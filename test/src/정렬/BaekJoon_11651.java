package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int[][] A = new int[a][2];

        for (int i = 0; i < a; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, (e1, e2) -> {
            if (e1[1] != e2[1]) {
                return Integer.compare(e1[1], e2[1]);
            } else {
                return Integer.compare(e1[0], e2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            sb.append(A[i][0] +  " " + A[i][1]).append('\n');
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
