package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.exception.IllegalMoneyException;
import lotto.domain.exception.OverSpendingMoneyException;

public class MoneyTest {
	@Test
	@DisplayName("구입을 위한 금액은 0 이상이어야 한다.")
	void testNoMoney() {
		assertThatThrownBy(() -> new Money(-1000))
			.isInstanceOf(IllegalMoneyException.class);
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
		assertThatExceptionOfType(OverSpendingMoneyException.class)
			.isThrownBy(() -> money.spend(11000));
	}
}
