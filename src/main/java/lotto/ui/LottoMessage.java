package lotto.ui;

import lotto.BuyAmount;
import lotto.LottoNumbersGroup;
import lotto.LottoResults;

public class LottoMessage {
    public static final String ASK_BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BUY_AMOUNT_MESSAGE = "%s개를 구매했습니다.";
    public static final String ASK_PRIZE_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String RESULT_STATS_TITLE = "당첨 통계";
    public static final String RESULT_SEPARATE_LINE = "---------";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";

    public static void showAskBuyPriceMessage() {
        System.out.println(ASK_BUY_PRICE_MESSAGE);
    }

    public static void showBuyAmount(BuyAmount buyAmount) {
        System.out.printf(BUY_AMOUNT_MESSAGE + System.lineSeparator(), buyAmount.getAmount());
    }

    public static void showAskPrizeLottoNumbersMessage() {
        System.out.println(ASK_PRIZE_LOTTO_NUMBERS_MESSAGE);
    }

    public static void showResultsTitle() {
        System.out.println(RESULT_STATS_TITLE);
        System.out.println(RESULT_SEPARATE_LINE);
    }

    public static void showResultsStats(LottoResults lottoResults) {
        System.out.println(lottoResults);
    }

    public static void showTotalReward(LottoResults lottoResults) {
        System.out.println(lottoResults.getTotalReward());
    }

    public static void showProfitRate(BuyAmount buyAmount, LottoResults lottoResults) {
        System.out.printf(PROFIT_RATE_MESSAGE, buyAmount.getProfitRate(lottoResults.getTotalReward()));
    }
}
