package lotto.module;

import lotto.domain.LottoNumbers;

import java.util.List;

public interface NumberGeneratorStrategy {
    List<LottoNumbers> createLottos();
}
