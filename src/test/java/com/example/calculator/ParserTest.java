package com.example.calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("파서")
class ParserTest {

	@DisplayName("커스텀 구분자가 없을 때 파싱한다.")
	@ParameterizedTest
	@CsvSource(delimiter = '*', value = {
		"1,2,3*1,2,3",
		"1,2:3*1,2:3",
		"1:2,3*1:2,3",
		"1:2:3*1:2:3",
	})
	void parse(String string, String expected) {
		// given & when
		ParsedString parsedString = Parser.parse(string);

		// then
		assertAll(
			() -> assertThat(parsedString).isNotNull(),
			() -> assertThat(parsedString.getDelimiter().getValue()).isEqualTo("[,:]"),
			() -> assertThat(parsedString.getRemainder().getValue()).isEqualTo(expected)
		);
	}

	@DisplayName("커스텀 구분자가 있을 때 파싱한다.")
	@Test
	void parse_on_custom_delimiter() {
		// given & when
		ParsedString parsedString = Parser.parse("//;\n1;2;3");

		// then
		assertAll(
			() -> assertThat(parsedString).isNotNull(),
			() -> assertThat(parsedString.getDelimiter().getValue()).isEqualTo(";"),
			() -> assertThat(parsedString.getRemainder().getValue()).isEqualTo("1;2;3")
		);
	}
}
