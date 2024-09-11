import java.util.Scanner;
import java.util.Arrays;  // Arrays 클래스 사용을 위해 임포트

public class Gifts {

    private static String[] friends = new String[10]; // 친구 이름을 저장할 배열
    private static String[] gifts = new String[2];  // 선물을 받을 친구 두 명을 저장할 배열

    // 친구 입력 함수
    public static void Get_friends() {
        Scanner scanner = new Scanner(System.in);
        String input = ""; // 사용자 입력을 저장할 변수
        int friendCount = 0; // 배열에 저장된 친구 수를 추적하는 변수

        while (!input.equals("stop")) { // "stop"을 입력할 때까지 반복
            System.out.print("친구 이름을 입력하세요 ('stop'를 입력하면 종료): ");
            input = scanner.next(); // 사용자로부터 문자열 입력 받기

            if (input.equals("stop")) { // 입력된 값이 "stop"인 경우
                System.out.println("이제 선물을 주도록하겠습니다 ('stop'를 입력하면 종료)");
            } else { // "stop"이 아닌 경우 친구 이름을 배열에 저장
                friends[friendCount] = input; // friends 배열에 입력된 친구 이름 저장
                friendCount++; // 배열에 저장된 친구 수 증가
            }
        }

        // 친구 목록을 출력
        printFriendsList();

        // 두 명의 친구를 선택하여 gifts 배열에 저장
        selectGiftRecipients(scanner);

        // 친구 선물 목록을 출력
        printGiftsList();

        scanner.close(); // Scanner 리소스 해제
    }

    // 친구 목록 출력 함수
    public static void printFriendsList() {
        System.out.print("친구 목록: ");
        for (String friend : friends) {
            if (friend != null) { // null이 아닌 값만 출력
                System.out.print(friend + " ");
            }
        }
        System.out.println(); // 줄 바꿈
    }

    // 선물 주고받은 목록 표시
    public static void printGiftsList() {
        System.out.print("친구 선물 목록: ");
        for (String gift : gifts) {
            if (gift != null) { // null이 아닌 값만 출력
                System.out.print(gift + " ");
            }
        }
        System.out.println(); // 줄 바꿈
    }


    // 선물 받을 친구 두 명 선택 함수

    public static void selectGiftRecipients(Scanner scanner) {
        String input = "";

        System.out.println("위 친구 목록에서 두 명의 이름을 입력하세요");

        // 첫 번째 친구 선택
        System.out.print("첫 번째 친구 이름: ");
        String firstFriend = scanner.next();
        gifts[0] = firstFriend; // gifts 배열에 첫 번째 친구 저장

        // 두 번째 친구 선택
        System.out.print("두 번째 친구 이름: ");
        String secondFriend = scanner.next();
        gifts[1] = secondFriend; // gifts 배열에 두 번째 친구 저장

    }
    

    public static void gift_Calculation(){

    }

    // 메인 메서드
    public static void main(String[] args) {
        Get_friends(); // 점수 계산 함수 호출
    }
}
