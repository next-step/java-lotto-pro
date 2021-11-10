package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {

    private static final int STANDARD_RATE_OF_RETURN = 1;
    private final Map<LottoRank, Integer> lottoTicketRankMap;
    private final double rateOfReturn;

    private LottoResult(Map<LottoRank, Integer> lottoTicketRankMap, double rateOfReturn) {
        this.lottoTicketRankMap = lottoTicketRankMap;
        this.rateOfReturn = rateOfReturn;
    }

    public static LottoResult of(LottoPurchase lottoPurchase, LottoTicket lottoTicket, LottoWinningNumbers lottoWinningNumbers) {
        Map<LottoRank, Integer> lottoTicketRankMap = lottoTicket.countLottoRank(lottoWinningNumbers);
        double rateOfReturn = calculateRateOfReturn(lottoPurchase, lottoTicketRankMap);
        return new LottoResult(lottoTicketRankMap, rateOfReturn);
    }

    private static double calculateRateOfReturn(LottoPurchase lottoPurchase, Map<LottoRank, Integer> lottoTicketRankMap) {
        int totalPrizeMoney = 0;
        for (Map.Entry<LottoRank, Integer> entry : lottoTicketRankMap.entrySet()) {
            totalPrizeMoney += entry.getKey().calculatePrize(entry.getValue());
        }
        return (double) totalPrizeMoney / lottoPurchase.getPurchaseAmount();
    }

    public Map<LottoRank, Integer> getLottoTicketRankMap() {
        return Collections.unmodifiableMap(new TreeMap<>(lottoTicketRankMap));
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public boolean isRateOfReturnLessThenStandard() {
        return rateOfReturn < STANDARD_RATE_OF_RETURN;
    }

}
