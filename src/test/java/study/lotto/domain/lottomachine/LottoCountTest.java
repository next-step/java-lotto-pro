package study.lotto.domain.lottomachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoCountTest {
    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"asdb", "1.6"})
    @DisplayName("정수가 아닌 값을 입력 받으면 예외를 발생 시킨다.")
    void 숫자외_입력시_예외처리(String input) {
        assertThatThrownBy(() -> new LottoCount(input)).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"-1", "-100"})
    @DisplayName("로또 개수가 0보다 작거면 예외를 발생 시킨다.")
    void 음수_예외처리(String input) {
        assertThatThrownBy(() -> new LottoCount(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
