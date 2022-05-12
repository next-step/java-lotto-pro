package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositiveNumbersTest {
    private static final String[] NEGATIVE_SPLITS = {"1", "-3", "5"};
    private static final String[] NOT_NUMBER_SPLITS = {"1", "pe", "5"};
    private static final String[] SPLITS = {"1", "4", "5"};

    @DisplayName("음수가 포함된 문자열들로 초기화하면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void fromNegative() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PositiveNumbers.from(NEGATIVE_SPLITS))
                .withMessage("음수가 입력되어 유효하지 않습니다.");
    }

    @DisplayName("숫자가 아닌 문자열들로 초기화하면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void fromNotNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PositiveNumbers.from(NOT_NUMBER_SPLITS))
                .withMessage("유효하지 않은 입력값입니다.");
    }

    @DisplayName("문자열  커스텀 구분자로 숫자합을 반환한다")
    @Test
    void fromAndSum() {
        assertThat(PositiveNumbers.from(SPLITS).getSum()).isEqualTo(10);
    }
}
