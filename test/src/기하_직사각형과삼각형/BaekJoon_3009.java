package 기하_직사각형과삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A[][] = new int[3][2];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        int x, y;

        if (A[0][0] == A[1][0]) {
            x = A[2][0];
        } else if (A[0][0] == A[2][0]) {
            x = A[1][0];
        } else {
            x = A[0][0];
        }

        if (A[0][1] == A[1][1]) {
            y = A[2][1];
        } else if (A[0][1] == A[2][1]) {
            y = A[1][1];
        } else {
            y = A[0][1];
        }
        System.out.println(x + " " + y);
    }
}
