package dataStrustureInJava;

public class test4BracketsASMD {
    /**
     * starting main(String[] args)
     */
    public static void main(String args[]) {
        System.out.println("== BracketsASMD ==================== inFix / postFix ====");
        String formulaZero  = "(( @*2)/2)+2)";
        String formulaOne   = "(((3*2)/2)+2)";
        String formulaTwo   = "((((3^3)-(6/2))/((4*2)-(8-4)))-2)";

        System.out.println("  formulaOne given " + formulaZero);
        System.out.println("                   " + "is " + (ASMD.isGoodPair(formulaZero) ? "good." : "bad."));
        System.out.println("           inFix > " + ASMD.inFix(formulaZero));
        System.out.println("         postFix > " + ASMD.postFix(formulaZero));
        System.out.println();

        System.out.println("  formulaOne given " + formulaOne);
        System.out.println("                   " + "is " + (ASMD.isGoodPair(formulaOne) ? "good." : "bad."));
        System.out.println("           inFix > " + ASMD.inFix(formulaOne));
        System.out.println("         postFix > " + ASMD.postFix(formulaOne));
        System.out.println();

        System.out.println("  formulaTwo given " + formulaTwo);
        System.out.println("                   " + "is " + (ASMD.isGoodPair(formulaTwo) ? "good." : "bad."));
        System.out.println("           inFix > " + ASMD.inFix(formulaTwo));
        System.out.println("         postFix > " + ASMD.postFix(formulaTwo));

        System.out.println("----------------------------------------- evaluation ----");
//        System.out.println("     formulaZero = " + ASMD.evaluatePostFix(oformulaZer));
        System.out.println("                   -------------------------------------");
//        System.out.println("      formulaOne = " + ASMD.evaluatePostFix(formulaOne));
        System.out.println("                   -------------------------------------");
//        System.out.println("      formulaTwo = " + ASMD.evaluatePostFix(formulaTwo));

        System.out.println("==================================== (Hello World~!) ====");
        System.out.println("==================================== (202430118 이은학) ====");
    }
}
