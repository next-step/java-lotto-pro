package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
  int[] lottoNumber;

  @BeforeEach
  void setUp() {
    lottoNumber = new int[] {1, 2, 3, 4, 5, 6};
  }

  @DisplayName("종합 당첨 결과를 반환한다.")
  @Test
  void totalWinningResults() {
    LottoBuyer buyer = LottoBuyer.buy(PurchaseAmount.valueOf(14000),
      () -> new LottoNumbers(asList(lottoNumber)));
    int[] winningNumber = {1, 2, 3, 22, 33, 44};
    MatchResults matchResults = buyer.matchWithWinningLotto(new LottoNumbers(asList(winningNumber)));

    int[] matchCount = {14, 0, 0, 0};
    int matchCountIndex = 0;

    for (MatchResult matchResult : matchResults.getMatchResults()) {
      assertThat(matchResult.getMatchCount()).isEqualTo(matchCount[matchCountIndex++]);
    }
  }

  private List<Integer> asList(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int number : numbers) {
      list.add(number);
    }

    return list;
  }
}
