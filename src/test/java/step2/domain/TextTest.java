package step2.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class TextTest {
	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("대상 text 가 null 또는 빈 값인지 확인")
	void checkIfNullOrEmpty(String input) {
		Text text = new Text(input);
		assertTrue(text.checkIfNullOrEmpty());
	}
}
