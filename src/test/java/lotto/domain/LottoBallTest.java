package lotto.domain;

import lotto.exception.LottoBallNumberRangeException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoBallTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void notCreateLottoBall(int number) {
        ThrowableAssert.ThrowingCallable throwingCallable = () -> new LottoBall(number);

        assertThatExceptionOfType(LottoBallNumberRangeException.class)
                .isThrownBy(throwingCallable)
                .withMessageContaining("1~45 숫자를 입력해야 합니다.");
    }

}
