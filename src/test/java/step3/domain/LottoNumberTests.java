package step3.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTests {

    @Test
    void 음수가_될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumber(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("음수는 입력할 수 없습니다.");
    }
}
