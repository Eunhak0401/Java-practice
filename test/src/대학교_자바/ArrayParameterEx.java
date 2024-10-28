package 대학교_자바;

import java.util.Scanner;

public class ArrayParameterEx {
    static void replaceSpace(char a[]) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == ' ')
                a[i] = ',';
    }
    static void printCharArray(char a[]) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]);
        System.out.println();
    }

    static void seek(char a[], char target) {
        int count = 0;
        for (char c : a) {
            if (c == target) {
                count++; // 문자가 일치할 경우 카운트 증가
            }
        }
        System.out.println(target + ": " + count + "번 저장됨");
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        char c[] = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.'};
        printCharArray(c);
        replaceSpace(c);
        printCharArray(c);

        System.out.print("찾고 싶은 문자를 입력하세요: ");
        char target = scanner.next().charAt(0);

        seek(c, target); // 입력받은 문자 출력

        scanner.close();
    }
}

