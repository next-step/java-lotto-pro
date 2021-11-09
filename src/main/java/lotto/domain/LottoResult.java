package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.stream;

public class LottoResult {

    private static final int STANDARD_RATE_OF_RETURN = 1;
    private final Map<LottoRank, Integer> lottoTicketRankMap;
    private final double rateOfReturn;

    public LottoResult(LottoPurchase lottoPurchase, LottoTicket lottoTicket, LottoWinningNumbers lottoWinningNumbers) {
        this.lottoTicketRankMap = new TreeMap<>();
        stream(LottoRank.values())
                .forEach(lottoRank -> lottoTicketRankMap.put(lottoRank, countLottoRank(lottoRank, lottoTicket, lottoWinningNumbers)));
        this.rateOfReturn = calculateRateOfReturn(lottoPurchase);
    }

    private Integer countLottoRank(LottoRank lottoRank, LottoTicket lottoTicket, LottoWinningNumbers lottoWinningNumbers) {
        return Math.toIntExact(lottoTicket.getLottoTicket().stream()
                .map(lottoWinningNumbers::compareLottoNumbers)
                .filter(rank -> rank.equals(lottoRank))
                .count());
    }

    private double calculateRateOfReturn(LottoPurchase lottoPurchase) {
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

    public Boolean isRateOfReturnLessThenStandard() {
        return rateOfReturn < STANDARD_RATE_OF_RETURN;
    }

}
