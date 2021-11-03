package edu.lotto.automatic.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 숫자 검증 및 관련 Util Test Code
 * @since 2021.11.03
 * @author Inmook,Jeong
 */
public class NumberUtilTest {

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
