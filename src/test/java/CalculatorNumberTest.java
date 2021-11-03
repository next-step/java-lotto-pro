import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorNumberTest {

	@ParameterizedTest
	@DisplayName("음수일 경우 true 반환")
	@CsvSource(value = {"1,false", "0,false", "-1,true"})
	public void test_isExceptional1(int source, boolean expected) {
		CalculatorNumber calculatorNumber = new CalculatorNumber(source);

		assertThat(calculatorNumber.isExceptional()).isEqualTo(expected);
	}
}
