package step2.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DelimiterTest {

	@ParameterizedTest
	@DisplayName("delimiter (구분자) 가 특수문자 일 경우 구분자 정규식 확인")
	@CsvSource(value = {"+ : \\+", "* : \\*", "| : \\|"}, delimiter=':')
	void getSpecialCharDelimiterTest(String input, String delimiterRegex) {
		Delimiter delimiterObj = new Delimiter(input);
		assertEquals(delimiterObj.getRegex(), delimiterRegex);
	}

	@ParameterizedTest
	@DisplayName("delimiter (구분자) 가 일반 문자 일 경우 구분자 정규식 확인")
	@CsvSource(value = {"ㄱ : ㄱ", "a : a"}, delimiter=':')
	void getGeneralCharDelimiterTest(String input, String delimiterRegex) {
		Delimiter delimiterObj = new Delimiter(input);
		assertEquals(delimiterObj.getRegex(), delimiterRegex);
	}

}
