package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {
    @DisplayName("로또 구매 금액 - 숫자가 아니거나 음수 입력")
    @Test
    void lottoMoneyNonPositiveException() {
        assertThatThrownBy(() -> new LottoMoney("abc"))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoMoney("-123"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액 - 단위에 맞지 않는 금액 입력")
    @Test
    void lottoMoneyWrongUnitException() {
        assertThatThrownBy(() -> new LottoMoney("0"))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoMoney("123456"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
