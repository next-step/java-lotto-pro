package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("일치하는 번호가 6개이면 1등")
    @Test
    void rankFirst() {
        Rank rank = Rank.valueOf(6);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("일치하는 번호가 5개이면 2등")
    @Test
    void rankSecond() {
        Rank rank = Rank.valueOf(5);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("일치하는 번호가 4개이면 3등")
    @Test
    void rankThird() {
        Rank rank = Rank.valueOf(4);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("일치하는 번호가 3개이면 4등")
    @Test
    void rankFourth() {
        Rank rank = Rank.valueOf(3);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("일치하는 번호가 3개 미만이면 상금 없음")
    @Test
    void rankNoMatch() {
        Rank rank = Rank.valueOf(2);
        assertThat(rank).isEqualTo(Rank.NO_MATCH);
    }
}
