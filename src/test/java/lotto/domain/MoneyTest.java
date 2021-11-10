package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    Money money;

    @BeforeEach
    void setUp() {
        money = new Money(3000);
    }

    @Test
    void 음수() {
        // given
        int money = -1;

        // when, then
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 0 이상이어야 합니다. (입력값: " + money + ")");
    }

    @ParameterizedTest
    @CsvSource(value = {"2000:false", "4000:true"}, delimiter = ':')
    void 주어진_수보다_작은지_검사(int inputNumber, boolean expectResult) {
        // when
        boolean result = money.isLessThan(inputNumber);

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:3", "2000:1", "3000:1", "4000:0"}, delimiter = ':')
    void 몫_계산(int inputMoney, int expectResult) {
        // when
        int result = money.divide(inputMoney);

        // then
        assertThat(result).isEqualTo(expectResult);
    }
}