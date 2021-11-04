package lotto.domain;

import lotto.domain.startegy.generationstrategy.AutoNumberGenerationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("구입금액에 맞게 로또를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"1500,1", "5000,5", "10000,10"})
    void buy(int payment, int count) {
        List<String> manualLottos = Arrays.asList("1,2,3,4,5,6");

        assertThat(LottoMachine.buy(Payment.from(payment), new AutoNumberGenerationStrategy(), manualLottos).count()).isEqualTo(count);
    }

}
