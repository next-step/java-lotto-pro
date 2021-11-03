package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또숫자가 6개가 아니면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validate_count(String inputs) {
        assertThatThrownBy(() -> Lotto.from(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또숫자 중 중복된 숫자가 있으면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "15,16,17,18,19,19"})
    void validate_duplicate(String inputs) {
        assertThatThrownBy(() -> Lotto.from(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
