package lotto.domain;

import lotto.exception.NegativeInputMoneyException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {


    @DisplayName("0보다 작은 수를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-10000, -5000})
    void givenLessThanZero(int input) {
        ThrowableAssert.ThrowingCallable throwingCallable = () -> new Money(input);

        assertThatExceptionOfType(NegativeInputMoneyException.class)
                .isThrownBy(throwingCallable)
                .withMessageContaining("0 이상의 수를 입력해야 합니다.");
    }

}
