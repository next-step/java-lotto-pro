package utility;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

@DisplayName("검증 유틸")
class AssertTest {

	private static final String ANY_STRING = "any";

	@Test
	@DisplayName("인스턴스화 방지")
	void instance_thrownAssertionError() {
		assertThatExceptionOfType(AssertionError.class)
			.isThrownBy(() -> ReflectionUtils.newInstance(Assert.class));
	}

	@Test
	@DisplayName("null 체크")
	void notNull() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Assert.notNull(null, ANY_STRING))
			.withMessage(ANY_STRING);
	}

	@Test
	@DisplayName("빈 문자열 체크")
	void notEmpty_string() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Assert.notEmpty(" ", ANY_STRING))
			.withMessage(ANY_STRING);
	}

	@Test
	@DisplayName("빈 컬렉션 체크")
	void notEmpty_collection() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Assert.notEmpty(Collections.emptyList(), ANY_STRING))
			.withMessage(ANY_STRING);
	}

	@Test
	@DisplayName("불리언 체크")
	void isTrue() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Assert.isTrue(false, ANY_STRING))
			.withMessage(ANY_STRING);
	}

}
