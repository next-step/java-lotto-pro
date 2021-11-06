package step3.domain;

import step3.domain.constance.LottoConstant;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomLottoNumbers;

public class LottoProvider {
    private final LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();

    public void buyLotto(int count, NumbersStrategy numbersStrategy) {
        for (int i = 0; i < count; i++) {
            lottoNumbersBundle.addLottoNumbers(numbersStrategy);
        }
    }

    public void buyLottoOfNumbersStrategy(NumbersStrategy numbersStrategy) {
        lottoNumbersBundle.addLottoNumbers(numbersStrategy);
    }

    public int availableQuantity(int amount) {
        return amount / LottoConstant.LOTTO_MINIMUM_PRICE;
    }

    public int lottoNumbersBundleSize() {
        return lottoNumbersBundle.size();
    }

    public LottoNumbersBundle getLottoNumbersBundle() {
        return lottoNumbersBundle;
    }

}
