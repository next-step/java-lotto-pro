package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMoneyTest {

	@DisplayName("유효한 로또티켓 구매금액")
	@Test
	void validatedLottoMoney() {
		// given
		int money = LottoTicket.PRICE;

		// when
		LottoMoney lottoMoney = new LottoMoney(money);

		// then
		assertThat(lottoMoney.get().intValue()).isEqualTo(money);
	}

	@DisplayName("숫자가 아닌 로또티켓 구매금액 전달 시 예외 반환")
	@Test
	void throwNumberFormatExceptionWhenGivenIllegalMoney() {
		String money = "1,000";
		assertThatThrownBy(() -> new LottoMoney(money))
			.isInstanceOf(NumberFormatException.class);
	}

	@DisplayName("최소 로또티켓 가격보다 적은 로또 구매금액 전달 시 예외 반환")
	@Test
	void throwNumberFormatExceptionWhenGivenLowerMoneyThanLottoPrice() {
		int money = LottoTicket.PRICE - 1;
		assertThatThrownBy(() -> new LottoMoney(money))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
