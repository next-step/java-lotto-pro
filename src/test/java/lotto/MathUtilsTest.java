package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MathUtilsTest {

    private final double value = 3.4567;

    @ParameterizedTest
    @CsvSource(value = {"0,3.0", "1,3.5", "2,3.46", "3,3.457", "4,3.4567"})
    void 특정_자리수에서_소수점_반올림을_할_수_있다(Integer index, Double expected) {
        assertThat(MathUtils.round(value, index)).isEqualTo(expected);
    }

    @Test
    void 반올림시_자리수는_음수는_지원하지_않는다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> MathUtils.round(value, -1));
    }
}
