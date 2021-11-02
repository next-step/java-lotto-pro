package com.example.calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("나머지")
class RemainderTest {

	@DisplayName("나머지를 생성한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2", "1,2,3", "1,2:3"})
	void constructor(String value) {
		// given & when
		Remainder remainder = new Remainder(value);

		// then
		assertAll(
			() -> assertThat(remainder).isNotNull(),
			() -> assertThat(remainder.getValue()).isEqualTo(value)
		);
	}
}
