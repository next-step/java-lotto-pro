package lotto.model;

import lotto.exception.UnexpectValueException;

public class ManualGameCount {

    private static final String EXCEED_MANUAL_GAME_COUNT = "최대 수동게임 가능횟수는 %s입니다.";

    private final int count;

    public ManualGameCount(final int gameCount, final int inputManualGameCount) {
        validate(gameCount, inputManualGameCount);
        this.count = inputManualGameCount;
    }

    public int getValue() {
        return count;
    }

    public void validate(int gameCount, int inputManualGameCount) {
        if (gameCount < inputManualGameCount) {
            throw new UnexpectValueException(String.format(EXCEED_MANUAL_GAME_COUNT, gameCount));
        }
    }

}
