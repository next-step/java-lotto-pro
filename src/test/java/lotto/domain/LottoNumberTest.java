package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 생성 확인")
    void create_lotto_test() {
        assertThat(LottoNumber.of(45))
                .isEqualTo(LottoNumber.of(45));
    }

    @Test
    @DisplayName("로또 번호 범위 exception 확인")
    void lotto_range_test() {
        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
