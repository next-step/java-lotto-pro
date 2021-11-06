package model.store;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import model.common.Money;
import model.common.string.StringDelimiters;

@DisplayName("고객")
class CustomerTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> Customer.of(oneHundredMoney(), Collections.emptyList(), comma()));
	}

	@Test
	@DisplayName("돈 없이 객채화 하면 IllegalArgumentException")
	void instance_nullMoney_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Customer.of(null, Collections.emptyList(), comma()))
			.withMessage("'money' must not be null");
	}

	@Test
	@DisplayName("번호들 없이 객채화 하면 IllegalArgumentException")
	void instance_nullStrings_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Customer.of(oneHundredMoney(), null, comma()))
			.withMessage("'manualNumbers' must not be null");
	}

	@Test
	@DisplayName("구분자 없이 객채화 하면 IllegalArgumentException")
	void instance_nullDelimiters_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Customer.of(oneHundredMoney(), Collections.emptyList(), null))
			.withMessage("'delimiters' must not be null");
	}

	@ParameterizedTest(name = "{displayName}[{index}] it is {1} that customer who has oneHundred can purchase lotto({0})")
	@DisplayName("소유하고 있는 100원으로 구매 가능한 상품 갯수")
	@CsvSource({"1,100", "100,1", "101,0"})
	void purchaseCount(int money, int expected) {
		//when
		int purchaseCount = Customer.of(oneHundredMoney(), Collections.emptyList(), comma())
			.purchaseCount(Money.from(money));

		//then
		assertThat(purchaseCount)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("현재 소유하고 있는 금액에서 빼기")
	void subtractMoney() {
		//given
		Customer customerWith100 = Customer.of(oneHundredMoney(), Collections.emptyList(), comma());

		//when
		customerWith100.subtractMoney(Money.from(10));

		//then
		assertThat(customerWith100.purchaseCount(Money.from(10)))
			.isEqualTo(9);
	}

	@Test
	@DisplayName("소유하고 있는 금액보다 큰 돈을 뺄 경우 IllegalStateException")
	void subtractMoney_lessThan_thrownIllegalStateException() {
		//given
		Customer customerWith100 = Customer.of(oneHundredMoney(), Collections.emptyList(), comma());

		//when, then
		assertThatIllegalStateException()
			.isThrownBy(() -> customerWith100.subtractMoney(Money.from(Integer.MAX_VALUE)))
			.withMessageContaining("not enough money");
	}

	@ParameterizedTest(name = "{displayName}[{index}] it is {1} that customer has numbers greater than lotto({0}) purchase count")
	@CsvSource({"1,false", "50,true", "100,true", "101,true"})
	@DisplayName("수동 번호 갯수가 구매할 수 있는 갯수보다 큰지 판단")
	void hasNumbersGreaterThanPurchaseCount(int price, boolean expected) {
		//when
		boolean greaterThanPurchaseCount = Customer.of(oneHundredMoney(), Arrays.asList("", "", ""), comma())
			.hasNumbersGreaterThanPurchaseCount(Money.from(price));

		//then
		assertThat(greaterThanPurchaseCount)
			.isEqualTo(expected);
	}

	private StringDelimiters comma() {
		return StringDelimiters.of(",");
	}

	private Money oneHundredMoney() {
		return Money.from(100);
	}

}
