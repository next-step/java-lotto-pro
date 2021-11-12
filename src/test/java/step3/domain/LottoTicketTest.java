package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTicketTest {

  private static Stream<Arguments> generateNumberList() {
    List<Arguments> listOfArguments = new LinkedList<>();
    listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4))); // 4 개 숫자
    listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4, 20, 44, 45))); // 7 개 숫자
    listOfArguments
        .add(Arguments.of(Arrays.asList(-1, 3, 5, 7, 8, 10))); // 6 개 숫자 with invalid number
    return listOfArguments.stream();

  }

  @Test
  @DisplayName("로또 갯수(6)가 맞는지 확인")
  void checkLottoNumberListSize6() {
    LottoTicket lottoTicket = new LottoTicket();
    assertThat(lottoTicket.getNumbers().size()).isEqualTo(LottoTicket.NUMBERS_COUNT);
  }

  @Test
  @DisplayName("로또 내 숫자 목록이 unique 한 지 확인")
  void checkNumberListIsUnique() {
    LottoTicket lottoTicket = new LottoTicket();
    assertThat(lottoTicket.getNumbers().stream().distinct().count())
        .isEqualTo(LottoTicket.NUMBERS_COUNT);
  }

  @Test
  @DisplayName("입력 받은 (당첨)번호가 유효한지 확인 _ 성공")
  void checkWinningLottoNumbersValid() {
    List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 20, 45);
    LottoTicket lottoTicket = new LottoTicket(winningNumber.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList()));

    assertThat(lottoTicket.getNumbers().size()).isEqualTo(LottoTicket.NUMBERS_COUNT);
    assertThat(lottoTicket.getNumbers().stream().distinct().count())
        .isEqualTo(LottoTicket.NUMBERS_COUNT);
  }

  @ParameterizedTest
  @MethodSource("generateNumberList")
  @DisplayName("입력 받은 (당첨)번호가 유효한지 확인 _ 실패")
  void checkWinningLottoNumbersValid_Fail(List<Integer> inputWinningNumbers) {

    assertThatThrownBy(() -> new LottoTicket(inputWinningNumbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList()))).isInstanceOf(RuntimeException.class);
  }
}
