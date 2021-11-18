package lotto.enums;

import static util.NumberUtils.*;
import java.text.MessageFormat;
import lotto.domain.Lotto;
import lotto.domain.Money;

public enum Rank {
    FIRST_PLACE(Lotto.LOTTO_LENGTH, new Money(2000000000)),
    SECOND_PLACE(5, new Money(1500000)),
    THIRD_PLACE(4, new Money(50000)),
    FORTH_PLACE(3, new Money(5000)),
    OUT_OF_RANKING(ZERO, new Money(ZERO));

    private final int correct;
    private final Money reward;

    Rank(final int correct, final Money reward) {
        this.correct = correct;
        this.reward = reward;
    }

    public static Rank of(final int correct) {
        if (isLessThanCorrect(correct)) {
            return OUT_OF_RANKING;
        }

        if (isRankPlace(FIRST_PLACE, correct)) {
            return FIRST_PLACE;
        }

        if (isRankPlace(SECOND_PLACE, correct)) {
            return SECOND_PLACE;
        }

        if (isRankPlace(THIRD_PLACE, correct)) {
            return THIRD_PLACE;
        }

        if (isRankPlace(FORTH_PLACE, correct)) {
            return FORTH_PLACE;
        }

        return OUT_OF_RANKING;
    }

    private static boolean isRankPlace(final Rank rank, final int correct) {
        return rank.correct == correct;
    }

    private static boolean isLessThanCorrect(final int correct) {
        return correct < FORTH_PLACE.correct;
    }

    public Money accumulateReward(final int correctCount) {
        if (isZero(correctCount)) {
            return new Money(ZERO);
        }

        final Money accumulateReward = new Money(ZERO);

        for (int count = 0; count < correctCount; count++) {
            accumulateReward.earn(this.reward);
        }

        return accumulateReward;
    }

    public String message() {
        return MessageFormat.format("{0}개 일치 ({1}원)", this.correct, this.reward.get());
    }

    public int exchangeCorrectCount(final int correct) {
        if (isZero(this.correct)) {
            return ZERO;
        }

        return Math.floorDiv(correct, this.correct);
    }
}
