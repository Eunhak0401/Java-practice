//package dataStrustureInJava;
//
//class testPolynomialArrays {
//    /**
//     * starting program main(String[] args)
//     */
//    public static void main(String [] args) {
//
//        //------------------------------ 2  3  1  0  9  8  7  6  5  4  3  2  1  0 //
//        int [] intArray1  = new int [] {                         0, 0, 0, 0, 1, 1 };
//        int [] intArray2  = new int [] {                         0, 0, 0, 1, 0, 0 };
//        int [] intArray3  = new int [] {                              -1, 1, 0, 0 };
//        int [] intArray5  = new int [] {                        -6, 0, 0, 0,-2,11 };
//        int [] intArray11 = new int [] {      -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//
//        PolynomialArray f0  = new PolynomialArray();
//        PolynomialArray f1  = new PolynomialArray(intArray1);
//        PolynomialArray f2  = new PolynomialArray(intArray2);
//        PolynomialArray f3  = new PolynomialArray(intArray3);
//        PolynomialArray f5  = new PolynomialArray(intArray5);
//        PolynomialArray f11 = new PolynomialArray(intArray11);
//
//        System.out.println("== Polynomial Array =========== (기본 생성자) ====");
//        System.out.println("          f0(x) = " + f0);
//
//        System.out.println("-------------------------------------- (단항) ----");
//        System.out.println("          f2(x) = " + f2);
//        System.out.println("         f11(x) = " + f11);
//
//        System.out.println("-------------------------------------- (다항) ----");
//        System.out.println("          f1(x) = " + f1);
//        System.out.println("          f3(x) = " + f3);
//        System.out.println("          f5(x) = " + f5);
//        System.out.println("         -f5(x) = " + f5.neg());
//
//        System.out.println("-------------------------------------- (덧셈) ----");
//        System.out.println(" f3(x) +  f3(x) = " + f3.add(f3));
//        System.out.println(" f3(x) +  f5(x) = " + f3.add(f5));
//        System.out.println(" f3(x) + -f5(x) = " + f3.add(f5.neg()));
//        System.out.println("-f5(x) +  f3(x) = " + f5.neg().add(f3));
//
//        System.out.println("-------------------------------------- (뺄셈) ----");
//        System.out.println(" f3(x) -  f3(x) = " + f3.sub(f3));
//        System.out.println(" f3(x) -  f5(x) = " + f3.sub(f5));
//
//        System.out.println("-------------------------------------- (곱셈) ----");
//        System.out.println(" f1(x) *  f1(x) = " + f1.mul(f1));
//        System.out.println(" f1(x) *  f3(x) = " + f1.mul(f3));
//        System.out.println(" f1(x) * -f3(x) = " + f1.mul(f3.neg()));
//        System.out.println(" f3(x) *  f5(x) = " + f3.mul(f5));
//
//        System.out.println("--------------------------------- (미분 적분) ----");
//        System.out.println("         df5(x) = " + f5.differential());
//        System.out.println("        idf5(x) = " + f5.differential().integral());
//
//        System.out.println("--------------------------- (Hello World~!) ----");
//    }
//}
