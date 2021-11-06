package lotto.ui;

import lotto.BuyAmount;
import lotto.LottoNumbersGroup;

public class LottoInputView {

    private final BuyAmount buyAmount;
    private final LottoNumbersGroup lottoNumbersGroup;

    public LottoInputView(BuyAmount buyAmount, LottoNumbersGroup lottoNumbersGroup) {
        this.buyAmount = buyAmount;
        this.lottoNumbersGroup = lottoNumbersGroup;
    }

    public void showBuyStats() {
        LottoMessage.showBuyAmount(buyAmount);
        LottoMessage.showMyLottoNumbers(lottoNumbersGroup);
    }
}
