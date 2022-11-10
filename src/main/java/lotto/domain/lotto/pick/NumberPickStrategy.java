package lotto.domain.lotto.pick;

import java.util.stream.Stream;
import lotto.domain.lotto.LottoNumbers;

@FunctionalInterface
public interface NumberPickStrategy {
    Stream<LottoNumbers> pickNumbers(final int quantity);
}
