package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("랭크 1등 생성")
    void create_1등() {
        assertThat(Rank.of(6)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("랭크 2등 생성")
    void create_2등() {
        assertThat(Rank.of(5)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("랭크 3등 생성")
    void create_3등() {
        assertThat(Rank.of(4)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("랭크 꽝 생성")
    void create_꽝() {
        assertThat(Rank.of(2)).isEqualTo(Rank.NO_MATCH);
    }
}
