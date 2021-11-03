package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottoStringSplitterTest {

	@DisplayName("콤마(\",\")로 문자열을 분리한다.")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3:3", "a,b,c:3", "!,@,#:3", "가,나,다:3", "1,a,!,가:4"}, delimiter = ':')
	void split1(String text, int size) {
		// when
		String[] strings = LottoStringSplitter.split(text);

		// then
		assertThat(strings).hasSize(size);
	}

	@DisplayName("null 또는 빈 문자열을 콤마(\",\")로 분리하면 크기가 0인 String 배열이 반환된다.")
	@ParameterizedTest
	@NullAndEmptySource
	void split2(String text) {
		// when
		String[] strings = LottoStringSplitter.split(text);

		//then
		assertThat(strings).hasSize(0);
	}
}