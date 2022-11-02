package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    @DisplayName("매칭숫자_등수_확인")
    void 매칭숫자_등수_확인() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FIFTH);
    }
}
