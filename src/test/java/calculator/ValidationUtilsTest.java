package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ValidationUtilsTest {
	@Test
	void checkNumber_음수() {
		assertThrows(RuntimeException.class, () -> {
			ValidationUtils.checkNumber(new String[]{"-1","2","3"});
		});
	}

	@Test
	void checkNumber_숫자이외의값() {
		assertThrows(RuntimeException.class, () -> {
			ValidationUtils.checkNumber(new String[]{"a","2","3"});
		});
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void isEmpty_null_또는_빈문자(String text) {
		assertTrue(ValidationUtils.isEmpty(text));
	}
}
