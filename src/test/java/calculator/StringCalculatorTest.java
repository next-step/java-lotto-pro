package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import calculator.StringCalculator;

public class StringCalculatorTest {

	@DisplayName("구분자를 기준으로 분리한 각 숫자의 합을 반환")
	@ParameterizedTest
	@CsvSource(value = {
		"'',0",
		"'1,2',3",
		"'1,2,3',6",
		"'1,2:3',6",
		"'//;\\n1;2;3',6", // 커스텀 구분자
		"'//;;\\n1;;2;;3',6", // 커스텀 구분자
	})
	public void sumAfterSplitTest(String input, int expected) {
		assertThat(new StringCalculator(input).calculate())
			.isEqualTo(expected);
	}

	@DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외")
	// todo 가끔 IDE에서 @ParameterizedTest가 실행이 안되는 현상 있음 (확인필요)
	// @ParameterizedTest
	// @CsvSource(value = {
	// 	"-1",
	// 	"'1,a'",
	// })
	@Test
	public void throwWhenSumNotValidInputTest() {
		// given
		String input1 = "-1";
		String input2 = "1,a";

		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new StringCalculator(input1).calculate())
			.withMessage("The input is not valid");

		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new StringCalculator(input2).calculate())
			.withMessage("The input is not valid");
	}
}
