package step3.domain;

import java.util.Arrays;
import java.util.stream.Stream;

import step3.domain.constance.LottoConstant;

public enum LottoRank {
    FIRST(6, 0, 2_000_000_000L),
    SECOND(5, 0, 30_000_000L),
    THIRD(5, 0, 1_500_000L),
    FOURTH(4, 0, 50_000L),
    FIFTH(3, 0, 5_000L),
    NONE(0, 0, 0L);

    public int matchNumber; // 일치하는 로또번호 갯수
    public int matchCount; // 당첨된 로또 갯수
    public long prize; // 상금

    LottoRank(int matchNumber, int matchCount, long prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
        this.matchCount = matchCount;
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

    public static LottoRank[] listOf() {
        return getSortedValues();
    }

    public void incrementCountHasMatchNumber(int matchNumber) {
        if (hasMatchNumber(matchNumber)) {
            matchCount++;
        }
    }

    private boolean hasMatchNumber(int matchNumber) {
        return this.matchNumber == matchNumber;
    }

    public Long totalPrize() {
        return matchCount * prize;
    }

    private static LottoRank[] getSortedValues() {
        return Stream.of(values()).sorted((o1, o2) ->
            {
                return o1.toString().compareTo(o2.toString());
            }).
            toArray(LottoRank[]::new);
    }

    @Override
    public String toString() {
        return String.format(LottoConstant.LOTTO_REPORT_FORMAT, matchNumber, prize, matchCount);
    }

}
