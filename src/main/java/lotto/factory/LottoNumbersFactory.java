package lotto.factory;

import java.util.List;
import lotto.number.LottoNumbers;

public interface LottoNumbersFactory {
    LottoNumbers createLottoNumbers(List<Integer> numbers);
}
