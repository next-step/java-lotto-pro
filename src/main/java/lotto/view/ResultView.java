package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

public class ResultView {

    public static final String EMPTY_MESSAGE = "";
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

    public void printLottoRewardResult(WinningNumbers winningNumbers, LottoTickets lottoTickets, Number bonusNumber) {
        System.out.println(EMPTY_MESSAGE);
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(STATISTICS_HYPHEN);

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, bonusNumber);
        LottoRewardResult lottoRewardResult = lottoStatistics.getLottoRewardResult(lottoTickets, bonusNumber);

        printLottoRewardStatistics(lottoRewardResult);
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

    private void printLottoRewardStatistics(LottoRewardResult lottoRewardResult) {
        for (int i = LottoReward.values().length - 1; i >= 0; i--) {
            LottoReward lottoReward = LottoReward.values()[i];
            printLottoRewardStatistics(lottoRewardResult, lottoReward);
        }
    }

    private void printLottoRewardStatistics(LottoRewardResult lottoRewardResult, LottoReward lottoReward) {
        if (lottoReward != LottoReward.MISS) {
            printNotMissLottoRewardStatistics(lottoRewardResult, lottoReward);
        }
    }

    private void printNotMissLottoRewardStatistics(LottoRewardResult lottoRewardResult, LottoReward lottoReward) {
        if (lottoReward == LottoReward.SECOND_PLACE) {
            System.out.println(lottoReward.getMatchCount() + "개 일치, 보너스 볼 일치 (" + lottoReward.getRewardMoney() + "원)- " + lottoRewardResult.getWinningLottoTicketCount(lottoReward));
            return;
        }
        System.out.println(lottoReward.getMatchCount() + "개 일치 (" + lottoReward.getRewardMoney() + "원)- " + lottoRewardResult.getWinningLottoTicketCount(lottoReward));
    }
}
