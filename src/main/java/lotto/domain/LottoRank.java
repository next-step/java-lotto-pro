package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    LOSE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    private static final Map<Integer, LottoRank> LOTTO_RANK_MAP =
        Collections.unmodifiableMap(Stream.of(values())
            .filter(LottoRank::isNotSecond)
            .collect(Collectors.toMap(LottoRank::getMatchCount, Function.identity())));

    public static LottoRank findMatch(int matchCount, boolean matchBonus) {
        if(matchCount == LottoRank.SECOND.getMatchCount() && matchBonus){
            return LottoRank.SECOND;
        }
        return Optional.ofNullable(LOTTO_RANK_MAP.get(matchCount)).orElse(LOSE);
    }

    private boolean isNotSecond() {
        return this != SECOND;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
