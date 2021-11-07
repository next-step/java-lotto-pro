package step2.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TextSplitterTest {
	@ParameterizedTest
	@DisplayName("대상 text 에서 알맞는 custom delimiter 추출 테스트")
	@CsvSource(value = {"'//;\n1;2;3' : ;", "'//?\n1?2?3' : ?", "'//.\n1.2.3' : .", "'//c\n1c2c3' : c"}, delimiter=':')
	void getCustomDelimiterTest(String input, String delimiter) {
		TextSplitter textSplitter = new TextSplitter(new Text(input));
		assertEquals(textSplitter.getDelimiter().getDelimiter(), delimiter);
	}

	@ParameterizedTest
	@DisplayName("text split 테스트 - delimiter: ',' ':' ")
	@ValueSource(strings = {"1,2,3", "1:2:3"})
	void getSplitResultWithDelimiterCommaOrColon(String input) {
		TextSplitter textSplitter = new TextSplitter(new Text(input));
		assertThat(textSplitter.getSplitResult()).containsExactly("1", "2", "3");
	}

	@ParameterizedTest
	@DisplayName("text split 테스트 - custom delimiter: '+' '(' 'a' ")
	@ValueSource(strings = {"//+\n1+2+3", "//(\n1(2(3", "//a\n1a2a3"})
	void getSplitResultWithCustomDelimiter(String input) {
		TextSplitter textSplitter = new TextSplitter(new Text(input));
		assertThat(textSplitter.getSplitResult()).containsExactly("1", "2", "3");
	}
}
