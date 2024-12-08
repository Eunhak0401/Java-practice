package Baseball;

import java.util.*;

// 추상 클래스 정의
abstract class Game {
    abstract void start();
}

// 인터페이스 정의
interface Playable {
    void play();
}

// 야구 게임 클래스
class BaseballGame extends Game implements Playable {
    private int[] computerNumbers = new int[3]; // 컴퓨터가 생성한 숫자
    private int turnCount = 1; // 현재 턴 수
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        generateRandomNumbers();
        System.out.println("야구게임을 시작합니다.");
        play();
    }

    @Override
    public void play() {
        while (true) {
            System.out.println("\n턴 #" + turnCount);
            int[] playerNumbers = getPlayerInput();
            int strikes = 0, balls = 0;

            // 스트라이크와 볼 계산
            for (int i = 0; i < 3; i++) {
                if (playerNumbers[i] == computerNumbers[i]) {
                    strikes++;
                } else if (isNumberInArray(computerNumbers, playerNumbers[i])) {
                    balls++;
                }
            }

            // 결과 출력
            if (strikes == 3) {
                System.out.println("3스트라이크! 아웃!! 게임 종료!");
                break;
            } else if (strikes == 0 && balls == 0) {
                System.out.println("아웃!");
            } else {
                System.out.println(strikes + "스트라이크 " + balls + "볼");
            }

            // 게임 계속 여부 확인
            if (!askToContinue()) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            turnCount++;
        }
    }

    private void generateRandomNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add((int) (Math.random() * 9) + 1); // Math.random() 사용
        }
        int index = 0;
        for (int num : uniqueNumbers) {
            computerNumbers[index++] = num;
        }
    }

    private int[] getPlayerInput() {
        int[] input = new int[3];
        System.out.println("3개의 정수를 입력하세요!");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + "번째 숫자: ");
            input[i] = scanner.nextInt();
        }
        return input;
    }

    private boolean isNumberInArray(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    private boolean askToContinue() {
        System.out.print("계속 하시겠습니까? (Y/N): ");
        String response = scanner.next().toUpperCase();
        return response.equals("Y");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        Game game = new BaseballGame(); // 추상 클래스 사용
        game.start();
    }
}