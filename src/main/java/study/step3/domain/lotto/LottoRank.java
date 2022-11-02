package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoMatchResult;
import study.step3.message.LottoMessage;

public enum LottoRank {
    FIRST_PLACE(new LottoMatchResult(6L, 0L), 2_000_000_000L),
    SECOND_PLACE(new LottoMatchResult(5L, 1L), 30_000_000L),
    THIRD_PLACE(new LottoMatchResult(5L, 0L), 1_500_000L),
    FOURTH_PLACE(new LottoMatchResult(4L, 0L), 50_000L),
    FIFTH_PLACE(new LottoMatchResult(3L, 0L), 5_000L),
    NONE(new LottoMatchResult(0L, 0L), 0L);

    private final LottoMatchResult matchResult;
    private final long winningMoney;

    LottoRank(LottoMatchResult matchResult, long winningMoney) {
        this.matchResult = matchResult;
        this.winningMoney = winningMoney;
    }

    public static LottoRank minimumLottoRank() {
        return LottoRank.FIFTH_PLACE;
    }

    public static LottoRank ofMatchResult(LottoMatchResult matchResult) {
        LottoRank findRank = LottoRank.NONE;
        for (LottoRank rank : values()) {
            findRank = findLottoLank(findRank, rank, matchResult);
        }

        return findRank;
    }

    private static LottoRank findLottoLank(LottoRank findRank, LottoRank rank, LottoMatchResult matchResult) {
        if(findRank.isWinning()) {
            return findRank;
        }

        if(!matchResult.isEqualsLottoMatchCount(rank.matchResult)) {
            return findRank;
        }

        if(!matchResult.isGreaterThanOrEqualBonusMatchCount(rank.matchResult)) {
            return findRank;
        }
        return rank;
    }

    public boolean isNone() {
        return NONE.equals(this);
    }

    public boolean isWinning() {
        return !isNone();
    }

    public LottoMatchResult matchResult() {
        return this.matchResult;
    }

    public String reportBonusNumberMatchResult() {
        if(!matchResult.isGreaterThanZeroBonusMatchCount()) {
            return LottoMessage.OUTPUT_LOTTO_RANK_IS_NOT_MATCHED_BONUS_NUMBER.message();
        }
        return LottoMessage.OUTPUT_LOTTO_RANK_IS_MATCHED_BONUS_NUMBER.message();
    }

    public long reportLottoMatchResult() {
        return this.matchResult.lottoMatchCount();
    }

    public Money winningMoney() {
        return Money.of(this.winningMoney);
    }

    public Money winningMoneyWithCount(long count) {
        return Money.of(this.winningMoney * count);
    }
}
