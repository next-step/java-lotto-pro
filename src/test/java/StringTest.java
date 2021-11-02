import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

	@DisplayName("split: 구분자로 문자열 분리 메서드 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1,2"})
	void split(String str) {
		String[] splitedStr = str.split(",");
		assertThat(splitedStr).containsExactly("1", "2");
	}

	@DisplayName("split 대상 문자열이 delimiter를 포함하지 않은 경우, 대상 문자열이 반환 배열 0번째 index에 그대로 저장")
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	void splitNotIncludeDelimiter(String str) {
		String[] splitedStr = str.split(",");
		assertThat(splitedStr).containsExactly("1");
	}

	@DisplayName("substring: index범위에 따른 부분 문자열 반환 메서드 학습테스트")
	@ParameterizedTest
	@ValueSource(strings = {"(1,2)"})
	void substring(String str) {
		String subStr = str.substring(1, 4);
		assertThat(subStr).isEqualTo("1,2");
	}

	@DisplayName("charAt: 문자열의 특정 index의 char 반환 메서드 학습테스트")
	@ParameterizedTest
	@ValueSource(strings = {"abc"})
	void charAt(String str) {
		assertThat(str.charAt(0)).isEqualTo('a');
		assertThat(str.charAt(1)).isEqualTo('b');
		assertThat(str.charAt(2)).isEqualTo('c');
	}

	@DisplayName("범위를 벗어나는 index를 charAt의 인자로 호출할때 예외")
	@ParameterizedTest
	@ValueSource(strings = {"abc"})
	void charAtOutOfBoundIndex(String str) {
		assertThatThrownBy(() -> {
			System.out.println(str.charAt(3));
		}).isInstanceOf(IndexOutOfBoundsException.class);
	}
}
