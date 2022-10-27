package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 티켓 테스트")
class LottoTicketTest {

	@Test
	@DisplayName("로또 티켓 생성")
	void createLottoTicketTest() {
		LottoNumbers lottoNumbers = TestLottoNumbersFactory.createLottoNumbers(1, 2, 3, 4, 5, 6);
		LottoTicket lottoTicket = LottoTicket.of(lottoNumbers);
		assertThat(lottoTicket).isInstanceOf(LottoTicket.class);
	}

	@Test
	@DisplayName("같은 로또 번호를 갖으면 같은 로또 티켓인지 확인")
	void equalsTest() {
		LottoNumbers lottoNumbers = TestLottoNumbersFactory.createLottoNumbers(1, 2, 3, 4, 5, 6);
		LottoTicket lottoTicket = LottoTicket.of(lottoNumbers);
		assertThat(lottoTicket).isEqualTo(LottoTicket.of(lottoNumbers));
	}

}