package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
	@Test
	@DisplayName("가진 돈보다 많은 돈을 사용할 때 예외 발생")
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

	@Test
	@DisplayName("상품 가격이 0원인 경우 예외 발생")
	void 구매_가능_개수_예외() {
		Money money = Money.of(5000);
		Money price = Money.of(0);

		assertThatIllegalArgumentException().isThrownBy(() ->
			money.purchaseableCount(price));
	}

	@Test
	@DisplayName("5000원 있을 때 1500원짜리는 3개 살 수 있다")
	void 구매_가능_개수1() {
		Money money = Money.of(5000);
		Money price = Money.of(1500);

		assertThat(money.purchaseableCount(price)).isEqualTo(PurchaseCount.from("3"));
	}

	@Test
	@DisplayName("5000원 있을 때 6000원짜리는 0개 살 수 있다")
	void 구매_가능_개수2() {
		Money money = Money.of(5000);
		Money price = Money.of(6000);

		assertThat(money.purchaseableCount(price)).isEqualTo(PurchaseCount.from("0"));
	}

}