package lottoservice.lottoticket;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.lottoticket.LottoTicket;

public class LottoTicketTest {

	private static final int START_INCLUSIVE_NUMBER = 1;    /* 로또 번호 최소값 */
	private static final int END_EXCLUSIVE_NUMBER = 45;    /* 로또 번호 최대값 */
	private static final int SIZE_OF_LOTTERY_NUMBERS = 6;

	@Test
	@RepeatedTest(10)
	public void makeLottoTicket_로또_티켓_한장_발급() {
		LottoTicket lottoTicket = new LottoTicket(LottoNumbersMaker.makeLottoNumbers());

		Assertions.assertThat(lottoTicket.getNumOfNumbersInGroup())
			.isEqualTo(SIZE_OF_LOTTERY_NUMBERS);

		lottoTicket.getLottoNumbers()
			.forEach(lottoNumber -> assertThat(lottoNumber.getNumber())
				.isBetween(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER));
	}
}
