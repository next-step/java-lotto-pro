package step3.domain;

import java.util.List;

import step3.domain.constance.LottoConstant;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomLottoNumbers;

public class LottoProvider {
    private final LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();

    public LottoNumbersBundle buyLotto(int count, NumbersStrategy numbersStrategy) {
        for (int i = 0; i < count; i++) {
            lottoNumbersBundle.addLottoNumbers(numbersStrategy);
        }
        return lottoNumbersBundle;
    }

    public int availableQuantity(Amount amount) {
        return amount.getAmount() / LottoConstant.LOTTO_MINIMUM_PRICE;
    }

    public int lottoNumbersBundleSize() {
        return lottoNumbersBundle.size();
    }

    public LottoResult getLottoResult(LottoNumbers lottoNumbers, Amount amount) {
        return new LottoResult(
            lottoNumbersBundle.lottoRanksOf(lottoNumbers),
            amount
        );
    }
}
