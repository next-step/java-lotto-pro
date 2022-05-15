package lotto.domain.generator;

import lotto.domain.LottoNumbers;

@FunctionalInterface
public interface LottoNumbersGenerateStrategy {
    LottoNumbers generate();
}
