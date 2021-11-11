package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("일치하는 번호가 6개이면 1등")
    @Test
    void rankFirst() {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("일치하는 번호가 5개이고, 보너스 번호가 일치하면 2등")
    @Test
    void rankSecond() {
        assertThat( Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("일치하는 번호가 5개이고, 보너스 번호가 일치하지 않으면 3등")
    @Test
    void rankThird() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("일치하는 번호가 4개이면 4등")
    @Test
    void rankFourth() {
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("일치하는 번호가 3개이면 5등")
    @Test
    void rankFifth() {
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("일치하는 번호가 3개 미만이면 상금 없음")
    @Test
    void rankNoMatch() {
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.NO_MATCH);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.NO_MATCH);
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.NO_MATCH);
    }
}
