import java.util.Scanner;

public class Bowling2 {

    public static void main(String[] args) {
        game();
    }

    public static void game() {
        String[][] scoreBoard = new String[10][3]; // 점수판 (10프레임, 3개의 항목)
        String[] extraPoints = new String[10]; // 추가 점수

        for (int i = 0; i < 10; i++) {
            scoreBoard[i][0] = scoreBoard[i][1] = scoreBoard[i][2] = "-";
            extraPoints[i] = "";
        }

        int frameIndex = 0;
        int roll = 0;

        Scanner scanner = new Scanner(System.in);

        while (frameIndex < 10) {
            if (frameIndex == 9) { // 10프레임일 때
                if (roll == 0) {
                    System.out.print("10번째 프레임 첫 번째 점수 입력: ");
                } else if (roll == 1) {
                    System.out.print("10번째 프레임 두 번째 점수 입력: ");
                } else {
                    System.out.print("10번째 프레임 세 번째 점수 입력: ");
                }
            } else { // 1 ~ 9 프레임일 때
                System.out.print("프레임 " + (frameIndex + 1) + " " + (roll == 0 ? "첫 번째" : "두 번째") + " 점수 입력: ");
            }

            String input = scanner.next().trim();

            if (isStrike(input, roll, frameIndex)) {
                handleStrike(scoreBoard, input, frameIndex, roll);
                if (frameIndex == 9) {
                    roll++;
                } else {
                    roll = 0;
                    frameIndex++;
                }
            } else if (isSpare(input, frameIndex, roll)) {
                handleSpare(scoreBoard, input, frameIndex, roll);
                roll = (frameIndex == 9) ? roll + 1 : 0;
                frameIndex = (frameIndex == 9 && roll == 2) ? frameIndex : frameIndex + 1;
            } else if (isNumeric(input)) {
                handleNumeric(scoreBoard, input, frameIndex, roll);
                if (frameIndex == 9 && roll > 1) {
                    if (isValidLastFrame(scoreBoard, frameIndex)) {
                        break;
                    }
                } else {
                    roll = (roll == 1) ? 0 : roll + 1;
                    frameIndex = (roll == 0) ? frameIndex + 1 : frameIndex;
                }
            }

            // 점수판 및 추가 점수 업데이트
            updateExtraPoints(scoreBoard, extraPoints);
            printScoreBoard(scoreBoard, extraPoints);

            // 현재 점수 계산
            int totalScore = calculateScore(scoreBoard, extraPoints);
            System.out.println("현재 점수: " + totalScore);
        }

        // 게임 종료 및 최종 점수 출력
        System.out.println("게임 종료");
        printScoreBoard(scoreBoard, extraPoints);
        int finalScore = calculateScore(scoreBoard, extraPoints);
        System.out.println("최종 점수: " + finalScore);

        scanner.close();
    }

    private static boolean isStrike(String input, int roll, int frameIndex) {
        return input.equals("S") && roll == 0 || (frameIndex == 9 && input.equals("S"));
    }

    private static boolean isSpare(String input, int frameIndex, int roll) {
        return input.equals("P") && (frameIndex != 9 || roll > 0);
    }

    private static boolean isNumeric(String input) {
        return input.equals("-") || input.matches("\\d");
    }

    private static boolean isValidLastFrame(String[][] scoreBoard, int frameIndex) {
        return scoreBoard[frameIndex][0].matches("\\d") && scoreBoard[frameIndex][1].matches("\\d");
    }

    private static void handleStrike(String[][] scoreBoard, String input, int frameIndex, int roll) {
        scoreBoard[frameIndex][roll] = "S";
    }

    private static void handleSpare(String[][] scoreBoard, String input, int frameIndex, int roll) {
        scoreBoard[frameIndex][roll] = "P";
    }

    private static void handleNumeric(String[][] scoreBoard, String input, int frameIndex, int roll) {
        if (input.equals("-")) {
            scoreBoard[frameIndex][roll] = "0";
        } else {
            int score = Integer.parseInt(input);
            if (score >= 1 && score <= 9) {
                scoreBoard[frameIndex][roll] = input;
            } else {
                System.out.println("유효하지 않은 입력입니다. 점수는 1부터 9까지 입력할 수 있습니다. 다시 입력해주세요.");
            }
        }
    }

