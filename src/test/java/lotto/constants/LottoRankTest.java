package lotto.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoRankTest {
  @DisplayName("최소 반환할 로또 등수를 반환한다.")
  @Test
  void 최소_로또_등수() {
    assertThat(LottoRank.getMinWinningRank()).isEqualTo(LottoRank.FIFTH);
  }

  @DisplayName("일치 정보를 입력 받아 해당되는 랭킹을 반환")
  @Test
  void 로또_랭킹_생성() {
    assertAll(
      () -> assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST),
      () -> assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND),
      () -> assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD),
      () -> assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH),
      () -> assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH),
      () -> assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.MISS),
      () -> assertThat(LottoRank.valueOf(1, false)).isEqualTo(LottoRank.MISS),
      () -> assertThat(LottoRank.valueOf(0, false)).isEqualTo(LottoRank.MISS),

      () -> assertThat(LottoRank.valueOf(4, true)).isEqualTo(LottoRank.FOURTH)
    );
  }
}
