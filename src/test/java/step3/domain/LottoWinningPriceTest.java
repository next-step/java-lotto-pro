package step3.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LottoWinningPriceTest {

  @Test
  void lottoWinningPriceTest() {
    final int matchCountNum3 = 1;
    final int matchCountNum4 = 4;
    final int matchCountNum5 = 2;
    final int matchCountNum6 = 3;

    LottoMatchResult mockMatchResult = new LottoMatchResult() {
      @Override
      public int getMatchCountNum(int matchCount) {
        switch (matchCount) {
          case 3:
            return matchCountNum3;
          case 4:
            return matchCountNum4;
          case 5:
            return matchCountNum5;
          case 6:
            return matchCountNum6;
          default:
            return super.getMatchCountNum(matchCount);
        }
      }
    };

    int expectedPrice = matchCountNum3 * 5_000
        + matchCountNum4 * 50_000
        + matchCountNum5 * 1_500_000
        + matchCountNum6 * 2_000_000_000;

    LottoWinningPrice lottoWinningPrice = new LottoWinningPrice(mockMatchResult);
    assertEquals(expectedPrice, lottoWinningPrice.getWinningPrice());
  }


}
