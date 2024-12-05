//package dataStrustureInJava;
//
//public class testTreeDL {
//    public static void main(String[] args) {
//        System.out.println("== Node Double Linked ============= (단독 노드) ===");
//        NodeDL mulNodeDL = new NodeDL('*');
//        NodeDL divNodeDL = new NodeDL('/');
//        NodeDL subNodeDL = new NodeDL('-');
//
//        System.out.println("            mulNodeDL: " + mulNodeDL);
//        System.out.println("            divNodeDL: " + divNodeDL);
//
//        System.out.println("-- Tree Double Linked --------- (이진 트리 수동) ---");
//        subNodeDL.setBoth(mulNodeDL, divNodeDL);
//        mulNodeDL.setBoth('3', '2');
//
//        TreeDL subTreeDL = new TreeDL(subNodeDL);
//        System.out.println(subTreeDL);
//        divNodeDL.setBoth('6', '2');
//        System.out.println(subTreeDL);
//
//        System.out.println("    subNodeDL inOrder: " + subTreeDL.inOrderTraversal());
//        System.out.println("             preOrder: " + subTreeDL.preOrderTraversal());
//        System.out.println("            postOrder: " + subTreeDL.postOrderTraversal());
//
//        System.out.println("------------------------------- (이진 트리 자동) ---");
//        TreeDL daelimTreeDL = new TreeDL('G');
//
//        daelimTreeDL.insert(new char [] { 'T', 'e', 'l', 'e', '_', 'C', 'o', 'D', 'e' } );
//        daelimTreeDL.insert(new char [] { '@', 'C', 'O', 'M', 'M', 'O', 'N'           } );
//        daelimTreeDL.insert(new char [] { 'A', 'n', 'y', 'a', 'n', 'g', '#', '1', '2' } );
//
//        System.out.println(daelimTreeDL);
//        System.out.println("          isItem '!' > " + daelimTreeDL.isItem('!'));
//        System.out.println("                 'G' > " + daelimTreeDL.isItem('G'));
//
//        System.out.println(" daelimTreeDL inOrder: " + daelimTreeDL.inOrderTraversal());
//        System.out.println("             preOrder: " + daelimTreeDL.preOrderTraversal());
//        System.out.println("            postOrder: " + daelimTreeDL.postOrderTraversal());
//
//        System.out.println("----------------------------- (insert/erase) ---");
//        daelimTreeDL.insert('P');
//        daelimTreeDL.insert('!');
//        daelimTreeDL.erase('G');
//        daelimTreeDL.erase('_');
//        daelimTreeDL.erase('M');
//        daelimTreeDL.insert('G');
//
//        System.out.println(" (+)P,! (-)G,_,M (+)G: ");
//        System.out.println(daelimTreeDL);
//        System.out.println(" daelimTreeDL inOrder: " + daelimTreeDL.inOrderTraversal());
//
//        System.out.println("-------------------------------------- (cut) ---");
//        daelimTreeDL.cut('O');
//        daelimTreeDL.cutLessThan('2');
//        daelimTreeDL.cutGreaterThan('l');
//        System.out.println(" (cut)tree-O,~2,l~");
//        System.out.println(daelimTreeDL);
//        System.out.println(" daelimTreeDL inOrder: " + daelimTreeDL.inOrderTraversal());
//
//        System.out.println("============================= (Hello world!) ===");
//
//    }
//}
