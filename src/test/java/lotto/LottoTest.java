package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void Integer_list_size가_6이_아닐경우_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() ->
            Lotto.create(Arrays.asList(1,2,3,4,5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_숫자가_아닌_문자가_있을경우_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() ->
            Lotto.create("1, 2, a, 4, 5, 6")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호와_일치하는_번호의_개수를_반환한다() {
        // given
        Lotto winning = Lotto.create("1, 2, 3, 4, 5, 6");
        Lotto lotto = Lotto.create(Arrays.asList(1, 2, 3, 10, 11, 12));
        // when
        int matchCount = lotto.match(winning);
        // then
        assertThat(matchCount).isEqualTo(3);
    }



}