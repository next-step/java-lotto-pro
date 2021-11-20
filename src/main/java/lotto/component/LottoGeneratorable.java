package lotto.component;

import lotto.domain.Lotto;

@FunctionalInterface
public interface LottoGeneratorable {

    Lotto generate(final String numbers);
}
