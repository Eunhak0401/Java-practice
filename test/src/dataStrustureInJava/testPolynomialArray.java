package dataStrustureInJava;

public class testPolynomialArray {
    public static void main(String[] args) {
        int[] firstEqution = new int[] {0,0,0,0,0,0,3,7,0,1,-6};
        int[] second       = new int[] {0,0,0,0,0,0,0,0,0,0, 5};

        PolyomialArray myPolinomial1 = new PolyomialArray(firstEqution);
        PolyomialArray myPolinomial2 = new PolyomialArray(second);
        System.out.println("              f1(x) = " + myPolinomial1);
        System.out.println("              f1(x) = " + myPolinomial2);

        int[] thirh        = new int[] {1,1,1};
        PolyomialArray myPolinomial3 = new PolyomialArray(thirh);
        System.out.println("              f1(x) = " + myPolinomial3);

        PolyomialArray myPolinomial4 = myPolinomial1.add(myPolinomial2);
        System.out.println(" f4(x) = f(1) + f(2) = " + myPolinomial4);
     }
}
