package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTest {

    @DisplayName("로또는 숫자 6개를 입력이 안될 경우 RuntimeException 을 발생한다")
    @Test
    void invalidInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(createLottoNumberArray(1)))
                .withMessageContaining("LottoNumberArray invalid size : ");
    }

    private LottoNumber[] createLottoNumberArray(final Integer ... numbers) {
        return  Stream.of(numbers).map(LottoNumber::new).toArray(LottoNumber[]::new);
    }
}
