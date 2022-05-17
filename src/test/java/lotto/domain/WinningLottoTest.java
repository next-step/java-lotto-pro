package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    void 보너스볼이_로또_번호들과_중복된다면_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() ->
                new WinningLotto("1, 2, 3, 4, 5, 6", "6")
        ).isInstanceOf(IllegalArgumentException.class);
    }

}