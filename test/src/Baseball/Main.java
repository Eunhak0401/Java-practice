package Baseball;

import java.util.*;

abstract class BaseballGame {
    protected int[] computerNumbers = new int[3];
    protected int turns;

    public abstract void startGame();

    protected void generateNumbers() {
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add(random.nextInt(9) + 1); // 1 ~ 9 랜덤 숫자 생성
        }
        int index = 0;
        for (int num : uniqueNumbers) {
            computerNumbers[index++] = num;
        }
    }
}

interface GameLogic {
    int[] checkNumbers(int[] playerInput);
    void printResult(int strikes, int balls);
    boolean askToContinue();
}

class BaseballGameImpl extends BaseballGame implements GameLogic {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void startGame() {
        generateNumbers();
        turns = 1;
        System.out.println("야구게임을 시작합니다.");

        while (true) {
            System.out.println("턴 #" + turns);
            int[] playerInput = getPlayerInput();
            int[] result = checkNumbers(playerInput);
            printResult(result[0], result[1]);

            if (result[0] == 3) {
                System.out.println("스트라이크 아웃!! 게임 종료!");
                break;
            }

            if (!askToContinue()) {
                System.out.println("게임을 종료합니다.");
                break;
            }
            turns++;
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

    @Override
    public int[] checkNumbers(int[] playerInput) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (playerInput[i] == computerNumbers[i]) {
                strikes++;
            } else if (contains(computerNumbers, playerInput[i])) {
                balls++;
            }
        }
        return new int[]{strikes, balls};
    }

    @Override
    public void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("아웃!");
        } else {
            System.out.println(strikes + "스트라이크 " + balls + "볼");
        }
    }

    @Override
    public boolean askToContinue() {
        System.out.print("계속 하시겠습니까? (Y/N): ");
        String response = scanner.next().toUpperCase();
        return response.equals("Y");
    }

    private boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGameImpl();
        game.startGame();
    }
}

