package lotto.generator;

import java.util.List;
import lotto.domain.lotto.LottoNumber;

public interface LottoNumberGeneratorStrategy {
    List<LottoNumber> generate();
}