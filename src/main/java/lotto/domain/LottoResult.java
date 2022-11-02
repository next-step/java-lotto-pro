package lotto.domain;

import lotto.dto.LottoResultDto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<Integer,Integer> winningPriceMap;
    private LottoNumberMatcher lottoNumberMatcher;
    private BuyAmount buyAmount;

    public LottoResult (Lotteries lotteries, WinningNumbers winningNumbers, BuyAmount buyAmount) {
        this.lottoNumberMatcher = new LottoNumberMatcher(lotteries, winningNumbers);
        this.buyAmount = buyAmount;
        Map<Integer,Integer> matchNumberPrice = new HashMap<>();
        matchNumberPrice.put(3, 5000);
        matchNumberPrice.put(4, 50000);
        matchNumberPrice.put(5, 1500000);
        matchNumberPrice.put(6, 2000000000);
        this.winningPriceMap = Collections.unmodifiableMap(matchNumberPrice);
    }

    private int getWinningPrice() {
        int winningPrice = 0;
        for (int matchNumber : winningPriceMap.keySet()) {
            winningPrice += winningPriceMap.get(matchNumber) * lottoNumberMatcher.getMatchLottoNumber(matchNumber);
        }
        return winningPrice;
    }

    private double getProfit() {
        return buyAmount.getProfit(getWinningPrice());
    }

    public LottoResultDto getLottoResultDto() {
        return new LottoResultDto(winningPriceMap, lottoNumberMatcher, getProfit());
    }
}
