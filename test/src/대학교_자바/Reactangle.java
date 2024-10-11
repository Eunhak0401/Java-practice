package 대학교_자바;

import java.util.Scanner;

public class Reactangle {
    int width;
    int height;

    public int getArea(){
        return width*height;
    }

    public static void main(String[] args) {
        Reactangle rect = new Reactangle();
        Scanner sc = new Scanner(System.in);
        System.out.print(">> ");

        rect.height = sc.nextInt();
        rect.width = sc.nextInt();

        System.out.println("사각형의 면적은: " + rect.getArea());

        sc.close();
    }
}
