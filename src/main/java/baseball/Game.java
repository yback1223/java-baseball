package baseball;

import java.util.List;

public class Game {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ENDGAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String ENDORRE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final List<Integer> THREE_STRIKE = List.of(3, 0);

    private final int listSize;

    public Game(int listSize) {
        this.listSize = listSize;
    }

    public void runGame() {
        while (true) {
            boolean flag;
            Computer computer = new Computer(listSize);
            System.out.println(START_MESSAGE);
            flag = endGameOrQuit(0, false, computer.makeRandomNum());
            if (flag) {
                break;
            }
        }
    }

    private boolean endGameOrQuit(int oneOrTwo, boolean flag, List<Character> computerList) {
        while (oneOrTwo == 0) {
            System.out.print(INPUT_MESSAGE);
            Input input = new Input(listSize);
            CompareTwoList compareTwoList = new CompareTwoList();
            List<Integer> strikeBalls = compareTwoList.compareLists(computerList, input.readAndMakeInputList());
            (new Output()).printStrikeBall(strikeBalls);
            oneOrTwo = endGameMessage(strikeBalls.equals(THREE_STRIKE), oneOrTwo);
            flag = checkTwo(oneOrTwo);
        }
        return flag;
    }

    private static boolean checkTwo(int oneOrTwo) {
        return oneOrTwo == 2;
    }

    private static int endGameMessage(boolean trueOrFalse, Integer oneOrTwo) {
        if (trueOrFalse) {
            System.out.println(ENDGAME_MESSAGE + ENDORRE_MESSAGE);
            oneOrTwo = (new EndOrRe()).readAndMakeInputList();
        }
        return oneOrTwo;
    }
}