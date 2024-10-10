import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_4101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            String input = br.readLine();
            String[] values = input.split(" ");

            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);

            if (a == 0 && b == 0){
                break;
            }

            if (a > b){
                sb.append("Yes\n");
            } else if (b > a) {
                sb.append("No\n");
            } else if (b == a) {
                sb.append("No\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
