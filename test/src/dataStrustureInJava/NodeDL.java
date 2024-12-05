//package dataStrustureInJava;
//
//public class NodeDL extends NodeSL{
//    private NodeDL left;
//
//    public NodeDL(char data){this.setData(data);}
//    public NodeSL getLeft(){return this.left;}
//    public void setData(char data){this.data = data;}
//    public void setLeft(NodeDL left) {this.left = left;}
//
//    public void setBoth(char left, char right){
//        this.setLeft(new NodeDL(left));
//        this.setRight(new NodeDL(right));
//    }
//
//    public void setBoth(NodeDL left, NodeDL rigth){
//        this.setLeft(left);
//        this.setRight(rigth);
//    }
//
//    public String inOrderTraversal() {
//        String buff = "";
//
//        if (this.getData() != '\0') {
//            if (this.getLeft() != null)
//                buff += ((NodeDL) this.getLeft()).inOrderTraversal();
//
//            buff += this.getData();
//
//            if (this.getRight() != null)
//                buff += ((NodeDL) this.getRight()).inOrderTraversal();
//        }
//        return buff;
//    }
//
//    public String preOrderTraversal() {
//        String buff = "";
//
//        if (this.getData() != '\0') {
//            buff += this.getData();
//            if (this.getLeft() != null) buff += ((NodeDL) this.getLeft()).preOrderTraversal();
//            if (this.getRight() != null) buff += ((NodeDL) this.getRight()).preOrderTraversal();
//        }
//        return buff;
//    }
//
//    public String postOrderTraversal() {
//        String buff = "";
//
//        if (this.getData() != '\0') {
//            if (this.getLeft() != null)
//                buff += ((NodeDL) this.getLeft()).postOrderTraversal();
//            if (this.getRight() != null)
//                buff += ((NodeDL) this.getRight()).postOrderTraversal();
//            buff += this.getData();
//        }
//        return buff;
//    }
//}
