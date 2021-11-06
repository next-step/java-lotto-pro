package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
	@Test
	@DisplayName("구입을 위한 금액은 0 이상이어야 한다.")
	void testNoMoney() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Money(-1000))
			.withMessage(Money.NO_MONEY_ERROR);
	}

	@Test
	@DisplayName("금액을 사용하면 남은 금액이 반환된다.")
	void testMoneySpend() {
		Money money = new Money(10000);
		assertThat(money.spend(1000)).isEqualTo(new Money(9000));
	}

	@Test
	@DisplayName("과소비는 허용되지 않는다.")
	void testNotAllowedOverSpend() {
		Money money = new Money(10000);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> money.spend(20000))
			.withMessage(Money.OVERSPENDING_ERROR);
	}
}
