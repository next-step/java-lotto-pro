package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoMatchResult;
import study.step3.message.LottoMessage;

import java.util.Arrays;

public enum LottoRank {
    FIRST_PLACE(new LottoMatchResult(6L, false), 2_000_000_000L),
    SECOND_PLACE(new LottoMatchResult(5L, true), 30_000_000L),
    THIRD_PLACE(new LottoMatchResult(5L, false), 1_500_000L),
    FOURTH_PLACE(new LottoMatchResult(4L, false), 50_000L),
    FIFTH_PLACE(new LottoMatchResult(3L, false), 5_000L),
    NONE(new LottoMatchResult(0L, false), 0L);

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
        return Arrays.stream(values())
                .filter(rank -> matchResult.isEqualsLottoMatchCount(rank.matchResult))
                .filter(rank -> matchResult.isEqualBonusMatch(rank.matchResult))
                .findFirst()
                .orElse(LottoRank.NONE);
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
        if(matchResult.isMatchedBonusLottoNumber()) {
            return LottoMessage.OUTPUT_LOTTO_RANK_IS_MATCHED_BONUS_NUMBER.message();
        }
        return LottoMessage.OUTPUT_LOTTO_RANK_IS_NOT_MATCHED_BONUS_NUMBER.message();
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
