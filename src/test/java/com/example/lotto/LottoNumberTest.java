package com.example.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
	@DisplayName("로또 번호를 생성한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "44", "45"})
	void constructor(int value) {
		// given & when
		LottoNumber lottoNumber = new LottoNumber(value);

		// then
		assertAll(
			() -> assertThat(lottoNumber).isNotNull(),
			() -> assertThat(lottoNumber.getValue()).isEqualTo(value)
		);
	}

	@DisplayName("로또 번호를 생성할 수 없다.")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "46"})
	void constructor_fail(int value) {
		// given & when & then
		assertThatThrownBy(() -> new LottoNumber(value))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("동등성을 비교한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "44", "45"})
	void equals(int value) {
		// given & when & then
		assertThat(new LottoNumber(value)).isEqualTo(new LottoNumber(value));
	}
}
