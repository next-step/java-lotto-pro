package lotto;


import static lotto.LottoPrinter.print;

public class LottoStaticApp implements App {

    private static final String WELCOME = "당첨 통계\n---------";
    private static final String MATCH = "%s (%d원)- %d개";
    private static final String PROFIT = "총 수익률은 %.2f입니다.";
    private static final String PROFIT_EASTER_EGG = PROFIT + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private LottoBuyer lottoBuyer;
    private Lotto winLotto;
    private PayAmount payAmount;
    private BonusLottoNumber bonusLottoNumber;

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
        lottoBuyer.match(winLotto, bonusLottoNumber);
    }

    private void printLottoMatchStatistics(LottoMatchType lottoMatchType) {
        if (lottoMatchType.excludePrintAndMultiply()) {
            return;
        }
        Integer count = lottoBuyer.getLottoMatchTypeCount(lottoMatchType);
        print(String.format(MATCH,
            lottoMatchType.getPresentString(), lottoMatchType.getWinningAmount(), count));
    }

    private void printLottoProfitStatistics() {
        int sumProfit = lottoBuyer.getSumProfit();
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

        private LottoBuyer lottoBuyer;
        private Lotto winLotto;
        private PayAmount payAmount;
        private BonusLottoNumber bonusLottoNumber;

        public Builder lottoList(LottoBuyer lottoBuyer) {
            this.lottoBuyer = lottoBuyer;
            return this;
        }

        public Builder winLotto(Lotto winLotto) {
            this.winLotto = winLotto;
            return this;
        }

        public Builder bonusLottoNumber(BonusLottoNumber bonusLottoNumber) {
            this.bonusLottoNumber = bonusLottoNumber;
            return this;
        }

        public Builder payAmount(PayAmount payAmount) {
            this.payAmount = payAmount;
            return this;
        }

        public LottoStaticApp build() {
            LottoStaticApp app = new LottoStaticApp();
            app.lottoBuyer = this.lottoBuyer;
            app.winLotto = this.winLotto;
            app.payAmount = this.payAmount;
            app.bonusLottoNumber = this.bonusLottoNumber;
            return app;
        }
    }
}
