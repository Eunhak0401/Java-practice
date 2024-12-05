//package dataStrustureInJava;
//
//public class TreeDL {
//    private NodeDL root;
//
//    TreeDL(){
//        this.root = null;
//    }
//    TreeDL(char data){
//        this.root = new NodeDL(data);
//    }
//
//    TreeDL(NodeDL root){
//        this.root = root;
//    }
//
//    public String inOrderTraversal(){
//        return root.inOrderTraversal();
//    }
//
//    public String preOrderTraversal(){
//        return root.preOrderTraversal();
//    }
//
//    public String postOrderTraversal(){
//        return root.postOrderTraversal();
//    }
//
//    public void insert(char[] itemArray) {
//        for (int i = 0; i < itemArray.length; i++) {this.insert(itemArray[i]);}
//    }
//
//    public void insert(char data){
//        insert(root,data);
//    }
//
//    public NodeDL insert(NodeDL target, char data) {
//        if (target == null) {
//            return new NodeDL(data);
//        }
//        if (data < target.getData()) target.setLeft(insert((NodeDL) target.getLeft(), data));
//        if (data > target.getData()) target.setRight(insert((NodeDL) target.getRight(), data));
//        if (data == target.getData()) ;
//
//        return target;
//    }
//
//    public NodeDL search(char data){
//        NodeDL target = this.root;
//
//        while (target != null) {
//
//            if      (data < target.getData()) target = (NodeDL) target.getLeft();
//            else if (data > target.getData()) target =(NodeDL) target.getRight();
//            else if (data == target.getData()) break;
//        }
//        return target;
//    }
//
//    public boolean isItem(char data){
//        boolean flag = false;
//
//        if(this.search(data) == null){flag = false;}
//        else                         {flag = true;}
//
//        return flag;
//    }
//
//    public void erase(char trashData) {
//        if (root != null) {
//            root = erase(root, trashData);
//        }
//    }
//
//    public NodeDL erase(NodeDL startNodeDL, char trashData) {
//        if (startNodeDL == null)
//            return null;
//
//        if (trashData < startNodeDL.getData())
//            startNodeDL.setLeft(erase((NodeDL)startNodeDL.getLeft(), trashData));
//        else if (trashData > startNodeDL.getData())
//            startNodeDL.setRight(erase((NodeDL)startNodeDL.getRight(), trashData));
//        else {
//            if (startNodeDL.getLeft() == null)
//                return (NodeDL)startNodeDL.getRight();
//
//            if (startNodeDL.getRight() == null)
//                return (NodeDL)startNodeDL.getLeft();
//
//            startNodeDL.setData(maxValue((NodeDL)startNodeDL.getLeft()));
//            startNodeDL.setLeft(erase((NodeDL)startNodeDL.getLeft(), startNodeDL.getData()));
//        }
//
//        return startNodeDL;
//    }
//
//    private char maxValue(NodeDL node) {
//        char maxv = node.getData();
//        while (node.getRight() != null) {
//            maxv = node.getRight().getData();
//            node = (NodeDL)node.getRight();
//        }
//        return maxv;
//    }
//
//    public void cut(char trashData) {
//        root = cut(root, trashData);
//    }
//
//    private NodeDL cut(NodeDL node, char trashData) {
//        if (node == null) return null;
//
//        if (node.getData() == trashData) {
//            return null; // trashData 노드를 삭제
//        } else if (node.getData() < trashData) {
//            node.setRight(cut((NodeDL)node.getRight(), trashData));
//        } else {
//            node.setLeft(cut((NodeDL)node.getLeft(), trashData));
//        }
//        return node;
//    }
//
//    public void cutLessThan(char limitData) {
//        root = cutLessThan(root, limitData);
//    }
//
//    private NodeDL cutLessThan(NodeDL node, char limitData) {
//        if (node == null) return null;
//
//        if (node.getData() < limitData) {
//            // 현재 노드가 limitData보다 작으면 오른쪽 서브트리만 고려
//            return cutLessThan((NodeDL)node.getRight(), limitData);
//        }
//        // 현재 노드가 limitData 이상이면 왼쪽 서브트리를 재귀적으로 처리
//        node.setLeft(cutLessThan((NodeDL)node.getLeft(), limitData));
//        return node;
//    }
//
//    public void cutGreaterThan(char limitData) {
//        root = cutGreaterThan(root, limitData);
//    }
//
//    private NodeDL cutGreaterThan(NodeDL node, char limitData) {
//        if (node == null) return null;
//
//        if (node.getData() > limitData) {
//            // 현재 노드가 limitData보다 크면 왼쪽 서브트리만 고려
//            return cutGreaterThan((NodeDL)node.getLeft(), limitData);
//        }
//        // 현재 노드가 limitData 이하이면 오른쪽 서브트리를 재귀적으로 처리
//        node.setRight(cutGreaterThan((NodeDL)node.getRight(), limitData));
//        return node;
//    }
//
//
//    /**
//     * 2진 트리 구조를 도식화
//     * @return 결과 문자열
//     */
//    public String toString() {
//        String flag = " Rooooot --> ";
//        String newIndent = "";
//        String drawing = "";
//
//        if (root.getLeft() != null) {   // left child
//            newIndent = " ".repeat(flag.length()) + ":";
//            drawing += toString(newIndent, (NodeDL) root.getLeft());
//        }
//
//        drawing += flag + root.getData() + "\n";
//
//        if (root.getRight() != null) {   // right child
//            newIndent = " ".repeat(flag.length()) + "|";
//            drawing += toString(newIndent, (NodeDL) root.getRight());
//        }
//
//        return drawing.substring(0, drawing.length() - 1);
//    }
//
//    /**
//     * 2진 트리 구조를 도식화
//     * @param indent 왼쪽 채우기 문자열
//     * @param head 2진 트리
//     * @return 결과 문자열
//     */
//    private String toString(String indent, NodeDL head) {
//        if (head == null) return "";
//
//        String drawing = "";
//        String newIndent = "";
//
//        newIndent = indent + "   :";
//        if (head.getLeft() != null)
//            drawing += toString(newIndent.replace(":   :", "    :"), (NodeDL)head.getLeft());
//        else
//            drawing += toString(newIndent,   (NodeDL)                                          head.getLeft());
//
//        newIndent = indent.substring(0, indent.length() - 1).replaceAll(":", "|");
//        drawing += newIndent + "+---" + head.getData() + "\n";
//
//        newIndent = indent + "   |";
//        if (head.getRight() != null)
//            drawing += toString(newIndent.replace("|   |", "    |"), (NodeDL) head.getRight());
//        else
//            drawing += toString(newIndent,                      (NodeDL) head.getRight());
//
//        return drawing;
//    }
//}
