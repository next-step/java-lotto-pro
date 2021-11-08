package lottoservice.lottoticket;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;

public class LottoTicketTest {

	private static final int SIZE_OF_LOTTERY_NUMBERS = 6;

	@DisplayName("로또_티켓_발급")
	@Test
	public void makeLottoTicket() {
		LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers();
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

		assertThat(lottoTicket.getNumOfNumbersInGroup())
			.isEqualTo(SIZE_OF_LOTTERY_NUMBERS);

		lottoNumbers.forEach((it) -> assertThat(lottoTicket.hasLottoNumber(it)));
	}

	@DisplayName("티켓 안의_numbers_정렬")
	@Test
	public void sortNumbersInAscOrder() {
		List<LottoNumber> lottoNumbers = Arrays.asList(1,34,10,2,30,6)
			.stream().map(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
		for(int i=1; i<lottoTicket.getNumOfNumbersInGroup(); i++){
			assertThat(lottoTicket.getLottoNumber(i).compareTo(lottoTicket.getLottoNumber(i-1))).isEqualTo(1);
		}
	}

	@Test
	public void 티켓_equals_검증() {
		List<LottoNumber> lottoNumbers = Arrays.asList(1,34,10,2,30,6)
			.stream().map(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());

		List<LottoNumber> lottoNumbers2 = Arrays.asList(1,34,10,2,30,6)
			.stream().map(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
		LottoTicket lottoTicket2 = new LottoTicket(lottoNumbers2);
		assertThat(lottoTicket).isEqualTo(lottoTicket2);
	}
}