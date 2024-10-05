package 대학교_자바;

import java.util.Scanner;

public class Array_0927_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int intArray[] = new int[5];

        int max = 0;
        int index = 0;
        System.out.println("양수 5개를 입력하세요");
        for (int i = 0; i < 5; i++) {
            intArray[i] = sc.nextInt();
            if (intArray[i] > max){
                max = intArray[i];
                index = i;
            }
        }
        System.out.println("가장 큰 수는 " + max + "입니다");
        System.out.println(max + "은 " + (index+ 1) + "번째에 있습니다.");

        sc.close();
    }
}
