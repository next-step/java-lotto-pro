import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.StringSplitParser;

public class CalculatorInputStringParserTest {

	@Test
	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
	void test_parse1() {
		assertThat(StringSplitParser.parse("1")).containsExactly(1);
	}

	@Test
	@DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 각 숫자를 구분하여 반환한다.")
	void test_parse2() {
		assertThat(StringSplitParser.parse("1,2")).containsExactly(1, 2);
	}

	@Test
	@DisplayName("콜론 구분자로 입력할 경우에도 각 숫자를 구분하여 반환한다.")
	void test_parse3() {
		assertThat(StringSplitParser.parse("1,2:3")).containsExactly(1, 2, 3);
	}

	@Test
	@DisplayName("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있으며, 해당 구분자를 사용할 경우 각 숫자를 구분하여 반환한다.")
	void test_parse4() {
		assertThat(StringSplitParser.parse("//;\n1;2;3")).containsExactly(1, 2, 3);
	}
}
