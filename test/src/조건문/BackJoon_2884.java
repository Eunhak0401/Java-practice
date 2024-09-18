package 조건문;

import java.util.Scanner;

public class BackJoon_2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt(); //시
        int M = sc.nextInt(); //분
        M -= 45;

        if(M < 0){
            M += 60;
            if (H == 0){
                H += 24;
            }
            if(H != 0){
                H -= 1;
            }
        }
        System.out.print(H);
        System.out.print(" ");
        System.out.print(M);
    }
}
