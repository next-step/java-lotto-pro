package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {
	@Test
	@DisplayName("가진 돈보다 많은 돈을 사용할 때 에러 발생")
	void 돈_사용_예외() {
		Money money = Money.of(1000);
		Money price = Money.of(2000);

		assertThatIllegalArgumentException().isThrownBy(() ->
			money.use(price));
	}

	@Test
	@DisplayName("1000원 있는데 1000원을 사용한 경우 0원 남음")
	void 돈_사용() {
		Money money = Money.of(1000);
		Money price = Money.of(1000);

		assertThat(money.use(price)).isEqualTo(Money.of(0));
	}

}