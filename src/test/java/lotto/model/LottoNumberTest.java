package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 숫자의 범위 검증")
    @Test
    void lottoNumberRange() {
        assertThatThrownBy(() -> {
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자 범위가 아닙니다.");
    }
}
