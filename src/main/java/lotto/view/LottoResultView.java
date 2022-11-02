package lotto.view;

import lotto.domain.LottoRankMatcher;
import lotto.domain.Rank;
import lotto.dto.LottoResultDto;

public class LottoResultView {

    public void lottoResult(LottoResultDto lottoResultDto) {
        System.out.println(lottoResultMessage(lottoResultDto));
    }

    public String lottoResultMessage(LottoResultDto lottoResultDto) {
        LottoRankMatcher lottoNumberMatcher = lottoResultDto.getLottoNumberMatcher();
        double profit = lottoResultDto.getProfit();
        return lottoResultMessage(lottoNumberMatcher, profit);
    }

    public String lottoResultMessage(LottoRankMatcher lottoNumberMatcher, double profit) {
        String result = "당첨 통계\n---------\n";
        for (Rank rank : Rank.getAllRanksExceptMiss()) {
            result += rankInfo(rank,lottoNumberMatcher.getMatchLottoRank(rank));
        }
        String profitString = "" + profit;
        profitString = profitString.length() < 4 ? profitString : profitString.substring(0,4);
        if(profit >= 1) {
            return result + "총 수익률은 " + profitString + "입니다.";
        }
        return result + "총 수익률은 " + profitString + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }

    private String rankInfo(Rank rank, int winningCount) {
        if(rank == Rank.SECOND) {
            return (rank.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + rank.getWinningMoney() + "원) - "
                    + winningCount + "개\n");
        }
        return (rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- "
                + winningCount + "개\n");
    }

}
