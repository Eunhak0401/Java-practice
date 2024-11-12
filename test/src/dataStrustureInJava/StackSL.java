package dataStrustureInJava;

public class StackSL {
    private NodeSL top;

    public StackSL() {
        top = null;
    }

    public StackSL(char data) {
        top = new NodeSL(data);
    }

    public StackSL(int data) {
        top = new NodeSL((char) ('0' + data));
    }

    public StackSL(char[] dataArray) {
        for (int i = 0; i < dataArray.length; i++) {
            push(dataArray[i]);
        }
    }

    // getter
    public NodeSL getTop() {
        return top;
    }

    // setter
    public void setTop(NodeSL top) {
        this.top = top;
    }


    public int push(int data) {
        this.push((char) ('0' + data));
        return 1;
    }

    public int push(char data) {
        NodeSL newNode = new NodeSL(data);
        newNode.setRight(top);
        top = newNode; // top을 새 노드로 업데이트
        return 1; // 푸시 성공
    }

    // 문자열을 하나씩 push
    public int push(String data) {
        int i;
        for (i = 0; i < data.length(); i++) {
            push(data.charAt(i));
        }
        return i;
    }

public String pop(){
        NodeSL myNodeSL = null;
        if (top == null) {
            return null;
        }
        myNodeSL = top;
        top = top.getRight();
        return "" + myNodeSL.getRight();
}

public String pop(int myNum){
        String myString = "";
    for (int i = 0; i < myNum; i++) {
        myString += pop();
        if (isEempy()){
            break;
        }
    }
    return myString;
}

    // 스택의 크기 반환
    public int length() {
        int count = 0;
        NodeSL myTop = this.top;

        while (myTop != null) {
            myTop = myTop.getRight();  // getRight() -> getNext()
            count++;
        }
        return count;
    }

    public boolean isEempy() {
        if (this.top == null){
            return true;
        }else {
            return false;
        }
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
}




