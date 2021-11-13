package step3.domain;

import java.text.MessageFormat;

public enum Prize {
    FIRST_PLACE(Lotto.LOTTO_LENGTH, new Money(2000000000)),
    SECOND_PLACE(5, new Money(1500000)),
    THIRD_PLACE(4, new Money(50000)),
    FORTH_PLACE(3, new Money(5000));

    private final int correct;
    private final Money reward;

    Prize(int correct, Money reward) {
        this.correct = correct;
        this.reward = reward;
    }

    public Money getReward() {
        return reward;
    }

    public String message() {
        return MessageFormat.format("{0}개 일치 ({1}원)", this.correct, this.reward.get());
    }

    public static Prize of(final int correct) {
        if (isLessThanCorrect(correct)) {
            return null;
        }

        if (isPrizePlace(FIRST_PLACE, correct)) {
            return FIRST_PLACE;
        }

        if (isPrizePlace(SECOND_PLACE, correct)) {
            return SECOND_PLACE;
        }

        if (isPrizePlace(THIRD_PLACE, correct)) {
            return THIRD_PLACE;
        }

        if (isPrizePlace(FORTH_PLACE, correct)) {
            return FORTH_PLACE;
        }

        return null;
    }

    private static boolean isPrizePlace(Prize prize, int correct) {
        return prize.correct == correct;
    }

    private static boolean isLessThanCorrect(int correct) {
        return correct < FORTH_PLACE.correct;
    }
}
