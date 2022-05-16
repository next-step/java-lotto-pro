package lotto.generator;

import java.util.Set;
import lotto.model.LottoNumber;

public interface LottoNumberGenerator {
    Set<LottoNumber> generate();
}
