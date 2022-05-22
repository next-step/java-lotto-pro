package lotto.generator;

import lotto.model.LottoNumber;

import java.util.List;

public interface LottoNumbersGenerator {
    List<LottoNumber> drawNumbers();
}
