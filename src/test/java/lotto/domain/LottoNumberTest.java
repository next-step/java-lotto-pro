package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    @DisplayName("입력된 숫자로 로또번호를 생성한다.")
    void generate_test() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    @DisplayName("로또번호는 1 ~ 45 사이의 수이어야 한다.")
    void range_test() {
        assertAll(
                () -> assertThatThrownBy(() -> {
                    LottoNumber lottoNumber = new LottoNumber(0);
                }).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> {
                    LottoNumber lottoNumber = new LottoNumber(46);
                }).isInstanceOf(IllegalArgumentException.class)
        );

    }
}
