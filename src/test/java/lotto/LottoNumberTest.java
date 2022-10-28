package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void 로또번호_생성하기() {
        assertThatThrownBy(() -> new LottoNumber(null))
            .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalStateException.class);
        assertDoesNotThrow(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}