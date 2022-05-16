package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.common.PositiveNumber;

import java.util.Arrays;

public enum LottoRank {
    FIRST("6개 일치", new PositiveNumber(6), false, new Money(2_000_000_000)),
    SECOND("5개 일치, 보너스 볼 일치", new PositiveNumber(5), true, new Money(30_000_000)),
    THIRD("5개 일치", new PositiveNumber(5), false, new Money(1_500_000)),
    FORTH("4개 일치", new PositiveNumber(4), false, new Money(50_000)),
    FIFTH("3개 일치", new PositiveNumber(3), false, new Money(5_000));

    private final String description;
    private final PositiveNumber matchCount;
    private final boolean haveToMatchBonusBall;
    private final Money price;

    LottoRank(String description, PositiveNumber matchCount, boolean haveToMatchBonusBall, Money price) {
        this.description = description;
        this.matchCount = matchCount;
        this.haveToMatchBonusBall = haveToMatchBonusBall;
        this.price = price;
    }

    public static LottoRank findLottoRank(LottoNumbers source, LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        PositiveNumber matchedCount = source.matchedCountByWinnerNumbers(winningNumbers);
        boolean isMatchedBonusBall = source.hasContainLottoNumber(bonusNumber);
        return findLottoRankByMatchedCount(matchedCount, isMatchedBonusBall);
    }

    public String rankDescription() {
        return this.description;
    }

    public Money rankPrice() {
        return this.price;
    }

    private static LottoRank findLottoRankByMatchedCount(PositiveNumber matchedCount, boolean isMatchedBonusBall) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> isMatchedLottoRank(rank, matchedCount, isMatchedBonusBall))
                .findFirst()
                .orElse(null);
    }

    private static boolean isMatchedLottoRank(LottoRank rank, PositiveNumber matchedCount, boolean isMatchedBonusBall) {
        return rank.matchCount.equals(matchedCount) && checkMatchedBonusBall(rank, isMatchedBonusBall);
    }

    private static boolean checkMatchedBonusBall(LottoRank rank, boolean isMatchedBonusBall) {
        return !rank.haveToMatchBonusBall || isMatchedBonusBall;
    }
}
