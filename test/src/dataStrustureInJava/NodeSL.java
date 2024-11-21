package dataStrustureInJava;

public class NodeSL {
    protected char data = '\0';
    protected NodeSL right = null;

    NodeSL() { ; }

    NodeSL(char data) { this.data =  data;}

    // getter 모음
    public char getData() {return this.data;}
    public NodeSL getRight() {return this.right;}

    // setter 모음
    public void setData(char data){this.data = data;}
    public void setRight(NodeSL right) {this.right = right;}

    public String toString() {return "" + this.getData();}
}


