package step2.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TextTest {
	@Test
	@DisplayName("대상 text 가 null 값인지 확인")
	void checkIfNull() {
		Text text = new Text(null);
		assertTrue(text.checkIfNullOrEmpty());
	}

	@Test
	@DisplayName("대상 text 가 빈 값인지 확인")
	void checkIfEmpty() {
		Text text = new Text("");
		assertTrue(text.checkIfNullOrEmpty());
	}
}
