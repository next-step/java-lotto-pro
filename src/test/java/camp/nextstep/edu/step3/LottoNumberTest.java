package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @DisplayName("1부터 45까지 정수 값만 가진다")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void createTest(final int number) {
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("입력 값이 1보다 작거나 46 이상이면 RuntimeException 이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalidInputTest(final int invalidInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(invalidInput))
                .withMessageContaining("invalid input : ");
    }

    @DisplayName("LottoNumber 는 서로 비교 할수 있다.")
    @Test
    void compareTest() {
        assertThat(new LottoNumber(1).compareTo(new LottoNumber(2))).isEqualTo(-1);
    }
}
