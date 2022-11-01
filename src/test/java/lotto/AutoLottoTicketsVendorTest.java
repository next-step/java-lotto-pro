package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.AutoLottoTicketsVendor;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.LottoTickets;

class AutoLottoTicketsVendorTest {

	static int[] FIXED_NUMBERS = {1, 2, 3, 4, 5, 6};

	LottoTicketGenerator 고정_로또_번호_생성기 = new FixedLottoTicketGenerator(FIXED_NUMBERS);

	AutoLottoTicketsVendor 로또판매기;

	@BeforeEach
	void setUp() {
		로또판매기 = new AutoLottoTicketsVendor(고정_로또_번호_생성기);
	}

	@ParameterizedTest
	@MethodSource("로또_구입_금액_입력")
	void 로또판매기는_구입금액을_입력받아_구입금액_만큼의_로또숫자를_발급한다(int 구입갯수, LottoTickets 예상_로또티켓) {
		LottoTickets 로또티켓 = 로또판매기.buyAutoLottoTickets(구입갯수);
		assertThat(로또티켓).isEqualTo(예상_로또티켓);
	}

	private static Stream<Arguments> 로또_구입_금액_입력() {
		return Stream.of(
			Arguments.of(0, 로또_티켓_생성(0)),
			Arguments.of(1, 로또_티켓_생성(1)),
			Arguments.of(5, 로또_티켓_생성(5))
		);
	}

	private static LottoTickets 로또_티켓_생성(int quantity) {
		return LottoTickets.of(
			IntStream.range(0, quantity)
				.mapToObj(i -> LottoTicket.of(FIXED_NUMBERS))
				.collect(Collectors.toList()));
	}
}
