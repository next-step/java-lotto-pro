package utility;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringNumberSeparatorTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> StringNumberSeparator.from(StringDelimiters.of(",")));
	}

	@Test
	@DisplayName("구분자들이 없이 객체화할 경우 IllegalArgumentException")
	void instance_nullDelimiters_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringNumberSeparator.from(null))
			.withMessage("delimiters must not be null");
	}

	@ParameterizedTest(name = "{displayName}[{index}] the sum of {0} is {1}")
	@DisplayName("구분해서 더하기")
	@CsvSource(value = {",0", "1,1", "1:2:3,6"})
	void separate(String target, int expected) {
		//when
		StringNumbers separatedNumbers = StringNumberSeparator.from(colonDelimiters())
			.separate(target);

		//then
		assertThat(separatedNumbers.sum())
			.isEqualTo(expected);
	}

	private StringDelimiters colonDelimiters() {
		return StringDelimiters.of(",", ":");
	}
}
