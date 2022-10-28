package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import money.Money;

class LottoVendorTest {

	static int[] FIXED_NUMBERS = {1, 2, 3, 4, 5, 6};
	Money LOTTO_PRICE = Money.wons(1000);
	LottoNumberGenerator lottoNumberGenerator = new FixedLottoNumberGenerator(FIXED_NUMBERS);
	LottoVendor 로또판매기;

	private static Stream<Arguments> provideLottoPurchasingMoney() {
		return Stream.of(
			Arguments.of(Money.wons(0), createLottoTicket(0)),
			Arguments.of(Money.wons(1000), createLottoTicket(1)),
			Arguments.of(Money.wons(5000), createLottoTicket(5))
		);
	}

	private static LottoTicket createLottoTicket(int quantity) {
		return LottoTicket.of(
			IntStream.range(0, quantity)
				.mapToObj(i -> LottoNumbers.of(FIXED_NUMBERS))
				.collect(Collectors.toList()));
	}

	@ParameterizedTest
	@MethodSource("provideLottoPurchasingMoney")
	void 로또판매기는_구입금액을_입력받아_구입금액_만큼의_로또숫자를_발급한다(Money 구입금액, LottoTicket 예상_로또티켓) {
		로또판매기 = new LottoVendor(LOTTO_PRICE, lottoNumberGenerator);
		LottoTicket 로또티켓 = 로또판매기.purchase(구입금액);
		assertThat(로또티켓).isEqualTo(예상_로또티켓);
	}

}
