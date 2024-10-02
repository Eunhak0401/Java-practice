package 정렬;

import java.io.*;
import java.util.Arrays;

public class BaekJoon_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int[] A = new int[a];

        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        for (int i = 0; i < a; i++) {
            bw.write(A[i] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
