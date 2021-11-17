package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketTest {

  private List<Integer> winningNumbers;

  private static Stream<Arguments> generateNumberList() {
    List<Arguments> listOfArguments = new LinkedList<>();
    listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4))); // 4 개 숫자
    listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4, 20, 44, 45))); // 7 개 숫자
    listOfArguments
        .add(Arguments.of(Arrays.asList(-1, 3, 5, 7, 8, 10))); // 6 개 숫자 with invalid number
    return listOfArguments.stream();
  }

  private static Stream<Arguments> generateNumberListWithBonusNumber() {
    List<Arguments> listOfArguments = new LinkedList<>();
    listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6)); // 4 개 숫자
    listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4, 20, 44, 45))); // 7 개 숫자
    listOfArguments
        .add(Arguments.of(Arrays.asList(-1, 3, 5, 7, 8, 10))); // 6 개 숫자 with invalid number
    return listOfArguments.stream();
  }

  @BeforeEach
  void setUp() {
    // 유효한 로또 숫자 목록 (당첨 번호)
    winningNumbers = Arrays.asList(1, 2, 3, 4, 20, 45);
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
    LottoTicket lottoTicket = new LottoTicket(winningNumbers.stream()
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
        .collect(Collectors.toList()))).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 18, 44})
  @DisplayName("입력 받은 보너스 번호가 유효한지 확인 _ 성공")
  void checkWinningLottoNumbersAndBonusNumberValid_Success(int bonusNumber) {
    LottoTicket lottoTicket = new LottoTicket(winningNumbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList()),
        new LottoNumber(bonusNumber));

    assertThat(lottoTicket.getBonusNumber()).isNotNull();
    assertThat(lottoTicket.getBonusNumber().getNumber()).isEqualTo(bonusNumber);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, -1, 20})
  @DisplayName("입력 받은 보너스 번호가 유효한지 확인 _ 실패")
  void checkWinningLottoNumbersAndBonusNumberValid_Fail(int bonusNumber) {

    assertThatThrownBy(() ->
        new LottoTicket(winningNumbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList()),
        new LottoNumber(bonusNumber))).isInstanceOf(IllegalArgumentException.class);

  }
}
