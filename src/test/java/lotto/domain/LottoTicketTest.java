package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 티켓 테스트")
class LottoTicketTest {

	@Test
	@DisplayName("로또 티켓 생성")
	void createLottoTicketTest() {
		TestGenerateStrategy numbersGenerator = new TestGenerateStrategy();
		LottoTicket lottoTicket = LottoTicket.from(numbersGenerator);
		assertThat(lottoTicket).isInstanceOf(LottoTicket.class);
	}

	@Test
	@DisplayName("같은 로또 번호를 갖으면 같은 로또 티켓인지 확인")
	void equalsTest() {
		TestGenerateStrategy numbersGenerator = new TestGenerateStrategy();
		LottoTicket lottoTicket = LottoTicket.from(numbersGenerator);
		assertThat(lottoTicket).isEqualTo(LottoTicket.from(numbersGenerator));
	}

}