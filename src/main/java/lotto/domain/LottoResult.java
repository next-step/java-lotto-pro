package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<Integer,Integer> winningPriceMap;
    private LottoMatchNumberMap lottoMatchNumberMap;
    private int buyAmount;

    public LottoResult (Lotteries lotteries, int[] winningNumbers, int buyAmount) {
        this.lottoMatchNumberMap = new LottoMatchNumberMap(lotteries, winningNumbers);
        this.buyAmount = buyAmount;
        this.winningPriceMap =  new HashMap<>();
        this.winningPriceMap.put(3, 5000);
        this.winningPriceMap.put(4, 50000);
        this.winningPriceMap.put(5, 1500000);
        this.winningPriceMap.put(6, 2000000000);
    }

    private int getWinningPrice() {
        int winningPrice = 0;
        for(int matchNumber : winningPriceMap.keySet()) {
            winningPrice += winningPriceMap.get(matchNumber) * lottoMatchNumberMap.getMatchLottoNumber(matchNumber);
        }
        return winningPrice;
    }

    @Override
    public String toString() {
        String result = "";
        for(int matchNumber : winningPriceMap.keySet()) {
            result += (matchNumber + "개 일치 (" + winningPriceMap.get(matchNumber) + "원)- "
                    + lottoMatchNumberMap.getMatchLottoNumber(matchNumber) + "개\n");
        }
        double profitRatio = getWinningPrice()/buyAmount;
        if(profitRatio >= 1)
            return result + "총 수익률은 " + profitRatio + "입니다.";
        return result + "총 수익률은 " + profitRatio + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }
}
