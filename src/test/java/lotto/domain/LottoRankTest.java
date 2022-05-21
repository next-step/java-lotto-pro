package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @DisplayName("일치하는 숫자에 따른 등수를 반환한다.")
    @Test
    void 로또_일치하는개수_테스트() {
        Assertions.assertThat(LottoRank.findMatch(6)).isEqualTo(LottoRank.FIRST);
        Assertions.assertThat(LottoRank.findMatch(5)).isEqualTo(LottoRank.SECOND);
        Assertions.assertThat(LottoRank.findMatch(4)).isEqualTo(LottoRank.THIRD);
        Assertions.assertThat(LottoRank.findMatch(3)).isEqualTo(LottoRank.FOURTH);
        Assertions.assertThat(LottoRank.findMatch(2)).isEqualTo(LottoRank.LOSE);
        Assertions.assertThat(LottoRank.findMatch(1)).isEqualTo(LottoRank.LOSE);
        Assertions.assertThat(LottoRank.findMatch(0)).isEqualTo(LottoRank.LOSE);
    }
}