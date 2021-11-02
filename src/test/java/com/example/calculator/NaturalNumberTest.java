package com.example.calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자연수")
public class NaturalNumberTest {

	@DisplayName("자연수를 생성한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "100"})
	void constructor(int value) {
		// given & when
		NaturalNumber naturalNumber = new NaturalNumber(value);

		// then
		assertAll(
			() -> assertThat(naturalNumber).isNotNull(),
			() -> assertThat(naturalNumber.getValue()).isEqualTo(value)
		);
	}

	@DisplayName("자연수를 생성한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "100"})
	void constructor(String value) {
		// given & when
		NaturalNumber naturalNumber = new NaturalNumber(value);

		// then
		assertAll(
			() -> assertThat(naturalNumber).isNotNull(),
			() -> assertThat(naturalNumber.getValue()).isEqualTo(Integer.parseInt(value))
		);
	}

	@DisplayName("자연수를 생성할 수 없다.")
	@ParameterizedTest
	@ValueSource(strings = {"-100", "-1", "0"})
	void constructor_fail(int value) {
		// given & when & then
		assertThatThrownBy(() -> new NaturalNumber(value))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("자연수를 생성할 수 없다.")
	@ParameterizedTest
	@ValueSource(strings = {"-100", "-1", "0"})
	void constructor_fail(String value) {
		// given & when & then
		assertThatThrownBy(() -> new NaturalNumber(value))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("동등성을 비교한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3"})
	void equals(int value) {
		// given & when & then
		assertThat(new NaturalNumber(value)).isEqualTo(new NaturalNumber(value));
	}

	@DisplayName("자연수끼리 더한다.")
	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3",
		"4,5,9",
		"7,8,15"
	})
	void add(int a, int b, int c) {
		// given & when & then
		assertThat(NaturalNumber.add(new NaturalNumber(a), new NaturalNumber(b))).isEqualTo(new NaturalNumber(c));
	}
}
