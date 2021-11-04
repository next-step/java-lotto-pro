package model;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("수익")
class IncomeTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> Income.of(oneHundredMoney(), 1, oneHundredMoney()));
	}

	@Test
	@DisplayName("로또 금액 없이 객채화 하면 IllegalArgumentException")
	void instance_nullLottoPrice_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Income.of(null, 1, oneHundredMoney()))
			.withMessage("'lottoPrice' must not be null");
	}

	@Test
	@DisplayName("구매 갯수가 음수인 상태로 객채화 하면 IllegalArgumentException")
	void instance_negativeLottoPrice_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Income.of(oneHundredMoney(), -1, oneHundredMoney()))
			.withMessage("'purchaseCount' must be positive");
	}

	@Test
	@DisplayName("우승 금액 없이 객채화 하면 IllegalArgumentException")
	void instance_nullPrizeMoney_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Income.of(oneHundredMoney(), 1, null))
			.withMessage("'prizeMoney' must not be null");
	}

	@Test
	@DisplayName("이익율 계산")
	void ratio() {
		//given
		Income income = Income.of(oneHundredMoney(), 3, oneHundredMoney());

		//when
		BigDecimal ratio = income.ratio();

		//then
		assertThat(ratio)
			.isEqualByComparingTo(BigDecimal.valueOf(0.33));
	}

	private Money oneHundredMoney() {
		return Money.from(100);
	}
}
