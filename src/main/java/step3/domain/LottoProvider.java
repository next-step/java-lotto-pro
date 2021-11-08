package step3.domain;

import java.util.List;

import step3.domain.constance.LottoConstant;
import step3.domain.strategy.numbers.NumbersStrategy;

public class LottoProvider {
    // @Deprecated
    // private final LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();

    public LottoNumbersBundle buyLotto(int count, NumbersStrategy numbersStrategy) {
        LottoNumbersBundle result = new LottoNumbersBundle();
        for (int i = 0; i < count; i++) {
            result.addLottoNumbers(numbersStrategy);
        }

        return result;
    }

    public LottoNumbersBundle buyLotto(List<NumbersStrategy> numbersStrategies) {
        LottoNumbersBundle result = new LottoNumbersBundle();
        for (NumbersStrategy numbersStrategy : numbersStrategies) {
            result.addLottoNumbers(numbersStrategy);
        }

        return result;
    }

    public int availableQuantity(Amount amount) {
        return amount.getAmount() / LottoConstant.LOTTO_MINIMUM_PRICE;
    }

    // @Deprecated
    // public int lottoNumbersBundleSize() {
    //     return lottoNumbersBundle.size();
    // }

    // @Deprecated
    // public LottoResult getLottoResult(LottoNumbersBundle lottoNumbersBundle, WinningLotto winningLotto) {
    //     LottoRanks lottoRanks = lottoNumbersBundle.lottoRanksOf(winningLotto);
    //     return new LottoResult(lottoRanks);
    // }

    public LottoRanks getLottoResult(LottoNumbersBundle lottoNumbersBundle, WinningLotto winningLotto) {
        return lottoNumbersBundle.lottoRanksOf(winningLotto);
    }
}
