package model.store;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import model.common.Money;
import model.store.Customer;

@DisplayName("고객")
class CustomerTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> Customer.from(oneHundredMoney()));
	}

	@Test
	@DisplayName("돈 없이 객채화 하면 IllegalArgumentException")
	void instance_nullMoney_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Customer.from(null))
			.withMessage("'money' must not be empty");
	}

	@ParameterizedTest(name = "{displayName}[{index}] it is {1} that customer has more than {0}")
	@DisplayName("현재 소유하고 있는 100원이 비교 대상보다 큰지 판단")
	@CsvSource({"1,100", "100,1", "101,0"})
	void availablePurchaseCount(int money, int expected) {
		//when
		int purchaseCount = Customer.from(oneHundredMoney())
			.availablePurchaseCount(Money.from(money));

		//then
		assertThat(purchaseCount)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("현재 소유하고 있는 금액에서 빼기")
	void subtractMoney() {
		//given
		Customer customerWith100 = Customer.from(oneHundredMoney());

		//when
		customerWith100.subtractMoney(Money.from(10));

		//then
		assertThat(customerWith100.availablePurchaseCount(Money.from(10)))
			.isEqualTo(9);
	}

	@Test
	@DisplayName("현재 소유하고 있는 금액보다 큰 돈을 뺄 경우 IllegalStateException")
	void subtractMoney_lessThan_thrownIllegalStateException() {
		//given
		Customer customerWith100 = Customer.from(oneHundredMoney());

		//when, then
		assertThatIllegalStateException()
			.isThrownBy(() -> customerWith100.subtractMoney(Money.from(Integer.MAX_VALUE)))
			.withMessageContaining("not enough money");
	}

	private Money oneHundredMoney() {
		return Money.from(100);
	}

}
