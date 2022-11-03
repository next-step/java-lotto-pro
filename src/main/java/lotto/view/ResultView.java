package lotto.view;

import lotto.domain.*;

public class ResultView {

    public static void printPurchasedLottoCnt(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + Messages.NOTIFY_PURCHASES.getMsg());
    }

    public static void printGeneratedLotto(Lottos lottos) {
        lottos.getLottoList().stream().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printTotalResult(Payment payment, Statistics statistics) {
        System.out.println(Messages.WIN_STATISTICS.getMsg());
        System.out.println(Messages.MESSAGE_DELIMITER.getMsg());

        for (Winning winning : Winning.getWinningInfo()) {
            int matches = winning.getMatches();
            int reward = winning.getReward();
            int lottoCnt = statistics.getLottoCntByWinning(winning);
            String msg = winning == winning.SECOND ?
                    Messages.SHOW_SECOND_WINNING_INFO.getMsg() : Messages.SHOW_WINNING_INFO.getMsg();
            System.out.println(String.format(msg, matches, reward, lottoCnt));
        }

        double yield = statistics.getYield(payment);
        String msg = String.format(Messages.SHOW_TOTAL_YIELD.getMsg(), yield);
        System.out.println(msg);
    }

}
