package lotto.domain.lotto;

import java.util.stream.Stream;

@FunctionalInterface
public interface NumberPickStrategy {
    Stream<LottoNumbers> pickNumbers(final int quantity);
}
