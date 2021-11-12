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

    public LottoBuyCount buyLotto(LottoNumbersBundle manualLottoNumbersBundle) {
        return new LottoBuyCount.Builder()
            .setLottoManualLottoBuyCount(buyManualLotto(manualLottoNumbersBundle))
            .setLottoAutoLottoBuyCount(buyAutoLotto())
            .build();
    }

    public int buyManualLotto(LottoNumbersBundle lottoNumbersBundle) {
        lottoBuyAndAmountMinus(lottoNumbersBundle.size(), lottoNumbersBundle);

        return lottoNumbersBundle.size();
    }

    public int buyAutoLotto() {
        int quantity = amount.buyAvailableQuantity();

        lottoBuyAndAmountMinus(quantity, LottoNumbersFactory.createLottoNumbersBundle(quantity));

        return quantity;
    }

    private void lottoBuyAndAmountMinus(int quantity, LottoNumbersBundle lottoNumbersBundle) {
        amount.minusAmountFrom(quantity);
        lottoSave(lottoNumbersBundle);
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
