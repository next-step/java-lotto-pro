package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

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
    assertThat(lottoTicket.getNumbers().stream().distinct().count()).isEqualTo(LottoTicket.NUMBERS_COUNT);
  }

}
