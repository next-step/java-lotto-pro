package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.exception.LottoFormatException;

import static org.assertj.core.api.Assertions.*;

@DisplayName("금액_WRAPPING_클래스")
public class MoneyTest {
    @DisplayName("Money_정상_입력")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1000"})
    void Money_pass_01(String text) {
        assertThatNoException().isThrownBy(() -> new Money(text));
    }

    @DisplayName("Money_숫자_아니면_에러")
    @ParameterizedTest
    @ValueSource(strings = {",", "a", "a1", ""})
    void Money_fail_01(String text) {
        assertThatThrownBy(() -> new Money(text))
                .isInstanceOf(LottoFormatException.class);
    }

    @DisplayName("Money_숫자_음수면_에러")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10000"})
    void Money_fail_02(String text) {
        assertThatThrownBy(() -> new Money(text))
                .isInstanceOf(LottoFormatException.class);
    }

    @DisplayName("Money_숫자_equal_test")
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "45:45:true", "1:45:false"}, delimiter = ':')
    void Money_equal_test_01(String number, String otherNumber, boolean expected) {
        Money money = new Money(number);
        Money otherMoney = new Money(otherNumber);
        assertThat(money.equals(otherMoney)).isEqualTo(expected);
    }

    @DisplayName("Money_나누기_test")
    @Test
    void Money_plus_test_01() {
        Money money = new Money(1000);
        money.plus(new Money(1000));
        assertThat(money).isEqualTo(new Money(2000));
    }

    @DisplayName("Money_나누기_test")
    @Test
    void Money_divideValue_test_01() {
        Money money = new Money(1000);
        assertThat(money.divideValue(new Money(1000))).isEqualTo(1);
    }

    @DisplayName("Money_퍼센트_반환_test")
    @Test
    void Money_getPercent_test_01() {
        Money money = new Money(1000);
        Money otherMoney = new Money(2000);
        assertThat(money.getPercent(otherMoney)).isEqualTo(0.5);
    }
}
