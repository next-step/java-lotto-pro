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

    public void buyLotto(LottoNumbersBundle lottoNumbersBundle) {
        amount.minusAmountFrom(lottoNumbersBundle);
        lottoSave(lottoNumbersBundle);
    }

    public void autoBuyLotto() {
        int qty = amount.buyAvailableQuantity();

        buyLotto(LottoNumbersFactory.createLottoNumbersBundle(qty));
    }

    private void lottoSave(LottoNumbersBundle lottoNumbersBundle2) {
        if (boughtLottoNumberBundle == null) {
            boughtLottoNumberBundle = lottoNumbersBundle2;
            return;
        }

        this.boughtLottoNumberBundle.merge(lottoNumbersBundle2);
    }

    public LottoRanks getLottoRanks(WinningLotto winningLotto) {
        return boughtLottoNumberBundle.lottoRanksOf(winningLotto, amount);
    }

    public int countOf(BuyType buyType) {
        return boughtLottoNumberBundle.countOf(buyType);
    }

    public List<String> getLottoNumberList() {
        return boughtLottoNumberBundle.numbersForResults();
    }

    public void checkBuyAvailableQuantity(int buyQuantity) {
        if (!amount.isBuyAvailableQuantity(buyQuantity)) {
            throw new InvalidParamException(LottoConstant.EXCEEDING_AVAILABLE_QUANTITY);
        }
    }
}
