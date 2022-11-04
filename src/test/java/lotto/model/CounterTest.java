package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("step3: CounterTest")
public class CounterTest {

  @Test
  @DisplayName("Counter 가 입력 받은 금액, 수동 구매 번호로 통해 올바른 로또 구매 정보 반환하는지 확인")
  void counter() {
    //given
    String inputMoney = "14000";
    List<String> manualNumbers = Arrays.asList("1, 2, 3, 4, 5, 6", "3, 4, 5, 6, 7, 8");
    //when
    Counter counter = new Counter(inputMoney);
    counter.issueLotto(manualNumbers);
    //then
    assertAll(
        () -> assertThat(counter.getLottoList().getLottoList()).hasSize(14),
        () -> assertThat(counter.getInputMoney()).isEqualTo("14000"),
        () -> assertThat(counter.getManualLottoAmount()).isEqualTo(2)
    );
  }

  @DisplayName("Counter 가 입력 받은 금액이 숫자가 아니거나, null 이거나, 1000원 이하 일 경우 예외 발생")
  @ParameterizedTest(name = "입력받은 inputMoney: {0} 일 떄 확인")
  @ValueSource(strings = {"", "900", "testInput"})
  void counter_valid(String input) {
    //when, then
    assertThatThrownBy(
        () -> new Counter(input))
        .isInstanceOf(LottoException.class);
  }
}
