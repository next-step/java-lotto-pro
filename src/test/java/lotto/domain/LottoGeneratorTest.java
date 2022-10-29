package lotto.domain;

import lotto.generator.DefaultNumberGeneratorStrategy;
import lotto.generator.LottoGenerator;
import lotto.generator.LottoNumberGenerator;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

    private final LottoNumberGenerator lottoNumberGenerator =
            LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy());

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "17500:17", "1000:1"}, delimiter = ':')
    @DisplayName("로또 구입 금액이 입력되면 구입할 수 있는 로또 갯수만큼 로또를 생성한다.(로또 한 장당 가격은 1000원)")
    void generateLotto1(double input, int expected) {
        LottoGenerator lottoGenerator = LottoGenerator.from(lottoNumberGenerator);
        Lottos lottos = lottoGenerator.generate(Money.from(input));
        Assertions.assertThat(lottos.size()).isEqualTo(expected);
    }
}
