package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 구분기")
class StringSeparatorTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> StringSeparator.of("test", ""));
	}

	@Test
	@DisplayName("나눠질 대상 없이 객체화하면 IllegalArgumentException")
	void instance_nullTarget_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringSeparator.of(null, ""))
			.withMessage("'target' to be split must not be null");
	}

	@Test
	@DisplayName("구분자 없이 객체화하면 IllegalArgumentException")
	void instance_nullDelimiter_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringSeparator.of("", null))
			.withMessage("'delimiter' must not be null");
	}

	@Test
	@DisplayName("문자열 나누기")
	void provide() {
		//given, when
		Collection<String> splitString = StringSeparator.of("1,2,3,4", ",").provide();

		//then
		assertThat(splitString)
			.containsExactly("1", "2", "3", "4");
	}

}
