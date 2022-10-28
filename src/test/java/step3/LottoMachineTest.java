package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"0,200", "100,500", "400,1000"})
    @DisplayName("로또 구매 돈과 로또 가격을 입력받을때 로또 가격보다 돈이 없을경우 에러")
    void givenLessMoney_whenConstructLottoMachine_thenThrow(int money, int lottoPrice) {
        assertThatThrownBy(() -> new LottoMachine(lottoPrice, money))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("부족");
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,1000,14", "16500,1000,16", "4000,1000,4"})
    @DisplayName("로또 구매 돈과 로또 가격을 입력받을때 로또 가격보다 돈이 클경우 구매한 로또 갯수를 리턴")
    void givenMoney_whenConstructLottoMachine_thenTicketCount(int money, int lottoPrice, int havingCount) {
        LottoMachine lottoMachine = new LottoMachine(lottoPrice);

        assertThat(lottoMachine.receiveMoney(money)).isEqualTo(havingCount);
    }
}
