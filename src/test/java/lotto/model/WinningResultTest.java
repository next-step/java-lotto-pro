package lotto.model;

import org.junit.jupiter.api.Test;


import static lotto.constants.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
  @Test
  void 당첨결과_초기화() {
    WinningResult winningResult = WinningResult.init();

    assertThat(winningResult.getWinningResult().keySet())
      .contains(MISS, FIFTH, FOURTH, THIRD, SECOND, FIRST);
  }

  @Test
  void 당첨결과_추가() {
    WinningResult winningResult = WinningResult.init();

    winningResult.addResult(MISS, 5);
    winningResult.addResult(MISS, 4);
    winningResult.addResult(FIFTH, 2);
    winningResult.addResult(FIFTH, 1);

    assertThat(winningResult.getWinningResult())
      .containsEntry(MISS, new RankCount(9))
      .containsEntry(FIFTH, new RankCount(3));
  }
}
