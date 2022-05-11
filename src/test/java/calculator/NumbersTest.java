package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {
	@DisplayName("빈 문자열 또는 null을 입력할 경우 0을 반환한다")
	@ParameterizedTest
	@NullAndEmptySource
	void sum_empty_null(String string) {
		assertThat(Numbers.from(string).sum().getValue()).isZero();
	}

	@DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다")
	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,1"})
	void sum_1_value(String given, String expected) {
		assertThat(Numbers.from(given).sum()).isEqualTo(Number.from(expected));
	}

	@DisplayName("기본 구분자(, 또는 :)로 구분된 숫자들을 입력할 경우 숫자들의 합을 반환한다")
	@ParameterizedTest
	@CsvSource(value = {"1:2,3=6", "4,5:6=15"}, delimiter = '=')
	void sum_values(String given, String expected) {
		assertThat(Numbers.from(given).sum()).isEqualTo(Number.from(expected));
	}
}
