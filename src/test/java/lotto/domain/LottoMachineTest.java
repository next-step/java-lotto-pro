package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    @Test
    @DisplayName("로또 금액 부족 오류 테스트")
    void lotto_lack_money_test() {
        assertThatThrownBy(() -> LottoMachine.purchase(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액에 맞는 로또 갯수 구입 테스트")
    void lotto_buy_test() {
        LottoMachine.purchase(5000);
        assertThat(LottoMachine.purchase(5000).size())
                .isEqualTo(5);
    }

}