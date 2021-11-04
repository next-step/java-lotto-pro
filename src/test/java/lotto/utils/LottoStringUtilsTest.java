package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottoStringUtilsTest {

	@DisplayName("null 또는 빈 문자열은 빈(empty) 상태 이다.")
	@ParameterizedTest
	@NullAndEmptySource
	void isEmpty(String text) {
		// when
		boolean isEmpty = LottoStringUtils.isEmpty(text);

		// then
		assertThat(isEmpty).isEqualTo(true);
	}

	@DisplayName("입력된 문자열에 따라 빈(empty) 상태 여부를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {":true", "'':true", "a:false", "abc:false", "123:false"}, delimiter = ':')
	void isEmpty2(String text, boolean result) {
		// when
		boolean isEmpty = LottoStringUtils.isEmpty(text);

		// then
		assertThat(isEmpty).isEqualTo(result);
	}
}