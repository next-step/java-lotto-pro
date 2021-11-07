package lotto.ui;

import lotto.domain.BuyAmount;
import lotto.domain.LottoRankingStatus;
import lotto.domain.LottoResults;
import lotto.dto.LottoResultsDto;

import java.util.Map;

public class LottoResultsView {
    public static final String MATCH_DESCRIPTION = "%s개 일치 (%s원)- %s개";
    private final BuyAmount buyAmount;
    private final LottoResults lottoResults;

    public LottoResultsView(BuyAmount buyAmount, LottoResults lottoResults) {
        this.buyAmount = buyAmount;
        this.lottoResults = lottoResults;
    }

    public void showResults() {
        LottoMessage.showResultsTitle();
        showResultsStats();
        LottoMessage.showProfitRate(buyAmount, lottoResults);
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

        result.append(getMatchDescription(lottoRankingStatus.getMatchAmount(), lottoRankingStatus.getPrizeAmount(), matchCount))
                .append(System.lineSeparator());

    }

    public String getMatchDescription(int matchAmount, int prizeAmount, int matchCount) {
        return String.format(MATCH_DESCRIPTION, matchAmount, prizeAmount, matchCount);
    }
}
