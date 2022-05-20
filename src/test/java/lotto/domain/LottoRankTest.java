package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    @DisplayName("로또 번호 6개 일치할 경우 1등 당첨 확인")
    void rankFirst() {
        assertThat(LottoRank.rank(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("로또 번호 5개 일치하고 보너스 번호 일치할 경우 2등 당첨 확인")
    void rankSecond() {
        assertThat(LottoRank.rank(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("로또 번호 5개 일치하고 보너스 번호 일치하지 않을 경우 3등 당첨 확인")
    void rankThird() {
        assertThat(LottoRank.rank(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("로또 번호 4개 일치할 경우 4등 당첨 확인")
    void rankFourth() {
        assertThat(LottoRank.rank(4, false)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("로또 번호 3개 일치할 경우 5등 당첨 확인")
    void rankFifth() {
        assertThat(LottoRank.rank(3, false)).isEqualTo(LottoRank.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("로또 번호 3개 미만 일치할 경우 꽝")
    void rankMiss(int matchCount) {
        assertThat(LottoRank.rank(matchCount, false)).isEqualTo(LottoRank.MISS);
    }
}
