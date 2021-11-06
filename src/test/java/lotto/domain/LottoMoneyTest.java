package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMoneyTest {
    @DisplayName("로또 구매 금액은 음수나 문자가 될 수 없다")
    @Test
    void lottoMoneyNonPositiveException() {
        assertThatThrownBy(() -> new LottoMoney("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_POSITIVE_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> new LottoMoney("-123"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_POSITIVE_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("로또 구매 금액은 1000원 단위만 가능하다")
    @Test
    void lottoMoneyWrongUnitException() {
        assertThatThrownBy(() -> new LottoMoney("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.WRONG_LOTTO_AMOUNT_UNIT.getMessage());

        assertThatThrownBy(() -> new LottoMoney("123456"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.WRONG_LOTTO_AMOUNT_UNIT.getMessage());
    }

    @DisplayName("로또 구매 가능 갯수")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "12000, 12", "15000,15", "50000,50"})
    void countOfPossibleLotto(String amount, int expected) {
        LottoMoney lottoMoney = new LottoMoney(amount);
        assertEquals(expected, lottoMoney.getCountOfPossibleLotto());
    }

    @DisplayName("로또 수익률")
    @ParameterizedTest
    @CsvSource(value = {"14000,5000,0.35", "10000,20000,2", "1000000,5000,0"})
    void profitRatio(String lottoAmount, int profitAmount, double expected) {
        LottoMoney lottoMoney = new LottoMoney(lottoAmount);
        double profitRatio = lottoMoney.calculateProfitRatio(profitAmount);
        assertEquals(expected, profitRatio);
    }
}
