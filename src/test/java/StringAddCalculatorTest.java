import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

	// @ValueSource는 primitive type(short, byte, int, long, float, double, char, boolean)과 java.lang.String, java.lang.Class만 지원하므로 null을 파라미터로 사용할 수 없음
	// @ValueSource(strings = {null,""})
	@ParameterizedTest
	@NullSource
	@EmptySource
	public void splitAndSum_null_또는_빈문자(String text) {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"0=0","1=1","10=10","5435=5435"}, delimiter = '=')
	public void splitAndSum_숫자하나(String text, int expectedSum) throws Exception {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(expectedSum);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2=3","0,1=1","1,543=544"}, delimiter = '=')
	public void splitAndSum_쉼표구분자(String text, int expectedSum) throws Exception {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(expectedSum);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2:3=6","0,1:1=2","1,543:544=1088"}, delimiter = '=')
	public void splitAndSum_쉼표_또는_콜론_구분자(String text, int expectedSum) throws Exception {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(expectedSum);
	}


	@Test
	public void splitAndSum_custom_구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}


	@ParameterizedTest
	@ValueSource(strings = {"-1,2,3"})
	public void splitAndSum_negative(String text) throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
			.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2f,3","##,1,2,3"})
	public void splitAndSum_숫자자리에_문자포함_오류(String text) throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	public void splitAndSum_커스텀구분자_두자리이상() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//#$\n1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	public void splitAndSum_커스텀구분자_empty() throws Exception {
		assertThatThrownBy(()->{
			StringAddCalculator.splitAndSum("//\n1,2,3");
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	public void splitAndSum_커스텀구분자_포함인경우_덧셈할_문자열은_empty(){
		int result = StringAddCalculator.splitAndSum("//;\n");
		assertThat(result).isEqualTo(0);
	}
}