package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 숫자가_아닌_문자를_입력하면_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() -> new LottoNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}