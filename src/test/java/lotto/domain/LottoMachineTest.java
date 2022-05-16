package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    @Test
    @DisplayName("발급 성공 테스트")
    void 발급_테스트() {
        // when & then
        Assertions.assertThat(LottoMachine.purchase("2000")).isInstanceOf(Lottos.class);
    }

    @Test
    @DisplayName("숫자형식이 아닌 사용자 입력")
    void 발급_실패_숫자형식() {
        // when & then
        assertThatThrownBy(() ->LottoMachine.purchase("test"))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "500", "1000.5"})
    @DisplayName("구매가 불가능한 금액 입력")
    void 발급_실패_구매불가(String price) {
        // when & then
        assertThatThrownBy(() -> LottoMachine.purchase(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 종료시 당첨 번호를 숫자가 아닌 입력을 했을 때")
    void 로또_종료_실패_숫자가_아님() {
        // when & then
        assertThatThrownBy(() -> LottoMachine.winningLottoNumbers("1,2,a,4,b,6"))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1, 1, 2,3,4,500", "2,3,4,5", "1,1,1,2,2,2"})
    @DisplayName("로또 종료시 당첨 번호를 로또 번호를 벗어난 입력을 했을 때 혹은 6개를 입력 하지 않았을 떄")
    void 로또_종료_실패_로또_번호가_아님(String winningNumber) {
        // when & then
        assertThatThrownBy(() -> LottoMachine.winningLottoNumbers(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}