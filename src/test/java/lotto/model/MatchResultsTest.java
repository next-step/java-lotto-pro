package lotto.model;

import lotto.constants.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultsTest {
  int[] buyerLottoNumber;
  PurchaseAmount purchaseAmount;
  LottoTicket lottoTicket;
  @BeforeEach
  void setUp() {
    buyerLottoNumber = new int[]{1, 2, 22, 33, 7};
    purchaseAmount = PurchaseAmount.valueOf(5000);
    lottoTicket = purchaseAmount.buyLottoTicket(() -> new LottoNumbers(asList(buyerLottoNumber)));
  }

  @DisplayName("총 당첨 금액을 반환한다.")
  @Test
  void getTotalWinningAmount() {
    int[] winningNumber = {1, 2, 3, 22, 33, 44};

    MatchResults matchResults = lottoTicket.totalWinningResults(new LottoNumbers(asList(winningNumber)));

    assertThat(purchaseAmount.buyLottoCount() * LottoRank.FOURTH.getMoney()).isEqualTo(matchResults.getTotalWinningAmount());
  }

  @DisplayName("수익률을 계산한다. (당첨금액 / 구입금액)")
  @Test
  void calculateYield() {
    int[] winningNumber = {1, 2, 3, 22, 33, 44};

    MatchResults matchResults = lottoTicket.totalWinningResults(new LottoNumbers(asList(winningNumber)));

    assertThat(matchResults.calculateYield(purchaseAmount)).isEqualTo(50);
  }

  private List<Integer> asList(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int number : numbers) {
      list.add(number);
    }

    return list;
  }
}