package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("step3: CounterTest")
public class CounterTest {

  @Test
  @DisplayName("Counter 가 입력 받은 금액에 해당하는 올바른 갯수의 로또리스트를 제공하는지 확인.")
  void counter() {
    //given
    String inputMoney = "14000";
    //when
    Counter counter = new Counter(inputMoney);
    //then
    assertThat(counter.getLottoList().getLottoList().size()).isEqualTo(14);
  }

  @DisplayName("Counter 가 입력 받은 금액이 숫자가 아니거나, null 이거나, 1000원 이하 일 경우 예외 발생")
  @ParameterizedTest(name = "입력받은 input: {0} 일 떄 확인")
  @ValueSource(strings = {"", "900", "testInput"})
  void counter_valid(String input) {
    //when, then
    assertThatThrownBy(() -> new Counter(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("[COUNTER_ERROR] 올바른 금액을 입력해주세요.");
  }
}
