package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

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
}
