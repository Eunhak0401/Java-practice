import java.util.Scanner;

public class Bowling {

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

            // 입력 검증 및 점수 기록
            if (input.equals("S") && roll == 0) { // 스트라이크, 첫 번째 점수라면
                scoreBoard[frameIndex][roll] = "S";
                if (frameIndex == 9) { // 10번째 프레임
                    roll++;
                } else {
                    roll = 0;
                    frameIndex++;
                }
            } else if (frameIndex == 9 && input.equals("S") && roll > 0) { // 10프레임에서 스트라이크
                scoreBoard[frameIndex][roll] = "S";
                roll++;
            } else if (frameIndex == 9 && input.equals("P") && roll > 0) { // 10프레임에서 스페어
                if (roll == 1 && scoreBoard[frameIndex][0].equals("S")) {
                    System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
                    continue;
                }
                scoreBoard[frameIndex][roll] = "P";
                roll++;
            } else if (input.equals("P") && roll == 1 && !scoreBoard[frameIndex][0].equals("S")) { // P, 두 번째 자리가 1이라면
                scoreBoard[frameIndex][roll] = "P";
                roll = 0;
                frameIndex++;
            } else if (input.equals("-") || input.matches("\\d")) { // '-' 또는 숫자일 때
                if (input.equals("-")) {
                    scoreBoard[frameIndex][roll] = "0";
                } else {
                    int score = Integer.parseInt(input);
                    if (score >= 1 && score <= 9) {
                        scoreBoard[frameIndex][roll] = input;
                    } else {
                        System.out.println("유효하지 않은 입력입니다. 점수는 1부터 9까지 입력할 수 있습니다. 다시 입력해주세요.");
                        continue;
                    }
                }

                if (frameIndex == 9) { // 10프레임일 때
                    roll++;
                    if (roll > 1) { // 10프레임에서 두 번째 점수를 입력한 후
                        if (scoreBoard[frameIndex][0].matches("\\d") && scoreBoard[frameIndex][1].matches("\\d")) {
                            break;
                        } else if (scoreBoard[frameIndex][0].matches("\\d") && scoreBoard[frameIndex][1].equals("S")) {
                            System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
                            continue;
                        }
                    }
                } else {
                    if (roll == 1) { // 두 번째 점수 입력 후
                        if (scoreBoard[frameIndex][0].matches("\\d")) {
                            int firstScore = Integer.parseInt(scoreBoard[frameIndex][0]);
                            int secondScore = Integer.parseInt(scoreBoard[frameIndex][1]);
                            if (firstScore + secondScore > 10) {
                                System.out.println("두 점수의 합이 10점을 초과합니다. 다시 입력해주세요.");
                                continue;
                            }
                        }
                        roll = 0;
                        frameIndex++;
                    } else if (roll == 0 && scoreBoard[frameIndex][0].equals("S")) {
                        roll = 0;
                        frameIndex++;
                    } else {
                        roll++;
                    }
                }
            }

            // 점수판 및 추가 점수 업데이트
            updateExtraPoints(scoreBoard, extraPoints);
            printScoreBoard(scoreBoard, extraPoints);

            // 현재 점수 계산
            int totalScore = calculateScore(scoreBoard, extraPoints);
            System.out.println("현재 점수: " + totalScore);

