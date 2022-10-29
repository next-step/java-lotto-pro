package step3.view;

import step3.constant.OutputMessage;
import step3.model.Game;
import step3.model.LottoReward;


public class OutputView {
    public static void printLottoBuyCount(int count) {
        System.out.printf(OutputMessage.OUTPUT_LOTTO_BUY_COUNT, count);
    }

    public static void printBuyLottoResult(Game game) {
        game.getLottoResults().forEach(System.out::println);
    }

    public static void printLottoStatistics(Game game) {
        System.out.println();
        System.out.println(OutputMessage.OUTPUT_GAME_RESULT);
        System.out.println(OutputMessage.OUTPUT_STATISTICS_LINE);
        game.getLottoWinningStatistics().getLottoWinningStatistics().forEach(OutputView::printLottoStatistic);
        System.out.printf(OutputMessage.OUTPUT_WINNERS_PROFIT_PERCENT, game.getLottoWinningStatistics().getTotalProfitPercent(game.getMoney()));
    }

    private static void printLottoStatistic(int matchCount, int count) {
        if (matchCount > 2) {
            System.out.printf(OutputMessage.OUTPUT_WINNERS_PROFIT_MESSAGE, matchCount, LottoReward.getLottoReward(matchCount).getMoney(), count);
        }
    }
}
