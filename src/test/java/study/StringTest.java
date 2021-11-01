package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

	@DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
	@Test
	void split() {
		// given
		String value = "1,2";
		// when
		String[] splitValues = value.split(",");
		// then
		assertThat(splitValues).containsExactly("1", "2");
	}

	@DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
	@Test
	void split2() {
		// given
		String value = "1";
		// when
		String[] splitValues = value.split(",");
		// then
		assertThat(splitValues).containsExactly("1");
	}

	@DisplayName("\"(1,2)\" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환한다.")
	@Test
	void substring() {
		// given
		String value = "(1,2)";
		int beginIndex = value.indexOf("(") + 1;
		int endIndex = value.indexOf(")");
		// when
		String substringValue = value.substring(beginIndex, endIndex);
		// then
		assertThat(substringValue).isEqualTo("1,2");
	}

	@DisplayName("\"abc\" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
	@ParameterizedTest
	@CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
	void charAt(int index, char result) {
		// given
		String value = "abc";
		// when
		// then
		assertThat(value.charAt(index)).isEqualTo(result);
	}

	@DisplayName("charAt() 을 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
	@ParameterizedTest
	@ValueSource(ints = {-2, -1, 3, 4})
	void charAt2(int invalidIndex) {
		// given
		String value = "abc";
		// when
		// then
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> value.charAt(invalidIndex))
			.withMessageMatching("String index out of range: " + invalidIndex);
	}
}
