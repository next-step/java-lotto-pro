package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @DisplayName("정상적으로 로또를 생성한다")
    @RepeatedTest(10)
    void lottoNumbersTest() {
        assertNotNull(LottoFactory.createLotto());
    }

    @DisplayName("문자열로 전달된 번호를 숫자로 변환한다")
    @Test
    void convertInputNumbersToNumbers() {
        LottoFactory.createManualLotto("1, 10, 15, 20, 25, 30");
    }

    @DisplayName("문자열에 음수나 문자가 포함된 경우 예외가 발생한다")
    @Test
    void convertInputNumbersToNumbersException() {
        assertThatThrownBy(() -> LottoFactory.createManualLotto("a,b,c,d,e,f"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_POSITIVE_LOTTO_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> LottoFactory.createManualLotto("-1,-2,-3,-4,-5,-6"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_POSITIVE_LOTTO_NUMBER_MESSAGE.getMessage());
    }
}
