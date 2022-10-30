package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    @DisplayName("당첨 번호 6개가 일치하면 1등")
    void generate_1등() {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("당첨 번호 5개와 보너스 볼이 일치하면 2등")
    void generate_2등() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("당첨 번호 5개가 일치하고 보너스 볼이 일치하지 않으면 3등")
    void generate_3등() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("당첨 번호 4개가 일치하면 4등")
    void generate_4등() {
        Rank rank = Rank.valueOf(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("당첨 번호 3개가 일치하면 5등")
    void generate_5등() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    @DisplayName("당첨 번호 3개 미만은 상금 없음")
    void generate_none(int matchCount) {
        Rank rank = Rank.valueOf(matchCount, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
