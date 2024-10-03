package dataStrustureInJava;

//public class PolyomialArray {
//    int[] coefficient;
//
//    public PolyomialArray(int[] newPolinomial){
//        coefficient = newPolinomial;
//    }
//
//    public PolyomialArray add(PolyomialArray seconfPoly){
//        int degree = coefficient.length - 1;
//
//        int [] newArray = new int[coefficient.length];
//        for (int i = 0; i < degree + 1; i++) {
//            if (coefficient[i] != 0){
//                newArray[i] = coefficient[i] + seconfPoly.coefficient[i];
//            }
//        }
//        PolyomialArray resultPoly = new PolyomialArray(newArray);
//
//        return resultPoly;
//    }
//    public String toString(){
//        String buff = "";
//
//        int degree = coefficient.length - 1;
//
//        for (int i = 0; i < degree + 1; i++) {
//            if (coefficient[i] != 0){
//                buff += " + " + coefficient[i] + "x" + (degree - i);
//            }
//        }
//
//        buff = buff.replace("x0","");
//        buff = buff.replace("+ -","- ");
//        buff = buff.replace("x1","x");
//        buff = buff.replace(" 1x","  x");
//        buff = buff.substring(3);
//
//        return buff;
//    }
//}
