package lotto.domain.lotto;

import java.util.List;

@FunctionalInterface
public interface NumberPickStrategy {
    List<Lotto> pickNumbers(final int quantity);
}
