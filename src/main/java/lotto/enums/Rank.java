package lotto.enums;

import lotto.model.Prize;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constants.LottoConstant.MIN_WINNING_RANK;

public enum Rank {
    LOSE(0, false, Prize.of(0)),
    SEVENTH(1, false, Prize.of(0)),
    SIXTH(2, false, Prize.of(0)),
    FIFTH(3, false, Prize.of(5_000)),
    FOURTH(4, false, Prize.of(50_000)),
    THIRD(5, false, Prize.of(1_500_000)),
    SECOND(5, true, Prize.of(30_000_000)),
    FIRST(6, false, Prize.of(2_000_000_000));

    private final int matchingCount;
    private final Prize prize;
    private final boolean hasBonus;
    private static final Map<Integer, Rank> ranks = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(Rank::rankKey, Function.identity())));

    Rank(int matchingCount, boolean hasBonus, Prize prize) {
        this.matchingCount = matchingCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Rank getRank(int numberOfMatch, boolean hasBonusNumber) {
        int rankKey = Objects.hash(numberOfMatch, hasBonusNumber);
        return ranks.getOrDefault(rankKey, LOSE);
    }

    public Prize getPrize() {
        return prize;
    }

    public boolean isOverMinWinningRank() {
        return matchingCount >= MIN_WINNING_RANK;
    }

    private int rankKey() {
        return Objects.hash(matchingCount, hasBonus);
    }

    @Override
    public String toString() {
        if (hasBonus) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", matchingCount, prize);
        }
        return String.format("%d개 일치 (%s원)", matchingCount, prize);
    }
}
