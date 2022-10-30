package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("Rank 값 생성 테스트")
    public void test() {
        assertThat(Rank.valueOf(0)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
    }
}
