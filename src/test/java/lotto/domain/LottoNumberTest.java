package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    @DisplayName("로또번호 숫자 범위를 검증한다.")
    void 로또번호_숫자범위_검증() {
        assertThat(new LottoNumber().getNumbers().size()).isEqualTo(45);
    }
}
