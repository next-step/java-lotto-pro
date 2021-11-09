package step3.domain;

import java.util.List;

import step3.domain.strategy.numbers.NumbersStrategy;

public class LottoProvider {

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

    public LottoRanks getLottoResult(LottoNumbersBundle baseLottoNumberBundle,
        LottoNumbersBundle autoLottoNumbersBundle, WinningLotto winningLotto) {
        baseLottoNumberBundle.merge(autoLottoNumbersBundle);
        return baseLottoNumberBundle.lottoRanksOf(winningLotto);
    }
}
