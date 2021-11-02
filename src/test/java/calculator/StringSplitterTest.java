package calculator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringSplitterTest {

	@DisplayName("기본 구분자(\",\" or \":\")로 문자열을 분리한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"})
	void splitByDelimiter(String text) {
		// when
		String[] strings = StringSplitter.split(text);

		// then
		assertThat(strings).containsExactly("1", "2", "3").hasSize(3);
	}

	@DisplayName("null 또는 빈 문자열을 기본 구분자(\",\" or \":\")로 분리하면 크기가 0인 String 배열이 반환된다.")
	@ParameterizedTest
	@NullAndEmptySource
	void splitByDelimiter2(String text) {
		// when
		String[] strings = StringSplitter.split(text);

		//then
		assertThat(strings).hasSize(0);
	}
}