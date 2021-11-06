package model.common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("범위")
class RangeTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> Range.of(1, 9));
	}

	@Test
	@DisplayName("최소 값이 음수인 상태로 객체화하면 IllegalArgumentException")
	void instance_negativeMin_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Range.of(-1, 1))
			.withMessageContaining("must be positive");
	}

	@Test
	@DisplayName("최대가 최소보다 작은 객체화 IllegalArgumentException")
	void instance_nullRange_illegalArgumentExceptionThrown() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Range.of(9, 1))
			.withMessageContaining("must greater than min");
	}

	@ParameterizedTest
	@DisplayName("미포함 여부")
	@CsvSource({"0,true", "1,false", "5,false", "10,true"})
	void isOut(int number, boolean expected) {
		assertThat(Range.of(1, 9).isOut(number))
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("크기 정보")
	void numbers() {
		int[] numbers = Range.of(1, 45)
			.numbers();

		//then
		assertThat(numbers)
			.doesNotHaveDuplicates()
			.hasSize(45);
	}

	@ParameterizedTest(name = "{displayName}[{index}] it is {1} that {0} is greater than size between 1 and 5")
	@DisplayName("크기가 주어진 수보다 더 큰지 판별")
	@CsvSource({"1,false", "4,false", "5,false", "10,true"})
	void greaterThanSize(int count, boolean expected) {
		//when
		boolean greaterThanSize = Range.of(1, 5)
			.greaterThanSize(count);

		//then
		assertThat(greaterThanSize)
			.isEqualTo(expected);
	}
}