            // 10프레임에서 세 번째 점수를 입력한 후 게임 종료
            if (frameIndex == 9 && roll == 3) {
                break;
            }
        }

        // 출력
        System.out.println("게임 종료");
        printScoreBoard(scoreBoard, extraPoints);
        int finalScore = calculateScore(scoreBoard, extraPoints);
        System.out.println("최종 점수: " + finalScore);

        scanner.close();
    }

    public static int calculateScore(String[][] scoreBoard, String[] extraPoints) { // 점수 계산
        int totalScore = 0;
        int[] frameScores = new int[10]; // 각 프레임의 점수 저장 리스트

        for (int i = 0; i < 10; i++) { // 총 10프레임까지
            int frameScore = 0;
            if (scoreBoard[i][0].equals("S")) { // 스트라이크
                frameScore = 10;
                if (i < 9) {
                    String[] nextFrame = scoreBoard[i + 1];
                    if (nextFrame[0].equals("S")) { // 다음 프레임도 스트라이크
                        frameScore += 10;
                        if (i + 2 < 10) { // 다음 다음 프레임
                            String[] nextNextFrame = scoreBoard[i + 2];
                            frameScore += nextNextFrame[0].equals("S") ? 10 : Integer.parseInt(nextNextFrame[0].replace("-", "0"));
                        } else {
                            frameScore += scoreBoard[9][1].equals("S") ? 10 : Integer.parseInt(scoreBoard[9][1].replace("-", "0"));
                        }
                    } else { // 다음 프레임이 스트라이크가 아니면
                        frameScore += Integer.parseInt(nextFrame[0].replace("-", "0"));
                        if (nextFrame[1].equals("P")) { // 스페어일때
                            frameScore += 10 - Integer.parseInt(nextFrame[0].replace("-", "0"));
                        } else { // 숫자일때
                            frameScore += Integer.parseInt(nextFrame[1].replace("-", "0"));
                        }
                    }
                } else { // 10번째 프레임
                    frameScore += scoreBoard[i][1].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][1].replace("-", "0"));
                    frameScore += scoreBoard[i][2].equals("S") ? 10 : (scoreBoard[i][2].equals("P") ? 10 - Integer.parseInt(scoreBoard[i][1].replace("-", "0")) : Integer.parseInt(scoreBoard[i][2].replace("-", "0")));
                }
            } else if (scoreBoard[i][1].equals("P")) { // 스페어일때
                frameScore = 10;
                if (i < 9) { // 10번째 프레임이 아니면
                    String[] nextFrame = scoreBoard[i + 1];
                    frameScore += nextFrame[0].equals("S") ? 10 : Integer.parseInt(nextFrame[0].replace("-", "0"));
                } else { // 10번째 프레임이면
                    frameScore += scoreBoard[i][2].equals("S") ? 10 : (10 - Integer.parseInt(scoreBoard[i][0].replace("-", "0"))) + (scoreBoard[i][2].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][2].replace("-", "0")));
                }
            } else { // 일반 숫자 프레임
                frameScore = Integer.parseInt(scoreBoard[i][0].replace("-", "0")) + Integer.parseInt(scoreBoard[i][1].replace("-", "0"));
            }
            frameScores[i] = frameScore; // 점수 저장
        }

        for (int frameScore : frameScores) {
            totalScore += frameScore; // 점수 계산
        }

        return totalScore;
    }

    public static void printScoreBoard(String[][] scoreBoard, String[] extraPoints) {
        // 점수판 출력
        for (int i = 0; i < 10; i++) {
            String[] frame = scoreBoard[i];
            if (i == 9) { // 10프레임
                System.out.printf("%2s %2s %2s", frame[0], frame[1], frame[2]);
                System.out.print(" | ");
            } else { // 1 ~ 9프레임
                System.out.printf("%2s %2s", frame[0], frame[1]);
                System.out.print(" | ");
            }
        }
        System.out.println();

        // 추가 점수 출력
        for (int i = 0; i < 10; i++) {
            String extra = extraPoints[i];
            if (i == 9) { // 10프레임
                System.out.printf("%2s", extra);
                System.out.print("       | ");
            } else { // 1~9프레임
                System.out.printf("%2s", extra);
                System.out.print("    | ");
            }
        }
        System.out.println();
    }

    public static void updateExtraPoints(String[][] scoreBoard, String[] extraPoints) {
        for (int i = 0; i < 10; i++) { // 총 10프레임
            if (scoreBoard[i][0].equals("S")) { // 스트라이크
                int[] nextTwoRolls = new int[2];
                if (i < 9) { // 1 ~ 9프레임
                    String[] nextFrame = scoreBoard[i + 1];
                    nextTwoRolls[0] = nextFrame[0].equals("S") ? 10 : Integer.parseInt(nextFrame[0].replace("-", "0"));
                    if (nextFrame[0].equals("S") && i + 2 < 10) {
                        String[] nextNextFrame = scoreBoard[i + 2];
                        nextTwoRolls[1] = nextNextFrame[0].equals("S") ? 10 : Integer.parseInt(nextNextFrame[0].replace("-", "0"));
                    } else {
                        nextTwoRolls[1] = nextFrame[1].equals("S") ? 10 : (nextFrame[1].equals("P") ? 10 - Integer.parseInt(nextFrame[0].replace("-", "0")) : Integer.parseInt(nextFrame[1].replace("-", "0")));
                    }
                } else { // 10번째 프레임
                    nextTwoRolls[0] = scoreBoard[i][1].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][1].replace("-", "0"));
                    nextTwoRolls[1] = scoreBoard[i][2].equals("P") ? 10 - Integer.parseInt(scoreBoard[i][1].replace("-", "0")) : (scoreBoard[i][2].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][2].replace("-", "0")));
                }
                extraPoints[i] = String.valueOf(10 + nextTwoRolls[0] + nextTwoRolls[1]);
            } else if (scoreBoard[i][1].equals("P")) { // 스페어
                if (i < 9) {
                    String[] nextFrame = scoreBoard[i + 1];
                    extraPoints[i] = String.valueOf(10 + (nextFrame[0].equals("S") ? 10 : Integer.parseInt(nextFrame[0].replace("-", "0"))));
                } else { // 10번째 프레임
                    extraPoints[i] = String.valueOf(10 + (scoreBoard[i][2].equals("S") ? 10 : Integer.parseInt(scoreBoard[i][2].replace("-", "0"))));
                }
            } else {
                // 단순한 점수 입력의 경우, 추가 점수는 두 점수를 합한 값으로 설정
                int frameScore = Integer.parseInt(scoreBoard[i][0].replace("-", "0")) + Integer.parseInt(scoreBoard[i][1].replace("-", "0"));
                extraPoints[i] = String.valueOf(frameScore);
            }
        }
    }
}