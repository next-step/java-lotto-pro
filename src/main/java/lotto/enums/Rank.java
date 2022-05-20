package lotto.enums;

import lotto.model.Prize;

import java.util.Arrays;

import static lotto.constants.LottoConstant.MIN_WINNING_RANK;

public enum Rank {
    LOSE(0, Prize.of(0)),
    SIXTH(1, Prize.of(0)),
    FIFTH(2, Prize.of(0)),
    FOURTH(3, Prize.of(5_000)),
    THIRD(4, Prize.of(50_000)),
    SECOND(5, Prize.of(1_500_000)),
    FIRST(6, Prize.of(2_000_000_000));

    private final int matchingCount;
    private final Prize prize;

    Rank(int matchingCount, Prize prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank getRank(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == numberOfMatch)
                .findAny()
                .orElse(LOSE);
    }

    public Prize getPrize() {
        return prize;
    }

    public Prize getPrizeWithCount(int count) {
        return prize.multiply(count);
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%s)원", matchingCount, prize);
    }

    public boolean isOverMinWinningRank() {
        return matchingCount >= MIN_WINNING_RANK;
    }
}
