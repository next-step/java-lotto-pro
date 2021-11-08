package step3.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    NONE(0, 0L);

    public int matchNumber; // 일치하는 로또번호 갯수
    public long prize; // 상금

    LottoRank(int matchNumber, long prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchNumber, boolean matchBonus) {
        if (isMatchSecond(matchNumber, matchBonus))
            return SECOND;

        return Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank != SECOND)
            .filter(lottoRank -> lottoRank.matchNumber == matchNumber)
            .findFirst()
            .orElse(NONE);
    }

    private static boolean isMatchSecond(int matchNumber, boolean matchBonus) {
        return matchNumber == SECOND.matchNumber && matchBonus;
    }
}
