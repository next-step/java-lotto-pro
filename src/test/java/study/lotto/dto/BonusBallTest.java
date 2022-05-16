package study.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusBallTest {
    @ParameterizedTest(name = "보너스볼: {0}")
    @ValueSource(strings = {"1", "45"})
    @DisplayName("보너스볼은 1부터 45까지의 숫자만 가능하다.")
    void 유효한_보너스볼(String input) {
        assertThat(new BonusBall(input)).isNotNull();
    }

    @Nested
    @DisplayName("무효한 보너스볼")
    class 무효한_보너스볼 {
        @ParameterizedTest(name = "보너스볼: {0}")
        @ValueSource(strings = {"0.1", "1,000", "문자"})
        @DisplayName("입력된 보너스볼 값이 정수가 아닌 경우 NumberFormatException을 발생시킨다.")
        void 숫자가_아닌_경우(String input) {
            assertThatThrownBy(() -> new BonusBall(input))
                    .isInstanceOf(NumberFormatException.class);
        }

        @ParameterizedTest(name = "보너스볼: {0}")
        @ValueSource(strings = {"0", "-1", "46"})
        @DisplayName("0이하 또는 46이상의 값을 입력하면 IllegalArgumentException을 발생시킨다.")
        void 최소값_최대값_검증(String input) {
            assertThatThrownBy(() -> new BonusBall(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
