package step3.domain;

import java.util.List;

import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;
import step3.domain.factory.LottoNumbersFactory;

public class LottoBuyer {
    private final Amount amount;
    private LottoNumbersBundle boughtLottoNumberBundle;

    public LottoBuyer(Amount amount) {
        this.amount = amount;
    }

    public LottoBuyCount buyLotto(LottoNumbersBundle lottoNumbersBundle) {
        int manualBuyCount = lottoNumbersBundle.size();
        buyManualLotto(lottoNumbersBundle);
        return new LottoBuyCount.Builder()
            .setLottoManualLottoBuyCount(manualBuyCount)
            .setLottoAutoLottoBuyCount(buyAutoLotto())
            .build();
    }

    public void buyManualLotto(LottoNumbersBundle lottoNumbersBundle) {
        amount.minusAmountFrom(lottoNumbersBundle);
        lottoSave(lottoNumbersBundle);
    }

    public int buyAutoLotto() {
        int quantity = amount.buyAvailableQuantity();

        buyManualLotto(LottoNumbersFactory.createLottoNumbersBundle(quantity));
        return quantity;
    }

    public LottoRanks getLottoRanks(WinningLotto winningLotto) {
        return new LottoRanks.Build()
            .init()
            .setAmount(amount)
            .match(boughtLottoNumberBundle, winningLotto)
            .build();
    }

    public List<String> getLottoNumberList() {
        return boughtLottoNumberBundle.numbersForResults();
    }

    public void checkBuyAvailableQuantity(int buyQuantity) {
        if (!amount.isBuyAvailableQuantity(buyQuantity)) {
            throw new InvalidParamException(LottoConstant.EXCEEDING_AVAILABLE_QUANTITY);
        }
    }

    private void lottoSave(LottoNumbersBundle lottoNumbersBundle) {
        if (boughtLottoNumberBundle == null) {
            boughtLottoNumberBundle = lottoNumbersBundle;
            return;
        }

        this.boughtLottoNumberBundle.merge(lottoNumbersBundle);
    }

}
