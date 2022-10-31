package lotto.domain.lotto;

import lotto.generator.DefaultNumberGeneratorStrategy;
import lotto.generator.LottoGenerator;
import lotto.generator.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    private final LottoGenerator lottoGenerator =
            LottoGenerator.from(LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy()));

    @Test
    @DisplayName("Lottos add 한 결과가 각각의 Lottos 크기의 합과 같은지 확인")
    void add() {
        Lottos lottos1 = lottoGenerator.generate(1);
        Lottos lottos2 = lottoGenerator.generate(2);

        Lottos results = lottos1.add(lottos2);

        Assertions.assertThat(results.size()).isEqualTo(3);
    }
}
