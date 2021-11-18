package lotto.enums;

import static util.NumberUtils.*;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Money;

public enum Rank {
    FIRST_PLACE(Lotto.LOTTO_LENGTH, new Money(2000000000)),
    SECOND_PLACE(5, new Money(30000000)),
    THIRD_PLACE(5, new Money(1500000)),
    FORTH_PLACE(4, new Money(5000)),
    FIFTH_PLACE(3, new Money(5000)),
    OUT_OF_RANKING(ZERO, new Money(ZERO));

    public static final Set<Rank> REWARDING_GROUP =
        Collections.unmodifiableSet(EnumSet.of(FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FORTH_PLACE, FIFTH_PLACE));

    public static final Set<Rank> PROMOTION_GROUP = Collections.unmodifiableSet(EnumSet.of(SECOND_PLACE, THIRD_PLACE));

    private final int correctCount;
    private final Money reward;

    Rank(final int correctCount, final Money reward) {
        this.correctCount = correctCount;
        this.reward = reward;
    }

    public static Rank valueOf(final int correctCount, final boolean bonusMatch) {
        return Stream.of(values())
            .filter(rank -> isRankPlace(rank, correctCount))
            .map(rank -> promoteSecondPlaceByBonusMatch(rank, bonusMatch))
            .findFirst()
            .orElse(Rank.OUT_OF_RANKING);
    }

    private static boolean isRankPlace(final Rank rank, final int correctCount) {
        return rank.correctCount == correctCount;
    }

    private static Rank promoteSecondPlaceByBonusMatch(final Rank rank, final boolean bonusMatch) {
        if (!Rank.PROMOTION_GROUP.contains(rank)) {
            return rank;
        }

        if (bonusMatch) {
            return Rank.SECOND_PLACE;
        }

        return Rank.THIRD_PLACE;
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

    public String message(final int ranksCount) {
        return MessageFormat.format("{0}개 일치 ({1}원)- {2}개", this.correctCount, this.reward.get(), ranksCount);
    }

    public int exchangeCorrectCount(final int correctCount) {
        if (isZero(this.correctCount)) {
            return ZERO;
        }

        return Math.floorDiv(correctCount, this.correctCount);
    }
}
