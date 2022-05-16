package lotto.model.purchased;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lotto.model.factory.LottoAutoFactory;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import lotto.type.LottoGeneratorType;
import lotto.type.LottoWinningPriceType;

public class PurchasedLotto {

    private LottoGeneratorType lottoGeneratorType;
    private LottoNumbers lottoNumbers;

    public PurchasedLotto(LottoNumbers lottoNumbers, LottoGeneratorType lottoGeneratorType) {
        this.lottoNumbers = lottoNumbers;
        this.lottoGeneratorType = lottoGeneratorType;
    }

    public Optional<LottoWinningPriceType> checkWinning(LottoNumbers winningLottos) {
        int correctCount = lottoNumbers.countContainLottoNumber(winningLottos);

        return LottoWinningPriceType.getByCorrectCount(correctCount);
    }

    public String toLottoNumbersString() {
        return lottoNumbers.toLottoNumbersString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchasedLotto that = (PurchasedLotto) o;
        return lottoGeneratorType == that.lottoGeneratorType && Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGeneratorType, lottoNumbers);
    }

}
