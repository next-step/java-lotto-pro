package lotto.factory;

import java.util.List;
import lotto.number.LottoNumbers;

public interface LottoNumbersFactory {
    LottoNumbers createRandomLottoNumbers();

    LottoNumbers createLottoNumbers(List<Integer> numbers);
}
