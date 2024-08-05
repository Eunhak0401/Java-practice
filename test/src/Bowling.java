import java.util.Scanner;

public class Bowling {

    private static int[][] scoreBoard = new int[10][3]; // 10프레임까지 점수를 저장할 배열 (각 프레임에 대해 3개의 롤)
    private static int[] framescores = new int[10]; // 각 프레임의 점수를 저장할 배열

    // 게임을 시작하는 메서드
    public static void game() {
        get_score();
    }

    // 점수 입력 및 계산을 위한 메서드
    public static void get_score() {
        Scanner scanner = new Scanner(System.in);
        int frame = 0;

        while (frame < 10) { // 10프레임까지 반복
            System.out.print("프레임 " + (frame + 1) + " 첫 번째 점수 입력: ");
            int firstRoll = scanner.nextInt();
            if (firstRoll < 0 || firstRoll > 10) {
                System.out.println("잘못된 입력입니다. 0과 10 사이의 값을 입력하세요.");
                continue;
            }

            if (firstRoll == 10) { // 스트라이크인 경우
                scoreBoard[frame][0] = 10;
                scoreBoard[frame][1] = 0; // 두 번째 roll은 필요없음
                System.out.println("스트라이크!");

                if (frame == 9) { // 10프레임에서 추가 롤 입력
                    System.out.print("10프레임 보너스 첫 번째 점수 입력: ");
                    scoreBoard[frame][1] = scanner.nextInt();
                    if (scoreBoard[frame][1] < 0 || scoreBoard[frame][1] > 10) {
                        System.out.println("잘못된 입력입니다. 0과 10 사이의 값을 입력하세요.");
                        continue;
                    }

                    System.out.print("10프레임 보너스 두 번째 점수 입력: ");
                    scoreBoard[frame][2] = scanner.nextInt();
                    if (scoreBoard[frame][2] < 0 || scoreBoard[frame][2] > 10) {
                        System.out.println("잘못된 입력입니다. 0과 10 사이의 값을 입력하세요.");
                        continue;
                    }
                }
            } else { // 스트라이크가 아닌 경우
                System.out.print("프레임 " + (frame + 1) + " 두 번째 점수 입력: ");
                int secondRoll = scanner.nextInt();
                if (secondRoll < 0 || secondRoll + firstRoll > 10) {
                    System.out.println("잘못된 입력입니다. 첫 번째 점수와 합쳐서 10을 넘지 않도록 입력하세요.");
                    continue;
                }

                if (firstRoll + secondRoll == 10) { // 스페어인 경우
                    scoreBoard[frame][0] = firstRoll;
                    scoreBoard[frame][1] = secondRoll;
                    System.out.println("스페어!");

                    if (frame == 9) { // 10프레임에서 스페어인 경우
                        System.out.print("10프레임 보너스 첫 번째 점수 입력: ");
                        scoreBoard[frame][2] = scanner.nextInt();
                        if (scoreBoard[frame][2] < 0 || scoreBoard[frame][2] > 10) {
                            System.out.println("잘못된 입력입니다. 0과 10 사이의 값을 입력하세요.");
                            continue;
                        }
                    }
                } else { // 일반적인 경우
                    scoreBoard[frame][0] = firstRoll;
                    scoreBoard[frame][1] = secondRoll;
                }
            }

            // 점수 계산
            int totalScore = 0;
            for (int i = 0; i < 10; i++) {
                int frameScore = scoreBoard[i][0] + scoreBoard[i][1];
                if (i == 9) { // 10프레임의 경우
                    frameScore += scoreBoard[i][2]; // 10프레임의 세 번째 롤 추가
                } else if (scoreBoard[i][0] == 10) { // 스트라이크
                    frameScore += getStrikeBonus(scoreBoard, i);
                } else if (scoreBoard[i][0] + scoreBoard[i][1] == 10) { // 스페어
                    frameScore += getSpareBonus(scoreBoard, i);
                }
                totalScore += frameScore;
                framescores[i] = totalScore; // 누적 점수 저장
            }

            // 현재까지의 스코어 보드 출력
            score_board();

            frame++;
        }
    }

    // 스트라이크 보너스 점수 계산
    private static int getStrikeBonus(int[][] scoreBoard, int currentFrame) {
        int bonus = 0;
        if (currentFrame == 9) { // 10프레임에서 스트라이크인 경우
            bonus += scoreBoard[currentFrame][1] + scoreBoard[currentFrame][2];
        } else if (currentFrame + 1 < 10) {
            bonus += scoreBoard[currentFrame + 1][0]; // 다음 프레임 첫 번째 roll
            if (scoreBoard[currentFrame + 1][0] == 10 && currentFrame + 2 < 10) {
                bonus += scoreBoard[currentFrame + 2][0]; // 다음 다음 프레임 첫 번째 roll
            } else {
                bonus += scoreBoard[currentFrame + 1][1]; // 다음 프레임 두 번째 roll
            }
        }
        return bonus;
    }

    // 스페어 보너스 점수 계산
    private static int getSpareBonus(int[][] scoreBoard, int currentFrame) {
        int bonus = 0;
        if (currentFrame == 9) { // 10프레임에서 스페어인 경우
            bonus += scoreBoard[currentFrame][2];
        } else if (currentFrame + 1 < 10) {
            bonus += scoreBoard[currentFrame + 1][0]; // 다음 프레임 첫 번째 roll
        }
        return bonus;
    }

    // 스코어 보드 판을 출력하는 메서드
    public static void score_board() {
        System.out.println("# -------------------------------------------------------------------------------------------"); // 첫 번째 줄

        // 프레임 헤더
        System.out.print("# Frame  ");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("|   %d   ", i);
        }
        System.out.println("   |");

        System.out.println("# -------------------------------------------------------------------------------------------"); // 두 번째 줄

        // 롤 헤더
        System.out.print("# Rolls  ");
        for (int i = 0; i < 10; i++) {
            // 첫 번째 롤
            String roll1 = (scoreBoard[i][0] == 10) ? "S" : String.format("%s", (scoreBoard[i][0] == 0 ? " " : scoreBoard[i][0]));
            // 두 번째 롤
            String roll2 = (i == 9 && (scoreBoard[i][0] == 10 || scoreBoard[i][0] + scoreBoard[i][1] == 10))
                    ? String.format("%s", (scoreBoard[i][1] == 0 ? " " : scoreBoard[i][1])) : (scoreBoard[i][1] == 0 && scoreBoard[i][0] != 10) ? "  " : String.format("%2s", (scoreBoard[i][1] == 0 ? " " : scoreBoard[i][1]));
            // 세 번째 롤 (마지막 프레임에만)
            String roll3 = (i == 9 && (scoreBoard[i][0] == 10 || scoreBoard[i][0] + scoreBoard[i][1] == 10))
                    ? String.format("%s", (scoreBoard[i][2] == 0 ? " " : scoreBoard[i][2])) : "  ";
            if (i < 9) {
                System.out.printf("| %s | %s", roll1, roll2);
            } else {
                System.out.printf("| %s | %s| %s", roll1, roll2, roll3);
            }
        }
        System.out.println("|");

        System.out.println("# -----------------------------------------------------------------------------------------------"); // 세 번째 줄

        // 점수 헤더
        System.out.print("# Score  ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("|  %3d  ", framescores[i]); // 점수를 4자리로 맞춤
        }
        System.out.println("    |");

        System.out.println("# -----------------------------------------------------------------------------------------------"); // 네 번째 줄
    }

    public static void main(String[] args) {
        game();
    }
}