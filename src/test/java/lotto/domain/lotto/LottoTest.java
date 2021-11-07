package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
  @DisplayName("로또가 지난 당첨번호와 몇개가 맞는지 확인.")
  @Test
  void check_lottoNumberWithLatestWinNumbers() {
    // given
    Lotto latestWinLotto = Lotto.valueOf("1", "3", "5", "7", "9", "20");
    Lotto buyLotto = Lotto.valueOf("1", "3", "5", "17", "19", "30");

    // when
    Integer matchCount = latestWinLotto.matchCountOf(buyLotto);

    // then
    assertThat(matchCount).isEqualTo(3);
  }
}
