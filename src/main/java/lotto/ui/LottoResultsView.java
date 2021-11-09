package lotto.ui;

import lotto.domain.PurchaseInfo;
import lotto.domain.LottoRankingStatus;
import lotto.domain.LottoResults;
import lotto.dto.LottoResultsDto;

import java.util.Map;

public class LottoResultsView {
    public static final String MATCH_AMOUNT_DESCRIPTION = "%s개 일치";
    public static final String MATCH_BONUS_DESCRIPTION = ", 보너스 볼 일치";
    public static final String MATCH_PRICE_AND_TOTAL_AMOUNT_DESCRIPTION = " (%s원)- %s개";
    private final PurchaseInfo purchaseInfo;
    private final LottoResults lottoResults;

    public LottoResultsView(PurchaseInfo purchaseInfo, LottoResults lottoResults) {
        this.purchaseInfo = purchaseInfo;
        this.lottoResults = lottoResults;
    }

    public void showResults() {
        LottoMessage.showResultsTitle();
        showResultsStats();
        LottoMessage.showProfitRate(purchaseInfo, lottoResults);
    }

    private void showResultsStats() {
        LottoResultsDto lottoResultsDto = new LottoResultsDto(lottoResults);
        StringBuilder resultsStats = new StringBuilder();
        Map<LottoRankingStatus, Integer> lottoRankingAmounts = lottoResultsDto.getLottoRankingAmounts();
        for (LottoRankingStatus lottoRankingStatus: lottoRankingAmounts.keySet()) {
            printLottoRankingStatus(resultsStats, lottoRankingStatus, lottoRankingAmounts.get(lottoRankingStatus));
        }

        System.out.println(resultsStats);
    }

    private void printLottoRankingStatus(StringBuilder result, LottoRankingStatus lottoRankingStatus, int matchCount) {
        if (lottoRankingStatus == LottoRankingStatus.NONE) {
            return;
        }

        result.append(getMatchDescription(lottoRankingStatus, matchCount))
                .append(System.lineSeparator());

    }

    private String getMatchDescription(LottoRankingStatus lottoRankingStatus, int matchCount) {
        String description = lottoRankingStatus.isMatchBonus() ?
                MATCH_AMOUNT_DESCRIPTION + MATCH_BONUS_DESCRIPTION + MATCH_PRICE_AND_TOTAL_AMOUNT_DESCRIPTION :
                MATCH_AMOUNT_DESCRIPTION + MATCH_PRICE_AND_TOTAL_AMOUNT_DESCRIPTION;

        return String.format(description, lottoRankingStatus.getMatchAmount(), lottoRankingStatus.getPrizeAmount(), matchCount);
    }
}
