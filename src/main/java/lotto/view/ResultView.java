package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningResult;
import lotto.domain.WinningResults;

public class ResultView {
    private static final String NOTICE_BUY_QUANTITY = "개를 구매했습니다.";
    private static final String NOTICE_WINNING_STATISTICS_RESULT = "%d개 일치 (%d원)- %d개";
    private static final String NOTICE_WINNING_STATISTICS = "당첨 통계\n---------";
    private static final String NOTICE_WINNING_REWARD_PERCENT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String ERROR_LOWER_THAN_MIN_PRICE = "최소 주문 금액(%d) 이하입니다.";
    private static final String NOTICE_END_GAME = "게임을 종료합니다.";

    public void printBuyMessage(Money money) {
        System.out.println(money.buyableQuantity() + NOTICE_BUY_QUANTITY);
    }

    public void printLottoList(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers().toString());
        }
    }

    public void printWinningResults(WinningResults results) {
        System.out.println(NOTICE_WINNING_STATISTICS);
        List<WinningResult> resultList = results.getWinningResult();
        for (WinningResult winningResult : resultList) {
            System.out.println(String.format(NOTICE_WINNING_STATISTICS_RESULT, winningResult.getWinningRank().getMatchCount(), winningResult.getWinningRank().getReward(), winningResult.getCount()));
        }
    }

    public void printWinningRewardPercent(double rewardPercent) {
        System.out.println(String.format(NOTICE_WINNING_REWARD_PERCENT, rewardPercent));
    }

    public void printLowerThanMinPrice() {
        System.out.println(String.format(ERROR_LOWER_THAN_MIN_PRICE, Money.LOTTO_BUY_PRICE));
        System.out.println(NOTICE_END_GAME);
    }
}
