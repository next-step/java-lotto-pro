package step3.domain.strategy.lotto;

import step3.domain.LottoNumbersBundle;
import step3.domain.strategy.numbers.NumbersStrategy;

public interface LottoProviderStrategy {
    void buyLotto(int count);

    void buyLottoOfNumbersStrategy(NumbersStrategy numbersStrategy);

    int lottoNumbersBundleSize();

    int availableQuantity(int amount);

    LottoNumbersBundle getLottoNumbersBundle();
}
