package lotto.domain.result;

import java.util.Arrays;
import java.util.List;
import lotto.domain.matcher.count.MatchCount;

public class DefaultLottoResult {

    private static final String LINEBREAK = "\n";
    private List<LottoResult> lottoResults;

    public DefaultLottoResult() {
        this.lottoResults = Arrays
                .asList(LottoResult.THREE, LottoResult.FOUR, LottoResult.FIVE, LottoResult.FIVE_BONUS, LottoResult.SIX);
    }

    public void calculateTotalCount(MatchCount matchCount) {
        lottoResults.forEach(lottoResult -> lottoResult.calculateTotalCount(matchCount));
    }

    public int totalProfit() {
        return lottoResults.stream().mapToInt(LottoResult::profit).sum();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LottoResult lottoResult : lottoResults) {
            result.append(lottoResult.toString()).append(LINEBREAK);
        }
        return result.substring(0, result.length() - 1);
    }
}
