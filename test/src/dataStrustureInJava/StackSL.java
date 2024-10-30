package dataStrustureInJava;

public class StackSL {
    private NodeSL top;


    public StackSL() {
        top = null;
    }

    public StackSL(char data){
        top = new NodeSL(data);
    }

    public StackSL(int data){
        top = new NodeSL((char) ('0' + data));
    }

    public StackSL(char[] dataArray){
        for (int i = 0; i < dataArray.length; i++) {
            push(dataArray[i]);
        }
    }

    // getter
    public NodeSL getTop(){
        return top;
    }

    // setter
    public void setTop(NodeSL top){
        this.top = top;
    }


    public void push(char data) {
        NodeSL newNodeSL = new NodeSL(data);
        newNodeSL.setRight(top);
        top = newNodeSL;
    }

    public int push(int data) {
        this.push((char) ('0' + data));
        return 1;
    }

    public int push(String data){
        int i;

        for (i = 0; i < data.length(); i++) {
            push(data.charAt(i));
        }
        return i;
    }

    public String pop(int myNum) {
        String myString = "";
        for (int i = 0; i < myNum; i++) {
            myString += pop();
            if(isEempy()){
                break;
            }
        }

        return myString;
    }

    public String pop() {
        NodeSL myNodeSl = null;

        if (top == null) {
            return null;
        } else {
            myNodeSl = top;
            top = top.getRight();
        }

        return "" + myNodeSl.getData();

    }
    public int length() {
        int count = 0;
        NodeSL mytop = this.top;

        while (mytop != null) {
            mytop = mytop.getRight();
            count++;
        }

        return count;
    }

    /**
     * 객체를 문자열로 변환
     * @param stackSize 스택이 저장할 수 있는 정보의 갯수
     * @param indent 화면 출력에서 들여쓰기 크기
     * @return 스택을 설명하는 문자열
     */
    public String toString(int stackSize, int indent) {
        String wall = "-+".repeat(stackSize);
        String buffLayer = "";

        if (this.isEempy())
            buffLayer = " |".repeat(stackSize - 4) + "(empty)|";
        else {
            NodeSL currNodeSL = this.top;

            int count = 0;
            while (currNodeSL != null) {
                buffLayer += currNodeSL + "|";
                currNodeSL = currNodeSL.getRight();
                count++;
            }
            buffLayer = " |".repeat(stackSize - count) + buffLayer;
        }

        String resultString = "";

        resultString +=                      "---+" + wall      + "\n";
        resultString += " ".repeat(indent) + "<=>|" + buffLayer + "\n";
        resultString += " ".repeat(indent) + "---+" + wall;

        return resultString;
    }

    public boolean isEempy() {
        if (this.top == null){
            return true;
        }else {
            return false;
        }
    }
}




