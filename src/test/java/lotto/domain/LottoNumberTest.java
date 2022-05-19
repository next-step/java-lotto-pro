package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("로또번호 숫자 범위.")
    void 로또번호_숫자범위_에외_검증() {
        assertThatThrownBy(() -> {
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
