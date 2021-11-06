package lotto.ui;

import lotto.BuyAmount;
import lotto.LottoNumbersGroup;

public class LottoInputView {
    public static final String ASK_BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BUY_AMOUNT_MESSAGE = "%s개를 구매했습니다.";
    public static final String ASK_PRIZE_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private final BuyAmount buyAmount;

    public LottoInputView(BuyAmount buyAmount) {
        this.buyAmount = buyAmount;
    }

    public void showAskBuyPriceMessage() {
        System.out.println(ASK_BUY_PRICE_MESSAGE);
    }

    public void showBuyStats() {
        showBuyAmount();
        showMyLottoNumbers();
    }

    public void showBuyAmount() {
        System.out.printf(BUY_AMOUNT_MESSAGE, buyAmount.getAmount());
    }

    public void showMyLottoNumbers() {
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(buyAmount);
        System.out.println(lottoNumbersGroup);
    }

    public void showAskPrizeLottoNumbersMessage() {
        System.out.println(ASK_PRIZE_LOTTO_NUMBERS_MESSAGE);
    }
}
