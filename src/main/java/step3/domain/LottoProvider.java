package step3.domain;

import step3.domain.constance.LottoConstant;
import step3.domain.strategy.lotto.LottoProviderStrategy;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomNumbers;

public class LottoProvider implements LottoProviderStrategy {
    private static final int PRICE = 1000;
    private final LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();

    public void buyLotto(int count) {
        for (int i = 0; i < count; i++) {
            lottoNumbersBundle.addLottoNumbers(getRandomNumberStrategy());
        }
    }

    public void buyLottoOfNumbersStrategy(NumbersStrategy numbersStrategy) {
        lottoNumbersBundle.addLottoNumbers(numbersStrategy);
    }

    public int availableQuantity(int amount) {
        return amount / PRICE;
    }

    public int lottoNumbersBundleSize() {
        return lottoNumbersBundle.size();
    }

    public LottoNumbersBundle getLottoNumbersBundle() {
        return lottoNumbersBundle;
    }

    private NumbersStrategy getRandomNumberStrategy() {
        return new RandomNumbers(LottoConstant.MIN_NUMBER_RANGE,
            LottoConstant.MAX_NUMBER_RANGE, LottoConstant.MAX_LOTTO_NUMBERS_SIZE);
    }

}
