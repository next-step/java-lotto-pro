package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.Lotto.MINIMUM_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또")
class LottoTest {

    @DisplayName("1미만의 수를 가질 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0})
    void minimumNumber(int number) {
        assertThatThrownBy(() -> new Lotto(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MINIMUM_NUMBER + "보다 작을 수 없습니다.");
    }
}
