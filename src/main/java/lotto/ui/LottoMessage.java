package lotto.ui;

import lotto.domain.BuyAmount;
import lotto.domain.LottoResults;

public class LottoMessage {
    public static final String MINIMUM_TICKET_PRICE_MESSAGE = "구입 금액을 확인해 주세요.";
    public static final String WRONG_NUMBER_FORMAT_MESSAGE = "입력된 숫자를 확인해 주세요.";
    public static final String WRONG_NUMBER_BOUND_MESSAGE = "입력된 숫자의 범위를 확인해 주세요.";
    public static final String WRONG_LOTTO_NUMBER_SIZE_MESSAGE = "입력하신 로또의 개수를 확인 해 주세요.";
    public static final String EXCEED_MANUAL_LOTTO_SIZE_MESSAGE = "수동 로또 구매 수를 확인해 주세요.";
    public static final String WRONG_LOTTO_NUMBER_INPUT_MESSAGE = "수동 입력 로또 번호를 확인해 주세요.";

    public static final String ASK_BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ASK_MANUAL_BUY_AMOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String ASK_MANUAL_BUY_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String BUY_AMOUNT_MESSAGE = "%s개를 구매했습니다.";
    public static final String ASK_PRIZE_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String ASK_BONUS_LOTTO_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String RESULT_STATS_TITLE = "당첨 통계";
    public static final String RESULT_SEPARATE_LINE = "---------";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";

    public static void showAskBuyPriceMessage() {
        System.out.println(ASK_BUY_PRICE_MESSAGE);
    }

    public static void showAskManualBuyAmountMessage() {
        System.out.println(ASK_MANUAL_BUY_AMOUNT_MESSAGE);
    }

    public static void showAskManualBuyLottoNumbersMessage() {
        System.out.println(ASK_MANUAL_BUY_LOTTO_NUMBERS_MESSAGE);
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

    public static void showTotalReward(LottoResults lottoResults) {
        System.out.println(lottoResults.getTotalReward());
    }

    public static void showProfitRate(BuyAmount buyAmount, LottoResults lottoResults) {
        System.out.printf(PROFIT_RATE_MESSAGE, buyAmount.getProfitRate(lottoResults.getTotalReward()));
    }

    public static void showAskBonusNumber() {
        System.out.println(ASK_BONUS_LOTTO_NUMBER_MESSAGE);
    }
}
