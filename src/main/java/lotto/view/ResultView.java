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
            int match = winning.getMatches();
            int reward = winning.getReward();
            int lottoCnt = statistics.getMatchedLottoCnt(match);
            String msg = String.format(Messages.SHOW_MATCHES_INFO.getMsg(), match, reward, lottoCnt);
            System.out.println(msg);
        }

        double yield = statistics.getYield(payment);
        String msg = String.format(Messages.SHOW_TOTAL_YIELD.getMsg(), yield);
        System.out.println(msg);
    }

}
