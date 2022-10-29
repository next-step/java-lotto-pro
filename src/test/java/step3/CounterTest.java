package step3;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Counter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("step3: CounterTest")
public class CounterTest {

  @Test
  @DisplayName("입력 받은 금액에 해당하는 로또 수량을 제공하는지 확인.")
  void counter() {
    //given
    String input = "14000";
    //when
    int result = Counter.calculateLottoAmount(input);
    //then
    assertThat(result).isEqualTo(14);
  }

}
