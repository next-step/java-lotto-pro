package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("랭크 테스트")
    public void none() {
        Rank none = Rank.of(2, false);

        Rank excepted = Rank.NONE;

        assertThat(none).isEqualTo(excepted);
    }

    @Test
    @DisplayName("랭크 테스트")
    public void first() {
        Rank none = Rank.of(6, false);

        Rank excepted = Rank.FIRST;

        assertThat(none).isEqualTo(excepted);
    }

    @Test
    @DisplayName("랭크 테스트")
    public void second() {
        Rank none = Rank.of(5, true);

        Rank excepted = Rank.SECOND;

        assertThat(none).isEqualTo(excepted);
    }

}