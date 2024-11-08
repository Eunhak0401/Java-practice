package 대학교_자바;

import java.util.Scanner;

abstract class Calculator {
    public abstract int add(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract double average(int[] a);
}

class GoodCalc extends Calculator {
    @Override
    public int add(int a, int b) { // 추상 메소드 구현
        return a + b;
    }

    @Override
    public int subtract(int a, int b) { // 추상 메소드 구현
        return a - b;
    }

    @Override
    public double average(int[] a) { // 추상 메소드 구현
        double sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum / a.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GoodCalc c = new GoodCalc();

        System.out.println(c.add(sc.nextInt(), sc.nextInt()));
        System.out.println(c.subtract(sc.nextInt(), sc.nextInt()));
        System.out.println(c.average(new int[]{sc.nextInt(), sc.nextInt(),sc.nextInt()}));
    }
}
