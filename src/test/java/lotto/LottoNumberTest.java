package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 숫자가_아닌_문자를_입력하면_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() ->
                LottoNumber.of("a")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또넘버를_캐시를_이용해_생성한다() {
        // given
        LottoNumber number = LottoNumber.of(5);
        LottoNumber same = LottoNumber.of(5);
        // then
        assertThat(number).isSameAs(same);
    }

    @Test
    void 로또넘버는_1부터_45까지의_숫자이다() {
        // when and then
        assertThatThrownBy(() ->
                LottoNumber.of(46)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}