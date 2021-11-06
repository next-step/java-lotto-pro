package model.common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import model.common.LottoRule;

@DisplayName("로또 규칙")
class LottoRuleTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> LottoRule.of(1, 10, 5));
	}

	@Test
	@DisplayName("최소 값이 음수인 상태로 객체화하면 IllegalArgumentException")
	void instance_negativeValue_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoRule.of(Integer.MIN_VALUE, 10, 5))
			.withMessage("'minNumber' must be positive");
	}

	@Test
	@DisplayName("갯수가 1보다 작은 상태로 객체화하면 IllegalArgumentException")
	void instance_lessThanOne_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoRule.of(1, 45, 0))
			.withMessageMatching("count\\(\\d*\\) must be greater than \\d*");
	}

	@Test
	@DisplayName("최소 최대 값의 차이가 갯수보다 작은 상태에서 객체화하면 IllegalArgumentException")
	void instance_gapLessThanCount_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoRule.of(1, 45, Integer.MAX_VALUE))
			.withMessageMatching(
				"gap between minValue\\(\\d*\\) and maxValue\\(\\d*\\) must be more than count\\(\\d*\\)");
	}

	@ParameterizedTest(name = "{displayName}[{index}] it is {1} that count({0}) is different from 10")
	@DisplayName("갯수 다름 여부 판단")
	@CsvSource({"9,true", "10,false", "11,true"})
	void differentCount(int target, boolean expected) {
		//when
		boolean different = LottoRule.of(1, 45, 10)
			.differentCount(target);

		//then
		assertThat(different)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("유효한 숫자들 가져오기")
	void numbers() {
		//when
		int[] numbers = LottoRule.of(1, 45, 10)
			.numbers();

		//then
		assertThat(numbers)
			.doesNotHaveDuplicates()
			.hasSize(45);

	}

	@ParameterizedTest(name = "{displayName}[{index}] it is {1} that value({0}) is invalid")
	@DisplayName("유효하지 않은 숫자 판단")
	@CsvSource({"0,true", "1,false", "45,false", "46,true"})
	void invalidNumber(int target, boolean expected) {
		//when
		boolean invalid = LottoRule.of(1, 45, 10)
			.outOfRange(target);

		//then
		assertThat(invalid)
			.isEqualTo(expected);
	}
}
