import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumbersTest {
    @Test
    void LottoNumbers_는_6개의_LottoNumber_를_포함할_수_있다() {
        assertDoesNotThrow(
                () -> new LottoNumbers(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );
    }

    @Test
    void LottoNumbers_는_6개의_LottoNumber_를_포함하지_않으면_예외를_던진다() {
        assertThatThrownBy(
                () -> new LottoNumbers(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5)
                )
        ).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(LottoNumbers::new)
                .isInstanceOf(RuntimeException.class);
    }
}
