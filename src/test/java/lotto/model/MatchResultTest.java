package lotto.model;

import lotto.constants.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {
  @DisplayName("enum 클래스를 활용하여 순위가 일치하는지 확인한다.")
  @Test
  void match() {
    int[] winningNumber = {1, 2, 3, 22, 33, 44};

    LottoBuyer buyer = LottoBuyer.buy(new PurchaseAmount(4000),
      () -> new LottoNumbers(asList(winningNumber)));
    MatchResults matchResults = buyer.matchWithWinningLotto(new LottoNumbers(asList(winningNumber)));
    MatchResult winningMatchResult = new MatchResult(LottoRank.SIX_MATCHES, new MatchCount(3));

    assertThat(matchResults.getMatchResults().get(3)).isEqualTo(winningMatchResult);


  }

  private List<Integer> asList(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int number : numbers) {
      list.add(number);
    }

    return list;
  }

}
