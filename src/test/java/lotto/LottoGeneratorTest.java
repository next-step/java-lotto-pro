package lotto;

import lotto.money.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "17500:17", "0:0"}, delimiter = ':')
    @DisplayName("로또 구입 금액이 입력되면 구입할 수 있는 로또 갯수만큼 로또를 생성한다.")
    void generateLotto(int input, int expected) {
        LottoGenerator lottoGenerator =
                LottoGenerator.from(
                        LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy()),
                        Money.from(1000)
                );
        Lottos lottos = lottoGenerator.generate(Money.from(input));
        Assertions.assertThat(lottos.size()).isEqualTo(expected);
    }
}
