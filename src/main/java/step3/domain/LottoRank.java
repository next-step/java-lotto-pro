package step3.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import step3.domain.constance.LottoConstant;

public enum LottoRank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 0, 1_500_000),
    THIRD(4, 0, 50_000),
    FOURTH(3, 0, 5_000),
    NONE(0, 0, 0);

    public int matchNumber; // 일치하는 로또번호 갯수
    public int matchCount; // 당첨된 로또 갯수
    public long prize; // 상금

    LottoRank(int matchNumber, int matchCount, long prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static LottoRank[] listOf() {
        return getSortedValues();
    }

    public void incrementCountHasMatchNumber(int matchNumber) {
        if (hasMatchNumber(matchNumber)) {
            matchCount++;
        }
    }

    public Long totalPrize() {
        return matchCount * prize;
    }

    private boolean hasMatchNumber(int matchNumber) {
        return this.matchNumber == matchNumber;
    }

    private String totalPrizeWon() {
        return totalPrize() + LottoConstant.WON;
    }

    private static LottoRank[] getSortedValues() {
        return Stream.of(values()).sorted((o1, o2) ->
            {
                return o2.toString().compareTo(o1.toString());
            }).
            toArray(LottoRank[]::new);
    }

    @Override
    public String toString() {
        return String.format(LottoConstant.LOTTO_REPORT_FORMAT, matchNumber, prize, matchCount);
    }

}
