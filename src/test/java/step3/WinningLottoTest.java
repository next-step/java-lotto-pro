package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

  @Test
  @DisplayName("입력받은 지난준 당청 번호를 통해 올바르게 WinningLotto 가 생성되는지 확인")
  void generate_winning_lotto() {
    //given
    String winningLottoNumber = "1, 2, 3, 4, 5, 6";
    //when
    WinningLotto winningLotto = new WinningLotto(winningLottoNumber);
    //then
    assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
  }

}
