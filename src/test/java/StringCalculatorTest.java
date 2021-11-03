import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
