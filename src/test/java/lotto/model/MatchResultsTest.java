package lotto.model;

import lotto.constants.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MatchResultsTest {
  int[] buyerLottoNumber;
  LottoBuyer buyer;
  @BeforeEach
  void setUp() {
    buyerLottoNumber = new int[]{1, 2, 22, 33, 7};
    buyer = LottoBuyer.buy(new PurchaseAmount(5000), () -> new Lotto(asList(buyerLottoNumber)));
  }

  @DisplayName("총 당첨 금액을 반환한다.")
  @Test
  void getTotalWinningAmount() {
    int[] winningNumber = {1, 2, 3, 22, 33, 44};

    MatchResults matchResults = buyer.matchWithWinningLotto(new Lotto(asList(winningNumber)));

    assertThat(buyer.buyCount() * LottoRank.FOUR_MATCHES.getMoney()).isEqualTo(matchResults.getTotalWinningAmount());
  }

  @DisplayName("수익률을 계산한다. (당첨금액 / 구입금액)")
  @Test
  void calculateYield() {
    int[] winningNumber = {1, 2, 3, 22, 33, 44};

    MatchResults matchResults = buyer.matchWithWinningLotto(new Lotto(asList(winningNumber)));

    assertThat(matchResults.calculateYield(buyer.getPurchaseAmount())).isEqualTo(50);
  }

  private List<Integer> asList(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int number : numbers) {
      list.add(number);
    }

    return list;
  }
}