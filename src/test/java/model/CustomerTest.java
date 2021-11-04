package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	@CsvSource({"0,true", "10,true", "100,true", "200,false"})
	void hasMoreThan_alwaysTrue(int money, boolean expected) {
		//when
		boolean hasMoreThan = Customer.from(oneHundredMoney())
			.hasMoreThan(Money.from(money));

		//then
		assertThat(hasMoreThan)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("현재 소유하고 있는 금액에서 빼기")
	void minusMoney() {
		//given
		Customer customerWith100 = Customer.from(oneHundredMoney());

		//when
		customerWith100.subtractMoney(Money.from(10));

		//then
		assertThat(customerWith100.hasMoreThan(oneHundredMoney()))
			.isFalse();
	}

	@Test
	@DisplayName("현재 소유하고 있는 금액보다 큰 돈을 뺄 경우 IllegalStateException")
	void minusMoney_lessThan_thrownIllegalStateException() {
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
