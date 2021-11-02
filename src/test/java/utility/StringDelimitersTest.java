package utility;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 구분자들")
class StringDelimitersTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> StringDelimiters.of(",", ":"));
	}

	@Test
	@DisplayName("null 구분자가 포함되어 객체화하면 IllegalArgumentException")
	void instance_containsNull_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringDelimiters.of(",", ":", null));
	}

	@Test
	@DisplayName("정규표현식 변경")
	void regex() {
		//given, when
		String regex = StringDelimiters.of(",", ":").regex();

		//then
		assertThat(regex)
			.isIn(",|:", ":|,");
	}
}
