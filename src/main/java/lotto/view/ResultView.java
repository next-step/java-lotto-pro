package lotto.view;

import lotto.domain.*;

public class ResultView {

    public static final String STATISTICS_MESSAGE = "당첨 통계";
    public static final String STATISTICS_HYPHEN = "---------";
    public static final String PROFIT_MESSAGE = "이익";
    public static final String DAMAGE_MESSAGE = "손해";
    public static final String ORIGIN_MESSAGE = "본전";

    public void printLottoTicketCount(int lottoTicketCount) {
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTicketsString());
    }

    public void printLottoRewardResult(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(STATISTICS_HYPHEN);

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers);
        LottoRewardResult lottoRewardResult = lottoStatistics.getStatistics(lottoTickets);

        printLottoRewardStatistics(LottoReward.FOURTH_PLACE, lottoRewardResult);
        printLottoRewardStatistics(LottoReward.THIRD_PLACE, lottoRewardResult);
        printLottoRewardStatistics(LottoReward.SECOND_PLACE, lottoRewardResult);
        printLottoRewardStatistics(LottoReward.FIRST_PLACE, lottoRewardResult);

        printRateOfProfit(lottoStatistics.getRateOfProfit(lottoTickets, lottoRewardResult));
    }

    private void printRateOfProfit(double rateOfProfit) {
        double rateOfProfitResult = Math.floor(rateOfProfit * 100) / 100.0;
        System.out.println("총 수익률은 " + rateOfProfitResult + "입니다.(기준이 1이기 때문에 결과적으로는 " + getProfitResult(rateOfProfitResult) + "(이)라는 의미임)");
    }

    private String getProfitResult(double rateOfProfitResult) {
        if (rateOfProfitResult > 1) {
            return PROFIT_MESSAGE;
        }
        if (rateOfProfitResult < 1) {
            return DAMAGE_MESSAGE;
        }
        return ORIGIN_MESSAGE;
    }

    private void printLottoRewardStatistics(LottoReward lottoReward, LottoRewardResult lottoRewardResult) {
        System.out.println(lottoReward.getMatchCount() + "개 일치 (" + lottoReward.getRewardMoney() + "원)- " + lottoRewardResult.getWinningLottoTicketCount(lottoReward));
    }
}
