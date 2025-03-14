package 연결리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 스캐너보다 빠른 속도로 입력받기

        String push = br.readLine(); // 영어 소문자만 입력
        char[] chars = push.toCharArray(); // 입력된 문자를 배열로 변환

        Stack<Integer> rightStack = new Stack<>(); // rightStack making
        Stack<Integer> leftStack = new Stack<>(); // leftStack making

        if (push.equalsIgnoreCase("L")){ //L가 눌린다면
            // 입력된 문자에 왼쪽으로 한 칸 움직이기
        } else if (push.equalsIgnoreCase("D")) { //D가 눌린다면
            // 입력된 문자에 오른쪽으로 한 칸 움직이기
        } else if (push.equalsIgnoreCase("B")) { //B가 눌린다면
            // 커서 왼쪽에 있는 문자 하나 삭제
        } else if (push.equalsIgnoreCase("P")) { //P가 눌린다면
            // P #면 #를 오른쪽에 추가
        } 
    }
}
