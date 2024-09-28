package 대학교_자바;

public class for_0927_5 {
    public static void main(String[] args) {
        int n = 5;  // 총 5줄 출력

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
