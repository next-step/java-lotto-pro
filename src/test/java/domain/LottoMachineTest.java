package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {
    @ParameterizedTest
    @CsvSource(value = {"10000|10", "14000|14"}, delimiter = '|')
    void 금액에_따른_로또를_발급한다(int price, int expectedAmount) {
        List<Lotto> lottos = LottoMachine.issueLottos(price);
        assertThat(lottos).hasSize(expectedAmount);
    }
}
