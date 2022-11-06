package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    @DisplayName("매칭숫자_등수_확인")
    void 매칭숫자_등수_확인() {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }
}
