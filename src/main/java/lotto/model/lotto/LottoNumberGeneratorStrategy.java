package lotto.model.lotto;

import java.util.List;

public interface LottoNumberGeneratorStrategy {
    List<LottoNumber> generate();
}