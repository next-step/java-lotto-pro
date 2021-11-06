package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBuyerTest {
  int[] lottoNumber;

  @BeforeEach
  void setUp() {
    lottoNumber = new int[]{1, 2, 3, 4, 5, 6};
  }

  @DisplayName("로또의 가격보다 낮게 구매할 경우 예외를 던진다.")
  @Test
  void lowerThanLottoPrice() {
    assertThatThrownBy(() -> LottoBuyer.buy(new PurchaseAmount(500),
      () -> new Lotto(asList(lottoNumber))))
      .isInstanceOf(RuntimeException.class)
      .hasMessage(ErrorMessage.PURCHASE_AMOUNT_LOWER_ERROR_MESSAGE);
  }

  @DisplayName("구매한 로또의 개수를 반환한다.")
  @Test
  void buyLottoCount() {
    int[] lottoNumber = {1, 2, 3, 4, 5, 6};
    LottoBuyer buyer = LottoBuyer.buy(new PurchaseAmount(14000),
      () -> new Lotto(asList(lottoNumber)));

    assertThat(buyer.buyCount()).isEqualTo(14);
  }

  @DisplayName("구매한 로또들과 당첨 결과를 비교한다.")
  @Test
  void matchWithWinningLotto() {
    LottoBuyer buyer = LottoBuyer.buy(new PurchaseAmount(14000),
      () -> new Lotto(asList(lottoNumber)));
    int[] winningNumber = {1, 2, 3, 22, 33, 44};

    MatchResults matchResults = buyer.matchWithWinningLotto(new Lotto(asList(winningNumber)));

    assertThat(buyer.buyCount() * LottoRank.THREE_MATCHES.getMoney()).isEqualTo(matchResults.getTotalWinningAmount());
  }

  private List<Integer> asList(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int number : numbers) {
      list.add(number);
    }

    return list;
  }
}
