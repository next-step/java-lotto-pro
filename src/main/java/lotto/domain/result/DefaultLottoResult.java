package lotto.domain.result;

import java.util.Arrays;
import java.util.List;

public class DefaultLottoResult {

    private static final String LINEBREAK = "\n";
    private static final int DEFAULT_TOTAL_PROFIT = 0;
    private static final int RESULT_START_INDEX = 0;
    private static final int RESULT_END_INDEX = (-1);
    private List<LottoResult> lottoResults;

    public DefaultLottoResult() {
        this.lottoResults = Arrays
                .asList(LottoResult.THREE, LottoResult.FOUR, LottoResult.FIVE, LottoResult.SIX);
    }

    public void calculateTotalCount(int matchCount) {
        for (LottoResult lottoResult : lottoResults) {
            lottoResult.calculateTotalCount(matchCount);
        }
    }

    public int totalProfit() {
        int totalProfit = DEFAULT_TOTAL_PROFIT;
        for (LottoResult lottoResult : lottoResults) {
            totalProfit += lottoResult.profit();
        }
        return totalProfit;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LottoResult lottoResult : lottoResults) {
            result.append(lottoResult.toString()).append(LINEBREAK);
        }
        return result.substring(RESULT_START_INDEX, result.length() + RESULT_END_INDEX);
    }
}
