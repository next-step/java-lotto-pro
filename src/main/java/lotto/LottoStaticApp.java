package lotto;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.LottoPrinter.print;

public class LottoStaticApp implements App {

    private static final String WELCOME = "당첨 통계\n---------";
    private static final String MATCH = "%d개 일치 (%d원)- %d개";
    private static final String PROFIT = "총 수익률은 %.2f입니다.";
    private static final String PROFIT_EASTER_EGG = PROFIT + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final HashMap<LottoMatchType, Integer> countMap = new HashMap<>();

    private List<Lotto> lottoList;
    private Lotto winLotto;
    private PayAmount payAmount;

    private LottoStaticApp() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public void run() {
        prepareLottoMatchStatistics();
        print(WELCOME);
        for (LottoMatchType lottoMatchType : LottoMatchType.values()) {
            printLottoMatchStatistics(lottoMatchType);
        }
        printLottoProfitStatistics();
    }

    private void prepareLottoMatchStatistics() {
        for (Lotto lotto : lottoList) {
            LottoMatchType lottoMatchType = lotto.match(winLotto);
            Integer count = countMap.getOrDefault(lottoMatchType, 0);
            countMap.put(lottoMatchType, ++count);
        }
    }

    private void printLottoMatchStatistics(LottoMatchType lottoMatchType) {
        if (lottoMatchType.dontPrint()) {
            return;
        }
        Integer count = countMap.getOrDefault(lottoMatchType, 0);
        print(String.format(MATCH,
            lottoMatchType.getMatchCount(), lottoMatchType.getWinningAmount(), count));
    }

    private void printLottoProfitStatistics() {
        int sumProfit = 0;
        for (Map.Entry<LottoMatchType, Integer> entry : countMap.entrySet()) {
            LottoMatchType lottoMatchType = entry.getKey();
            Integer count = entry.getValue();
            sumProfit += lottoMatchType.multiply(count);
        }
        double profitRate = payAmount.calculateProfitRate(sumProfit);
        if (profitRate < 1) {
            printEasterEggLottoProfitStatistics(profitRate);
            return;
        }
        print(String.format(PROFIT, profitRate));
    }

    private void printEasterEggLottoProfitStatistics(double profitRate) {
        print(String.format(PROFIT_EASTER_EGG, profitRate));
    }

    public static class Builder {

        private List<Lotto> lottoList;
        private Lotto winLotto;
        private PayAmount payAmount;

        public Builder lottoList(List<Lotto> lottoList) {
            this.lottoList = lottoList;
            return this;
        }

        public Builder winLotto(Lotto winLotto) {
            this.winLotto = winLotto;
            return this;
        }

        public Builder payAmount(PayAmount payAmount) {
            this.payAmount = payAmount;
            return this;
        }

        public LottoStaticApp build() {
            LottoStaticApp app = new LottoStaticApp();
            app.lottoList = this.lottoList;
            app.winLotto = this.winLotto;
            app.payAmount = this.payAmount;
            return app;
        }
    }
}
