package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

	@Test
	@DisplayName("\"1,2\"을 ,로 split 했을 때 [1,2] 배열 반환")
	void test_split_success1() {
		assertThat("1,2".split(",")).containsExactly("1", "2");
	}

	@Test
	@DisplayName("\"1\"을 ,로 split 했을 때 [1] 배열 반환")
	void test_split_success2() {
		assertThat("1".split(",")).containsExactly("1");
	}

	@Test
	@DisplayName("\"(1,2)\" 값이 주어졌을 때 substring 메서드의 파라미터로 1,4를 넘겨주면 1,2 반환")
	void test_substring_success() {
		assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
	}

	@ParameterizedTest
	@CsvSource(value = {"0,a", "1,b", "2,c"})
	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드 파라미터로 인덱스를 넘겨주면 char 반환")
	void test_charAt_success(int idx, char result) {
		assertThat("abc".charAt(idx)).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value= {"3", "4"})
	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드 파라미터로 문자열 길이보다 같거나 큰 인덱스를 넘겨주면 예외 발생")
	void test_charAt_throw(int idx) {
		assertThatThrownBy(() -> "abc".charAt(idx)).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageMatching(String.format("String index out of range: %d", idx));
	}
}
