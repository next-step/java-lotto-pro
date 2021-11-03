package lotto.module;

import lotto.domain.LottoNumbers;

public interface NumberGeneratorStrategy {
    LottoNumbers createLotto();
}
