package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {

    @Test
    void 로또를_맞춘_숫자를_입력하면_등수를_반환한다() {
        // when
        Rank rank = Rank.of(3);
        // then
        assertThat(rank).isEqualTo(Rank.FOUR);
    }

    @Test
    void 당첨순위에_없는_숫자를_입력하면_예외가_발생한다() {
        // when
        assertThatThrownBy(() ->
                Rank.of(2)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}