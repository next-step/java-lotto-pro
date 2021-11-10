package lotto.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    NONE(0, 0, 0),
    FIFTH(3, 0, 5000),
    FOURTH(4, 0, 5_0000),
    THIRD(5, 0, 150_0000),
    SECOND(5, 1, 3000_0000),
    FIRST(6, 0, 20_0000_0000);

    private final int matchingCount;
    private final int bonusMatchingCount;
    private final int price;

    LottoRank(int matchingCount, int bonusMatchingCount, int price) {
        this.matchingCount = matchingCount;
        this.bonusMatchingCount = bonusMatchingCount;
        this.price = price;
    }

    public static LottoRank findRank(int matchingCount, int bonusMatchingCount) {
        List<LottoRank> filteredLottoRanks = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchingCount == matchingCount)
                .collect(Collectors.toList());

        if (filteredLottoRanks.isEmpty()) {
            return LottoRank.NONE;
        }

        if (filteredLottoRanks.size() == 1) {
            return filteredLottoRanks.get(0);
        }

        return filteredLottoRanks.stream()
                .filter(lottoRank -> lottoRank.bonusMatchingCount == bonusMatchingCount)
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrice() {
        return price;
    }
}
