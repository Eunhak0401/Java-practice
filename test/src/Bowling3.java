import java.util.Scanner;

public class Bowling3 {
    public static void main(String[] args) {
        game();
    }

    public static void game() {
        public static void get_score() {  // 점수 얻는 함수 (추가 점수까지)
            // 이제 점수를 입력받으면 리스트안에 입력되도록
            // 총 10프레임까지 만약 10프레임 첫 번째 roll에 10점이라면 보너스 프레임 하나 더 추가
            // 첫 roll에 10이면 스트라이크! 출력과 함께 다음 2개의 roll를 추가 점수로 기입
            // 두 roll 합이 10이면 스페어! 출력과 함께 다음 1개의 roll를 추가 점수로 기입
        String [][] roll = new String[10][2]; // roll이 총 10프레임과 2개의 칸
        String [] score = new String[10]; // 점수는 총 10프레임

        Scanner scanner = new Scanner(System.in);
        
        }
        public static void Score_calculation() { //점수 계산 함수
            // 프레임 마다 점수가 나오게끔.
            // 추가 점수가 나오면 각 프레임 점수가 갱신 되도록.
        }
        public static void score_board() { // 스코어 보드 판 ( 첫 줄은 Frame 두 번째 줄은 roll 세 번째 줄은 Score )
            System.out.println("# ---------------------------------------------------"); // 첫 번째 줄

            System.out.println("# ---------------------------------------------------"); // 두 번째 줄

            System.out.println("# ---------------------------------------------------"); // 세 번째 줄

            System.out.println("# ---------------------------------------------------"); // 네 번째 줄

        }
    }
}

