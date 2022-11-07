package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @ParameterizedTest
    @CsvSource(value = {"10000|10", "14000|14"}, delimiter = '|')
    void 금액에_따른_로또를_발급한다(int price, int expectedAmount) {
        Lottos lottos = LottoMachine.issueLottos(price);
        assertThat(lottos.size()).isEqualTo(expectedAmount);
    }
}
