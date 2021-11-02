package com.example.calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구분자")
class DelimiterTest {

	@DisplayName("기본 구분자를 생성한다.")
	@Test
	void constructor() {
		// given & when
		Delimiter delimiter = new Delimiter();

		// then
		assertAll(
			() -> assertThat(delimiter).isNotNull(),
			() -> assertThat(delimiter.getValue()).isEqualTo("[,:]")
		);
	}

	@DisplayName("커스텀 구분자를 생성한다.")
	@ParameterizedTest
	@ValueSource(strings = {";", "%"})
	void constructor(String value) {
		// given & when
		Delimiter delimiter = new Delimiter(value);

		// then
		assertAll(
			() -> assertThat(delimiter).isNotNull(),
			() -> assertThat(delimiter.getValue()).isEqualTo(value)
		);
	}
}
