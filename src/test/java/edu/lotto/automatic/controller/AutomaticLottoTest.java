package edu.lotto.automatic.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Pattern;

/**
 * 로또(자동) Test Code
 * @since 2021.11.03
 * @author Inmook,Jeong
 */
public class AutomaticLottoTest {

	@ParameterizedTest
	@CsvSource(value = {"1:true", "1000:true", "100won:false", "qwerty:false"}, delimiter = ':')
	void isNumber(String value, boolean expected) {
		assertThat(Pattern.matches("[0-9]+$", value)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:false", "100:false", "999:false", "1000:true", "9999:true", "10000:true"}, delimiter = ':')
	void isMoreThanThousand(int value, boolean expected) {
		assertThat(value >= 1000).isEqualTo(expected);
	}
}
