package lotto.enums;

import lotto.model.Prize;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constants.LottoConstant.MIN_WINNING_RANK;

public enum Rank {
    LOSE(0, Prize.of(0)),
    SEVENTH(1, Prize.of(0)),
    SIXTH(2, Prize.of(0)),
    FIFTH(3, Prize.of(5_000)),
    FOURTH(4, Prize.of(50_000)),
    THIRD(5, Prize.of(1_500_000)),
    SECOND(5, Prize.of(30_000_000)),
    FIRST(6, Prize.of(2_000_000_000));

    private final int matchingCount;
    private final Prize prize;
    private final static Map<Integer, Rank> ranks = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(Rank::getMatchingCount, Function.identity())));

    Rank(int matchingCount, Prize prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank getRank(int numberOfMatch) {
        return Optional.ofNullable(ranks.get(numberOfMatch))
                .orElse(LOSE);
    }

    public static Rank getRank(int numberOfMatch, boolean hasBonusNumber) {
        Rank rank = Optional.ofNullable(ranks.get(numberOfMatch))
                .orElse(LOSE);
        if (rank == THIRD && hasBonusNumber)
            return SECOND;
        return rank;
    }

    public Prize getPrize() {
        return prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isOverMinWinningRank() {
        return matchingCount >= MIN_WINNING_RANK;
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", matchingCount, prize);
        }
        return String.format("%d개 일치 (%s원)", matchingCount, prize);
    }
}
