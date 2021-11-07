package lotto.domain.winpolicy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.lotto.Lotto;

public class PolicyTest {
  @DisplayName("당첨번호와 구입한 로또를 비교하여 당첨정책에 받는 객체가 반환된다.")
  @Test
  void check_winPolicy() {
    // given
    Lotto latestWinLotto = Lotto.valueOf("1", "3", "5", "7", "9", "20");
    Lotto buyLotto = Lotto.valueOf("1", "3", "5", "17", "19", "30");
    Policy policy = new ThreeMatch();

    // when
    boolean realMatch = policy.isMatch(latestWinLotto, buyLotto);

    // then
    assertThat(realMatch).isTrue();
  }
}
