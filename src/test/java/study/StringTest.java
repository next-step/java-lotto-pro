package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {
	@DisplayName("\"1,2\"을 ,로 split했을 때 1과 2로 분리된다.")
	@Test
	void split_multiItem() {
		// given
		String value = "1,2";
		String seperator = ",";

		// when
		String[] realValues = value.split(seperator);

		// then
		assertThat(realValues).containsExactly("1", "2");
	}

	@DisplayName("\"1\"을 ,로 split했을 때 1만 포함된 배열이 반환된다.")
	@Test
	void split_singleItem() {
		// given
		String value = "1";
		String seperator = ",";

		// when
		String[] realValues = value.split(seperator);

		// then
		assertThat(realValues).containsExactly("1");
	}

	@DisplayName("\"(1,2)\"가 주어졌을 때 String의 substring()메소드를 통해 ()가 제거된 \"1,2\"가 반환된다.")
	@Test
	void substring_removeParentheses() {
		// given
		String value = "(1,2)";
		Integer parenthesesBeginIndex = value.indexOf("(") + 1;
		Integer parenthesesEndIndex = value.indexOf(")");

		// when
		String realValue = value.substring(parenthesesBeginIndex, parenthesesEndIndex);

		// then
		String expectedValue = "1,2";
		assertThat(realValue).isEqualTo(expectedValue);
	}

	@CsvSource({"0, 'a'",
				"1, 'b'",
				"2, 'c'"})
	@DisplayName("\"abc\"값이 주어졌을 때 String의 chatAt()메소드를 통해 특정 문자를 가져오게된다.")
	@ParameterizedTest(name = "{index} => charAt_{0} value is \"{1}\"")
	void charAt(int index, char expectedValue) {
		// given
		String value = "abc";

		// when
		char realValue = value.charAt(index);

		// then
		assertThat(realValue).isEqualTo(expectedValue);
	}

	@ValueSource(ints = {Integer.MIN_VALUE, -10, -1, 5, 10, Integer.MAX_VALUE})
	@DisplayName("임의 문자열에 대해 String의 chatAt()메소드를 통해 특정 위치의 문자를 가져올 때 위치를 벗어나면 StringIndexOutOfBoundsException이 발생된다.")
	@ParameterizedTest(name = "{index} => index value [{0}] StringIndexOutOfBoundsException Throw")
	void charAt_outOfRange(int index) {
		// given
		String value = "abcde";

		// when
		ThrowingCallable exceptionContent = () -> value.charAt(index);

		// then
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(exceptionContent)
			.withMessageMatching("String index out of range: " + index);
	}
}
