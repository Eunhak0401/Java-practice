package 정렬;

import java.io.*;
import java.util.Arrays;

public class BaekJoon_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        char[] A = input.toCharArray();

        Arrays.sort(A);

        for (int i = A.length - 1; i >= 0; i--) {
            bw.write(A[i]);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
