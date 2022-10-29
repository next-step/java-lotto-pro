package step3;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Counter;
import lotto.model.LottoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("step3: CounterTest")
public class CounterTest {

  @Test
  @DisplayName("Counter 가 입력 받은 금액에 해당하는 올바른 갯수의 로또리스트를 제공하는지 확인.")
  void counter() {
    //given
    String input = "14000";
    //when
    LottoList result = Counter.buyLotto(input);
    //then
    assertThat(result.getLottoList().size()).isEqualTo(14);
  }


}
