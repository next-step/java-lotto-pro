package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import money.Money;

class LottoVendorTest {

	static int[] FIXED_NUMBERS = {1, 2, 3, 4, 5, 6};

	Money 로또_가격 = Money.wons(1000);

	LottoTicketGenerator 고정_로또_번호_생성기 = new FixedLottoTicketGenerator(FIXED_NUMBERS);

	LottoVendor 로또판매기;

	@BeforeEach
	void setUp() {
		로또판매기 = new LottoVendor(로또_가격, 고정_로또_번호_생성기);
	}

	@ParameterizedTest
	@MethodSource("로또_구입_금액_입력")
	void 로또판매기는_구입금액을_입력받아_구입금액_만큼의_로또숫자를_발급한다(Money 구입금액, LottoTickets 예상_로또티켓) {
		LottoTickets 로또티켓 = 로또판매기.quickPick(구입금액);
		assertThat(로또티켓).isEqualTo(예상_로또티켓);
	}

	@ParameterizedTest
	@CsvSource({"0,0", "999,0", "1000,1", "1100,1", "1999,1", "2000,2"})
	void 로또판매기는_구입금액이_나누어떨어지지_않는_경우_구매되지_않는다(int 구입금액, int 구입갯수) {
		LottoTickets 로또티켓 = 로또판매기.quickPick(Money.wons(구입금액));
		assertThat(로또티켓.getCount()).isEqualTo(구입갯수);
	}

	private static Stream<Arguments> 로또_구입_금액_입력() {
		return Stream.of(
			Arguments.of(Money.wons(0), 로또_티켓_생성(0)),
			Arguments.of(Money.wons(1000), 로또_티켓_생성(1)),
			Arguments.of(Money.wons(5000), 로또_티켓_생성(5))
		);
	}

	private static LottoTickets 로또_티켓_생성(int quantity) {
		return LottoTickets.of(
			IntStream.range(0, quantity)
				.mapToObj(i -> LottoTicket.of(FIXED_NUMBERS))
				.collect(Collectors.toList()));
	}
}
