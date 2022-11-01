package lotto.domain;

import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.generator.DefaultNumberGeneratorStrategy;
import lotto.generator.LottoGenerator;
import lotto.generator.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator =
            LottoGenerator.from(LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy()));

    @ParameterizedTest(name = "{index} | {displayName} | 구입금액 = {0}, 구입할 수 있는 로또갯수 = {1}")
    @CsvSource(value = {"14000:14", "17500:17", "1000:1"}, delimiter = ':')
    @DisplayName("로또 구입 금액이 입력되면 구입할 수 있는 로또 갯수만큼 로또를 생성한다.(로또 한 장당 가격은 1000원)")
    void generateLotto1(double input, int expected) {
        int autoCount = Money.from(input).purchasableQuantity();

        Lottos lottos = lottoGenerator.generate(autoCount);

        Assertions.assertThat(lottos.size()).isEqualTo(expected);
    }
}
