package 대학교_자바;

import java.util.Scanner;

public class for_0927_1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int count = 0;

        int a = sc.nextInt();

        for (int i = 1; i < a; i++) {
            if (i % 3 == 0){
                System.out.println("3의 배수는 " + i);
                count++;
            }
        }
        System.out.println("3의 배수의 수는 총 " + count + "개");
    }
}
