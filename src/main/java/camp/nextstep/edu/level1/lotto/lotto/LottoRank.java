package camp.nextstep.edu.level1.lotto.lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST("6개 일치", 6, false, new Money(2_000_000_000)),
    SECOND("5개 일치, 보너스 볼 일치", 5, true, new Money(30_000_000)),
    THIRD("5개 일치", 5, false, new Money(1_500_000)),
    FORTH("4개 일치", 4, false, new Money(50_000)),
    FIFTH("3개 일치", 3, false, new Money(5_000));

    private final String description;
    private final long matchCount;
    private final boolean haveToMatchBonusBall;
    private final Money price;

    LottoRank(String description, long matchCount, boolean haveToMatchBonusBall, Money price) {
        this.description = description;
        this.matchCount = matchCount;
        this.haveToMatchBonusBall = haveToMatchBonusBall;
        this.price = price;
    }

    public static LottoRank findLottoRank(LottoNumbers source, LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        long matchedCount = source.matchedCountByWinnerNumbers(winningNumbers);
        boolean isMatchedBonusBall = source.isContainLottoNumber(bonusNumber);
        return findLottoRankByMatchedCount(matchedCount, isMatchedBonusBall);
    }

    public String rankDescription() {
        return this.description;
    }

    public Money rankPrice() {
        return this.price;
    }

    private static LottoRank findLottoRankByMatchedCount(long matchedCount, boolean isMatchedBonusBall) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> isMatchedLottoRank(rank, matchedCount, isMatchedBonusBall))
                .findFirst()
                .orElse(null);
    }

    private static boolean isMatchedLottoRank(LottoRank rank, long matchedCount, boolean isMatchedBonusBall) {
        return rank.matchCount == matchedCount && checkMatchedBonusBall(rank, isMatchedBonusBall);
    }

    private static boolean checkMatchedBonusBall(LottoRank rank, boolean isMatchedBonusBall) {
        return !rank.haveToMatchBonusBall || isMatchedBonusBall;
    }
}