    public static int calculateScore(String[][] scoreBoard, String[] extraPoints) {
        int totalScore = 0;
        int[] frameScores = new int[10];

        for (int i = 0; i < 10; i++) {
            int frameScore = 0;
            if (scoreBoard[i][0].equals("S")) { // 스트라이크
                frameScore = 10;
                if (i < 9) {
                    String[] nextFrame = scoreBoard[i + 1];
                    if (nextFrame[0].equals("S")) {
                        frameScore += 10;
                        if (i + 2 < 10) {
                            String[] nextNextFrame = scoreBoard[i + 2];
                            frameScore += nextNextFrame[0].equals("S") ? 10 : Integer.parseInt(nextNextFrame[0].replace("-", "0"));
                        } else {
                            frameScore += scoreBoard[9][1].equals("S") ? 10 : Integer.parseInt(scoreBoard[9][1].replace("-", "0"));
                        }
                    } else {
                        frameScore += Integer.parseInt(nextFrame[0].replace("-", "0"));
                        frameScore += nextFrame[1].equals("P") ? 10 - Integer.parseInt(nextFrame[0].replace("-", "0")) : Integer.parseInt(nextFrame[1].replace("-", "0"));
                    }
                } else {
                    frameScore += scoreBoard[i][1].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][1].replace("-", "0"));
                    frameScore += scoreBoard[i][2].equals("P") ? 10 - Integer.parseInt(scoreBoard[i][1].replace("-", "0")) : (scoreBoard[i][2].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][2].replace("-", "0")));
                }
            } else if (scoreBoard[i][1].equals("P")) { // 스페어
                frameScore = 10;
                if (i < 9) {
                    String[] nextFrame = scoreBoard[i + 1];
                    frameScore += nextFrame[0].equals("S") ? 10 : Integer.parseInt(nextFrame[0].replace("-", "0"));
                } else {
                    frameScore += scoreBoard[i][2].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][2].replace("-", "0"));
                }
            } else {
                frameScore = Integer.parseInt(scoreBoard[i][0].replace("-", "0")) + Integer.parseInt(scoreBoard[i][1].replace("-", "0"));
            }
            frameScores[i] = frameScore;
        }

        for (int frameScore : frameScores) {
            totalScore += frameScore;
        }

        return totalScore;
    }

    public static void printScoreBoard(String[][] scoreBoard, String[] extraPoints) {
        for (int i = 0; i < 10; i++) {
            String[] frame = scoreBoard[i];
            if (i == 9) {
                System.out.printf("%2s %2s %2s", frame[0], frame[1], frame[2]);
                System.out.print(" | ");
            } else {
                System.out.printf("%2s %2s", frame[0], frame[1]);
                System.out.print(" | ");
            }
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.printf("%2s", extraPoints[i]);
            System.out.print((i == 9) ? "       | " : "    | ");
        }
        System.out.println();
    }

    public static void updateExtraPoints(String[][] scoreBoard, String[] extraPoints) {
        for (int i = 0; i < 10; i++) {
            if (scoreBoard[i][0].equals("S")) { // 스트라이크
                int[] nextTwoRolls = new int[2];
                if (i < 9) {
                    String[] nextFrame = scoreBoard[i + 1];
                    nextTwoRolls[0] = nextFrame[0].equals("S") ? 10 : Integer.parseInt(nextFrame[0].replace("-", "0"));
                    if (nextFrame[0].equals("S") && i + 2 < 10) {
                        String[] nextNextFrame = scoreBoard[i + 2];
                        nextTwoRolls[1] = nextNextFrame[0].equals("S") ? 10 : Integer.parseInt(nextNextFrame[0].replace("-", "0"));
                    } else {
                        nextTwoRolls[1] = nextFrame[1].equals("S") ? 10 : (nextFrame[1].equals("P") ? 10 - Integer.parseInt(nextFrame[0].replace("-", "0")) : Integer.parseInt(nextFrame[1].replace("-", "0")));
                    }
                } else {
                    nextTwoRolls[0] = scoreBoard[i][1].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][1].replace("-", "0"));
                    nextTwoRolls[1] = scoreBoard[i][2].equals("P") ? 10 - Integer.parseInt(scoreBoard[i][1].replace("-", "0")) : (scoreBoard[i][2].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][2].replace("-", "0")));
                }
                extraPoints[i] = String.valueOf(10 + nextTwoRolls[0] + nextTwoRolls[1]);
            } else if (scoreBoard[i][1].equals("P")) { // 스페어
                if (i < 9) {
                    String[] nextFrame = scoreBoard[i + 1];
                    extraPoints[i] = String.valueOf(10 + (nextFrame[0].equals("S") ? 10 : Integer.parseInt(nextFrame[0].replace("-", "0"))));
                } else {
                    extraPoints[i] = String.valueOf(10 + (scoreBoard[i][2].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][2].replace("-", "0"))));
                }
            } else {
                int frameScore = Integer.parseInt(scoreBoard[i][0].replace("-", "0")) + Integer.parseInt(scoreBoard[i][1].replace("-", "0"));
                extraPoints[i] = String.valueOf(frameScore);
            }
        }
    }
}