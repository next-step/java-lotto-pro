package camp.nextstep.edu.level1.lotto.lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST("6개 일치", 6, new Money(2000000000)),
    FORTH("3개 일치", 3, new Money(1500000)),
    SECOND("5개 일치", 5, new Money(50000)),
    THIRD("4개 일치", 4, new Money(5000));

    private long matchCount;
    private Money price;

    LottoRank(String description, long matchCount, Money price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoRank checkLottoRank(LottoNumbers source, LottoNumbers winningNumbers) {
        long matchedCount = source.matchedCountByWinnerNumbers(winningNumbers);
        return findLottoRankByMatchedCount(matchedCount);
    }

    public Money rankPrice() {
        return this.price;
    }

    private static LottoRank findLottoRankByMatchedCount(long matchedCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.rankMatchCount() == matchedCount)
                .findFirst()
                .orElse(null);
    }

    private long rankMatchCount() {
        return this.matchCount;
    }
}
