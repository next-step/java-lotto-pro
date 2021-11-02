package com.example.calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("분리자")
class SplitterTest {

	@DisplayName("나머지를 구분자로 분리한다.")
	@Test
	void split_with_delimiter() {
		// given & when & then
		assertAll(
			() -> assertThat(Splitter.split(new Remainder("1,2"), new Delimiter()))
				.isEqualTo(new String[] {"1", "2"}),
			() -> assertThat(Splitter.split(new Remainder("1,2,3"), new Delimiter()))
				.isEqualTo(new String[] {"1", "2", "3"}),
			() -> assertThat(Splitter.split(new Remainder("1,2:3"), new Delimiter()))
				.isEqualTo(new String[] {"1", "2", "3"})
		);
	}

	@DisplayName("나머지를 커스텀 구분자로 분리한다.")
	@Test
	void split_with_custom_delimiter() {
		// given & when & then
		assertAll(
			() -> assertThat(Splitter.split(new Remainder("1!2"), new Delimiter("!")))
				.isEqualTo(new String[] {"1", "2"}),
			() -> assertThat(Splitter.split(new Remainder("1!2!3"), new Delimiter("!")))
				.isEqualTo(new String[] {"1", "2", "3"}),
			() -> assertThat(Splitter.split(new Remainder("1!2!3!4"), new Delimiter("!")))
				.isEqualTo(new String[] {"1", "2", "3", "4"})
		);
	}
}
