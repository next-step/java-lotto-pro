package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @DisplayName("1부터 45까지 정수 값만 가진다")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void createTest(final int number) {
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(number));
    }
}
