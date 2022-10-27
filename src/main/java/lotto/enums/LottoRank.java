package lotto.enums;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0),
    ;

    private final int matchNumberCount;
    private final long reward;

    LottoRank(int matchNumberCount, long reward) {
        this.matchNumberCount = matchNumberCount;
        this.reward = reward;
    }


}