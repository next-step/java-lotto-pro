package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.stream;

public class LottoResult {

    private static final String PRINT_RATE_OF_RETURN = "총 수익률은 %.2f 입니다. ";
    private static final String PRINT_RATE_OF_RETURN_LESS_THEN_STANDARD = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int STANDARD_RATE_OF_RETURN = 1;
    private final Map<LottoRank, Integer> lottoTicketRankMap;
    private final double rateOfReturn;

    public LottoResult(LottoPurchase lottoPurchase, LottoTicket lottoTicket, LottoNumbers lottoWinningNumbers) {
        this.lottoTicketRankMap = new TreeMap<>();
        stream(LottoRank.values())
                .forEach(lottoRank -> lottoTicketRankMap.put(lottoRank, countLottoRank(lottoRank, lottoTicket, lottoWinningNumbers)));
        this.rateOfReturn = calculateRateOfReturn(lottoPurchase);
    }

    private Integer countLottoRank(LottoRank lottoRank, LottoTicket lottoTicket, LottoNumbers lottoWinningNumbers) {
        return Math.toIntExact(lottoTicket.getLottoTicket().stream()
                .map(lottoNumbers -> lottoNumbers.compareWinningNumbers(lottoWinningNumbers))
                .filter(rank -> rank.equals(lottoRank))
                .count());
    }

    private double calculateRateOfReturn(LottoPurchase lottoPurchase) {
        int totalPrizeMoney = 0;
        for (Map.Entry<LottoRank, Integer> entry : lottoTicketRankMap.entrySet()) {
            totalPrizeMoney += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return (double) totalPrizeMoney / lottoPurchase.getPurchaseAmount();
    }

    public Map<LottoRank, Integer> getLottoTicketRankMap() {
        return Collections.unmodifiableMap(new TreeMap<>(lottoTicketRankMap));
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public String getPrintRateOfReturnMsg() {
        String rateOfReturnMsg = String.format(PRINT_RATE_OF_RETURN, rateOfReturn);
        if (rateOfReturn < STANDARD_RATE_OF_RETURN)
            rateOfReturnMsg += PRINT_RATE_OF_RETURN_LESS_THEN_STANDARD;

        return rateOfReturnMsg;
    }

}
