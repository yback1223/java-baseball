package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int RANGE_FIRST = 1;
    private static final int RANGE_LAST = 9;
    private static final int RANGE_RADIX = 10;
    private static final int LIST_SIZE = 3;

    public List<Character> makeRandomNum() {
        List<Character> characterList = new ArrayList<>();

        characterList.add(oneRandomNumChar());
        return compareAndAddList(characterList);
    }

    private List<Character> compareAndAddList(List<Character> characterList) {
        char randNumChar;

        while (characterList.size() != LIST_SIZE) {
            randNumChar = oneRandomNumChar();
            if (!characterList.contains(randNumChar)) {
                characterList.add(randNumChar);
            }
        }
        return characterList;
    }

    private Character oneRandomNumChar() {
        return Character.forDigit(Randoms.pickNumberInRange(RANGE_FIRST, RANGE_LAST), RANGE_RADIX);
    }
}