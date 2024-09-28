package 심화1;

import java.util.Scanner;

public class BaekJoon_3003 {
    public static void main(String[] args) {
        int king = 1;
        int queen = 1;
        int look = 2;
        int bishop = 2;
        int night = 2;
        int phone = 8;

        Scanner sc = new Scanner(System.in);

        int KING = sc.nextInt();
        int QUEEN = sc.nextInt();
        int LOOK = sc.nextInt();
        int BISHOP = sc.nextInt();
        int NIGHT = sc.nextInt();
        int PHONE = sc.nextInt();

        System.out.print(king - KING + " ");
        System.out.print(queen - QUEEN + " ");
        System.out.print(look - LOOK + " ");
        System.out.print(bishop - BISHOP + " ");
        System.out.print(night - NIGHT + " ");
        System.out.print(phone - PHONE + " ");
    }
}
