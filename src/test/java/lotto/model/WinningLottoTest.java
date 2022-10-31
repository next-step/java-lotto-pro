package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

  @DisplayName("올바르지 않은 지난 당첨 번호 입력시 예외 발생 확인")
  @ParameterizedTest(name = "지난 당첨 번호 : {0} 일 떄, 예외 발생하는지 확인")
  @ValueSource(strings = {"1, 2, 3,test, 5, 6", "1, 2, 3, 4. 5, 6"})
  void valid_generate_winning_lotto(String winningLottoNumber) {
    //given, when, then
    assertThatThrownBy(() -> new WinningLotto(winningLottoNumber))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("올바른 형식의 지난 당청 번호를 입력해주세요.");
  }

  @Test
  @DisplayName("입력받은 지난준 당청 번호를 통해 올바르게 WinningLotto 가 생성되는지 확인")
  void generate_winning_lotto() {
    //given
    String winningLottoNumber = "1, 2, 3, 4, 5, 6";
    //when
    WinningLotto winningLotto = new WinningLotto(winningLottoNumber);
    //then
    assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

}
