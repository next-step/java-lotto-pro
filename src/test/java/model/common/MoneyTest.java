package model.common;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import model.common.Money;

@DisplayName("돈")
class MoneyTest {

	@Test
	@DisplayName("객체화")
	void instance_int() {
		assertThatNoException()
			.isThrownBy(() -> Money.from(Integer.MAX_VALUE));
	}

	@Test
	@DisplayName("문자로 객체화")
	void instance_string() {
		assertThatNoException()
			.isThrownBy(() -> Money.from("1"));
	}

	@Test
	@DisplayName("음수로 객체화하면 IllegalArgumentException")
	void instance_negativeNumber_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Money.from(-1));
	}

	@ParameterizedTest(name = "{displayName}[{index}] {0} can not be instanced")
	@DisplayName("숫자 형태의 문자가 아닌 상태로 객체화하면 IllegalArgumentException")
	@NullAndEmptySource
	@ValueSource(strings = "a")
	void instance_invalidString_thrownIllegalArgumentException(String target) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Money.from(target))
			.withMessageContaining("can not be changed to number");
	}

	@ParameterizedTest(name = "{displayName}[{index}] it is {1} that the money({1}) more than 1000")
	@DisplayName("다른 객체의 돈보다 이상인지 판단")
	@CsvSource({"1,false", "999,false", "1000,true", "1001, true"})
	void moreThan(int target, boolean expected) {
		//when
		boolean moreThan = Money.from(target)
			.moreThan(Money.from(1000));

		//then
		assertThat(moreThan)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("빼기")
	void subtract() {
		//given, when
		Money subtractMoney = Money.from(1000)
			.subtract(Money.from(1000));

		//then
		assertThat(subtractMoney)
			.isEqualTo(Money.from(0));
	}

	@Test
	@DisplayName("더 큰 값으로 빼기하면 IllegalStateException")
	void subtract_lessThanSubtract_thrownIllegalStateException() {
		//given, when
		ThrowingCallable subtractCall = () -> Money.from(1000)
			.subtract(Money.from(Integer.MAX_VALUE));

		//then
		assertThatIllegalStateException()
			.isThrownBy(subtractCall)
			.withMessageMatching("not enough money\\(\\d*\\) to subtract \\d*");
	}

	@Test
	@DisplayName("곱하기")
	void multiply() {
		//given, when
		Money multiplyMoney = Money.from(1000)
			.multiply(3);

		//then
		assertThat(multiplyMoney)
			.isEqualTo(Money.from(3000));
	}

	@Test
	@DisplayName("비율 계산")
	void ratio() {
		//given, when
		BigDecimal ratio = Money.from(1000)
			.ratio(Money.from(100));

		//then
		assertThat(ratio)
			.isEqualByComparingTo(BigDecimal.TEN);
	}

	@Test
	@DisplayName("0으로 비율 계산하면 IllegalArgumentException")
	void ratio_zero_thrownIllegalArgumentException() {
		//given, when
		ThrowingCallable ratioWithZeroCall = () -> Money.from(1000)
			.ratio(Money.from(0));

		//then
		assertThatIllegalArgumentException()
			.isThrownBy(ratioWithZeroCall)
			.withMessage("can not divided by zero");
	}
}
