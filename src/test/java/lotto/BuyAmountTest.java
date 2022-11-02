package lotto;


import lotto.domain.BuyAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyAmountTest {

    @ParameterizedTest
    @DisplayName("구매금액 입력값이 유효성체크 통과하는지 확인")
    @CsvSource(value = {"5000:5000","1000:1000","2000000000:2000000000"}, delimiter = ':')
    void buyAmount_validate_test(int input, int expected) {
        assertThat((new BuyAmount(input)).isEqualValue(expected)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("구매금액으로 천원미만의 값, 문자, 음수, 0을 입력했을 경우 Exception을 던지는지 확인")
    @ValueSource(strings = {"500","aaa","-10","0"})
    void buyAmount_invalidate_test(String input) {
        assertThatThrownBy(() -> new BuyAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
