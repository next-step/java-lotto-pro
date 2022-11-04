package lotto.common.vo;

import common.vo.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static common.vo.Number.MAXIMUM_NUMBER;
import static common.vo.Number.MINIMUM_NUMBER;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또")
class NumberTest {

    @DisplayName("1미만의 수를 가질 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0})
    void minimumNumber(int number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MINIMUM_NUMBER + "보다 작을 수 없습니다.");
    }

    @DisplayName("45 초과의 수를 가질 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {46})
    void maximumNumber(int number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MAXIMUM_NUMBER + "보다 클 수 없습니다.");
    }

    @DisplayName("로또 번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void constructor(int number) {
        assertThatNoException().isThrownBy(() -> new Number(number));
    }
}
