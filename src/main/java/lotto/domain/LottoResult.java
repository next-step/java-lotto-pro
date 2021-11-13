package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.stream;

public class LottoResult {

    private final Map<LottoRank, Integer> lottoTicketRankMap;
    private final RateOfReturn rateOfReturn;

    private LottoResult(Map<LottoRank, Integer> lottoTicketRankMap, RateOfReturn rateOfReturn) {
        this.lottoTicketRankMap = lottoTicketRankMap;
        this.rateOfReturn = rateOfReturn;
    }

    public static LottoResult of(LottoPurchase lottoPurchase, LottoTicket lottoTicket, LottoWinningNumbers lottoWinningNumbers) {
        Map<LottoRank, Integer> lottoTicketRankMap = new TreeMap<>();
        stream(LottoRank.values())
                .forEach(lottoRank -> lottoTicketRankMap.put(lottoRank, lottoTicket.countLottoRank(lottoRank, lottoWinningNumbers)));

        RateOfReturn rateOfReturn = RateOfReturn.from(calculateRateOfReturn(lottoPurchase, lottoTicketRankMap));
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

    public RateOfReturn getRateOfReturn() {
        return rateOfReturn;
    }

}
