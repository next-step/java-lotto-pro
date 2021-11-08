package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberRangeTest {
    @DisplayName("1 ~ 45 사이의 숫자는 true 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void isBetweenTrue(int number) {
        assertTrue(LottoNumberRange.isBetween(number));
    }

    @DisplayName("1 ~ 45 의 범위를 벗어난 숫자는 false 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void isBetweenFalse(int number) {
        assertFalse(LottoNumberRange.isBetween(number));
    }
}
