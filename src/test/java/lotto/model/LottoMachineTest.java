package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoMachineTest {
    LottoMachine lottoMachine = new LottoMachine();

    @ParameterizedTest(name = "입력숫자 {0}이면 {1}만큼의 로또가 생성된 리스트를 반환한다.")
    @CsvSource(value = {"1|1", "3|3", "5|5"}, delimiter = '|')
    void 로또_생성_test(int input, int result) {
        List<Lotto> lottos = lottoMachine.generateLottos(input);
        assertThat(lottos).hasSize(result);
    }

    @ParameterizedTest(name = "구매금액이 {0}이면 {1}만큼의 로또가 생성된 리스트를 반환한다.")
    @CsvSource(value = {"1000|1", "10000|10", "20000|20"}, delimiter = '|')
    void 로또_구매_test(int money, int result) {
        assertThat(lottoMachine.purchase(money)).hasSize(result);
    }

    @ParameterizedTest(name = "구매금액이 1000단위가 아닌 숫자 {0}을 입력하면 IllegalArgumentException을 발생시킨다.")
    @ValueSource(ints = {-5, 0, 1200})
    void 로또_구매_예외_test(int money) {
        assertThatThrownBy(() -> lottoMachine.purchase(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
