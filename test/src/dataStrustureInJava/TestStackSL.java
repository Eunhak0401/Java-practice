package dataStrustureInJava;

public class TestStackSL {
    public static void main(String[] args) {
            final int stackSize = 20;
            final int stackIndent = 15;

            System.out.println("== Stack Single Linked =========================== (생성) ====");
            StackSL stackZero = new StackSL();
            StackSL stackOne = new StackSL(3);
            StackSL stackThree = new StackSL(new char[]{'*', '9', '#'});

            System.out.println("     stackZero " + stackZero.toString(stackSize, stackIndent));
            System.out.println("      stackOne " + stackOne.toString(stackSize, stackIndent));
            System.out.println("    stackThree " + stackThree.toString(stackSize, stackIndent));

            System.out.println("-------------------------------------------------- (push) ---");
            System.out.println("        length " + stackThree.push(" Information") + " data pushed in");
            System.out.println("    stackThree " + stackThree.toString(stackSize, stackIndent));

            System.out.println("        length " + stackThree.push("7 data pushed in"));
            System.out.println("    stackThree " + stackThree.toString(stackSize, stackIndent));

            System.out.println("--------------------------------------------------- (pop) ---");
            System.out.println("          data <" + stackThree.pop() + "> popped out");
            System.out.println("    stackThree " + stackThree.toString(stackSize, stackIndent));

            System.out.println("          data <" + stackThree.pop(12) + "> popped out");
            System.out.println("    stackThree " + stackThree.toString(stackSize, stackIndent));

            System.out.println("          data <" + stackThree.pop(100) + "> popped out");
            System.out.println("    stackThree " + stackThree.toString(stackSize, stackIndent));

            System.out.println("          data <" + stackThree.pop() + "> popped out");
            System.out.println("    stackThree " + stackThree.toString(stackSize, stackIndent));

            System.out.println("========================================= (Hello World~!) ====");

    }
    }

