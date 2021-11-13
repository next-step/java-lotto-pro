package step3.component;

import step3.domain.Lotto;

@FunctionalInterface
public interface LottoGeneratorable {

    Lotto generate(final String numbers);
}
