package dataStrustureInJava;

public class NodeSL {
    private char data = '\0';
    NodeSL right = null;

    NodeSL(char data) {
        this.data = data;
    }

    // getter 모음
    char getData() {
        return this.data;
    }

    public NodeSL getRight() {
        return this.right;
    }

    // setter 모음
    public void setData(char data){
         this.data = data;
    }

    public void setRight(NodeSL right) {
        this.right = right;
    }

    public String toString() {
        return "" + this.getData();
    }
}


