package lotto;

import lotto.money.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

    private final LottoNumberGenerator lottoNumberGenerator =
            LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy());

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "17500:17", "0:0"}, delimiter = ':')
    @DisplayName("로또 구입 금액이 입력되면 구입할 수 있는 로또 갯수만큼 로또를 생성한다.(로또 한 장당 가격은 1000원)")
    void generateLotto1(int input, int expected) {
        LottoGenerator lottoGenerator = LottoGenerator.of(lottoNumberGenerator, Money.from(1000));
        Lottos lottos = lottoGenerator.generate(Money.from(input));
        Assertions.assertThat(lottos.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:14", "2000:7", "7000:2"}, delimiter = ':')
    @DisplayName("로또 구입 금액이 고정(14000)되어 있을 때 로또 가격에 따른 구입할 수 있는 로또 갯수 확인")
    void generateLotto2(int input, int expected) {
        LottoGenerator lottoGenerator = LottoGenerator.of(lottoNumberGenerator, Money.from(input));
        Lottos lottos = lottoGenerator.generate(Money.from(14000));
        Assertions.assertThat(lottos.size()).isEqualTo(expected);
    }
}
