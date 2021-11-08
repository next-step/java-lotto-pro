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
import lottoservice.testfactory.TestLottoDataFactory;

public class LottoTicketTest {

	private static final int SIZE_OF_LOTTERY_NUMBERS = 6;

	@DisplayName("로또_티켓_발급")
	@Test
	public void makeLottoTicket() {
		List<LottoNumber> lottoNumbers = TestLottoDataFactory.getLottoNumbers(3,2,15,7,32,17);
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

		assertThat(lottoTicket.getNumOfNumbersInGroup()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);

		lottoNumbers.forEach((it) -> assertThat(lottoTicket.hasLottoNumber(it)));
	}

	@DisplayName("티켓 로또번호 정렬과 eqauls 재정의 검")
	@Test
	public void sortNumbersInAscOrder() {
		List<LottoNumber> lottoNumbersNotSorted = TestLottoDataFactory.getLottoNumbers(1, 34, 10, 2, 30, 6);
		List<LottoNumber> lottoNumbersSorted = TestLottoDataFactory.getLottoNumbers(1, 2, 6, 10, 30, 34);

		assertThat(new LottoTicket(lottoNumbersNotSorted)).isEqualTo(new LottoTicket(lottoNumbersSorted));
	}
}