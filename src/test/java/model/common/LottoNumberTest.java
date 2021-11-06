package model.common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호")
class LottoNumberTest {

	@ParameterizedTest(name = "{displayName}[{index}] {0} can be instanced")
	@DisplayName("객체화")
	@ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
	void instance(int number) {
		assertThatNoException()
			.isThrownBy(() -> LottoNumber.from(number));
	}

	@ParameterizedTest(name = "{displayName}[{index}] {0} is always equal to {0}")
	@DisplayName("같은 숫자의 객체 항상 동일")
	@ValueSource(ints = {1, 10, 45})
	void equals_sameNumber(int number) {
		//when
		boolean equals = LottoNumber.from(number)
			.equals(LottoNumber.from(number));

		//then
		assertThat(equals)
			.isTrue();
	}

	@ParameterizedTest(name = "{displayName}[{index}] {0} is always different from 1")
	@DisplayName("다른 숫자의 객체는 항상 다름")
	@ValueSource(ints = {3, 10, 45})
	void equals_differentNumber(int number) {
		//when
		boolean equals = LottoNumber.from(1)
			.equals(LottoNumber.from(number));

		//then
		assertThat(equals)
			.isFalse();
	}

	@ParameterizedTest(name = "{displayName}[{index}] if 10 number compare to {0}, the result is {1}")
	@DisplayName("다른 객체와 크기 비교")
	@CsvSource({"1,1", "9,1", "10,0", "11,-1", "45,-1"})
	void compareTo(int number, int expected) {
		//when
		int compare = LottoNumber.from(10)
			.compareTo(LottoNumber.from(number));

		//then
		assertThat(compare)
			.isEqualTo(expected);
	}

}
