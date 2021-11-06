package lottoservice.lottoticket;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;

public class LottoTicketTest {

	private static final int SIZE_OF_LOTTERY_NUMBERS = 6;

	@Test
	public void makeLottoTicket_로또_티켓_발급() {
		List<LottoNumber> lottoNumbers = LottoNumbersMaker.makeLottoNumbers();
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

		Assertions.assertThat(lottoTicket.getNumOfNumbersInGroup())
			.isEqualTo(SIZE_OF_LOTTERY_NUMBERS);

		lottoNumbers.forEach((it)->assertThat(lottoTicket.hasLottoNumber(it)));
	}
}
