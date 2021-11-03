package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("정수 값을 더하는 기능을 담당하는 Sum 테스트")
class SumTest {

	@DisplayName("Sum 생성 테스트")
	@Test
	void createSumTest() {
		// given
		String input = "1:2,3";

		// when
		Sum sum = new Sum(new Split(input));

		// then
		assertAll(
			() -> assertThat(sum).isInstanceOf(Sum.class),
			() -> assertThat(sum.getIntArray()).contains(1, 2, 3)
		);
	}

	@ParameterizedTest(name = "{index} ===> input : {0} result : {1}")
	@CsvSource(value = {"1:2,3 | 6", "1:2:2 | 5"}, delimiter = '|')
	void sumIntArrayTest(String input, int result) {
		// given
		Sum sum = new Sum(new Split(input));

		// when
		int sumIntArray = sum.sumIntArray();

		// then
		assertThat(sumIntArray).isEqualTo(result);
	}

	@DisplayName("커스텀 토큰을 입력했을 때 계산을 잘하는지 확인하는 테스트")
	@Test
	void sumCustomTokenTest() {
		// given
		String input = "//@\n1@2@3";
		Sum sum = new Sum(new Split(input));

		// when
		int sumIntArray = sum.sumIntArray();

		// then
		assertThat(sumIntArray).isEqualTo(6);
	}
}