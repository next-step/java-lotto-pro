package study.step3;

import domain.Lotto;
import domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    private LottoNumber lottoNumber;
    @Test
    @DisplayName("로또범위 1~45범위 검증")
    public void 로또번호_범위_체크() {
        assertThatThrownBy(() ->
                lottoNumber = new LottoNumber(56)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 1~45까지 가능합니다.");
    }

}