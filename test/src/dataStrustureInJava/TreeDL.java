package dataStrustureInJava;

public class TreeDL {
    private NodeDL root;

    TreeDL(){
        this.root = null;
    }
    TreeDL(char data){
        this.root = new NodeDL(data);
    }

    TreeDL(NodeDL root){
        this.root = root;
    }

    public String inOrderTraversal(){
        return root.inOrderTraversal();
    }

    public String preOrderTraversal(){
        return root.preOrderTraversal();
    }

    public String postOrderTraversal(){
        return root.postOrderTraversal();
    }

    /**
     * 2진 트리 구조를 도식화
     * @return 결과 문자열
     */
    public String toString() {
        String flag = " Rooooot --> ";
        String newIndent = "";
        String drawing = "";

        if (root.getLeft() != null) {   // left child
            newIndent = " ".repeat(flag.length()) + ":";
            drawing += toString(newIndent, (NodeDL) root.getLeft());
        }

        drawing += flag + root.getData() + "\n";

        if (root.getRight() != null) {   // right child
            newIndent = " ".repeat(flag.length()) + "|";
            drawing += toString(newIndent, (NodeDL) root.getRight());
        }

        return drawing.substring(0, drawing.length() - 1);
    }

    /**
     * 2진 트리 구조를 도식화
     * @param indent 왼쪽 채우기 문자열
     * @param head 2진 트리
     * @return 결과 문자열
     */
    private String toString(String indent, NodeDL head) {
        if (head == null) return "";

        String drawing = "";
        String newIndent = "";

        newIndent = indent + "   :";
        if (head.getLeft() != null)
            drawing += toString(newIndent.replace(":   :", "    :"), (NodeDL)head.getLeft());
        else
            drawing += toString(newIndent,   (NodeDL)                                          head.getLeft());

        newIndent = indent.substring(0, indent.length() - 1).replaceAll(":", "|");
        drawing += newIndent + "+---" + head.getData() + "\n";

        newIndent = indent + "   |";
        if (head.getRight() != null)
            drawing += toString(newIndent.replace("|   |", "    |"), (NodeDL) head.getRight());
        else
            drawing += toString(newIndent,                      (NodeDL) head.getRight());

        return drawing;
    }
}
