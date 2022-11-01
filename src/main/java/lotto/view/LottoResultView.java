package lotto.view;

import lotto.domain.LottoNumberMatcher;
import lotto.dto.LottoResultDto;

import java.util.Map;

public class LottoResultView {

    public void lottoResult(LottoResultDto lottoResultDto) {
        System.out.println(lottoResultMessage(lottoResultDto));
    }

    public String lottoResultMessage(LottoResultDto lottoResultDto) {
        Map<Integer,Integer> winningPriceMap = lottoResultDto.getWinningPriceMap();
        LottoNumberMatcher lottoNumberMatcher = lottoResultDto.getLottoNumberMatcher();
        double profit = lottoResultDto.getProfit();
        return lottoResultMessage(winningPriceMap, lottoNumberMatcher, profit);
    }

    public String lottoResultMessage(Map<Integer,Integer> winningPriceMap,
                                     LottoNumberMatcher lottoNumberMatcher, double profit) {
        String result = "당첨 통계\n---------\n";
        for(int matchNumber : winningPriceMap.keySet()) {
            result += (matchNumber + "개 일치 (" + winningPriceMap.get(matchNumber) + "원)- "
                    + lottoNumberMatcher.getMatchLottoNumber(matchNumber) + "개\n");
        }
        String profitString = "" + profit;
        if(profit >= 1) {
            return result + "총 수익률은 " + profitString.substring(0,4) + "입니다.";
        }
        return result + "총 수익률은 " + profitString.substring(0,4) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }

}
