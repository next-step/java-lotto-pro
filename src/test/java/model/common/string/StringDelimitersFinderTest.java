package model.common.string;

import static org.assertj.core.api.Assertions.*;

import java.util.regex.Pattern;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("문자 구분자 탐색기")
class StringDelimitersFinderTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> StringDelimiterFinder.of(Pattern.compile(""), ""));
	}

	@Test
	@DisplayName("구분자 패턴 없이 객체화하면 IllegalArgumentException")
	void instance_nullPattern_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringDelimiterFinder.of(null, ""))
			.withMessage("delimiter pattern must not be null");
	}

	@ParameterizedTest(name = "{displayName}[{index}] it is {1} that {0} has delimiter pattern(\"//(.)//(.*)\")")
	@DisplayName("탐색된 구분자 존재 여부")
	@CsvSource(value = {"//!//1,true", "//!//1!2!3,true", "1!2!3,false", ",false"})
	void hasDelimiter(String target, boolean expected) {
		//when
		boolean hasDelimiter = StringDelimiterFinder.of(Pattern.compile("//(.)//(.*)"), target).hasDelimiter();

		//then
		assertThat(hasDelimiter)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("탐색된 구분자 가져오기")
	void delimiter() {
		//given
		StringDelimiterFinder finder = StringDelimiterFinder.of(Pattern.compile("//(.)\n(.*)"), "//;\n1;2;3");

		//when, then
		assertThat(finder.delimiter())
			.isEqualTo(";");
	}

	@Test
	@DisplayName("찾은 구분자가 없지만 가져오려면 IllegalStateException")
	void delimiter_notExistsDelimiter_thrownIllegalStateException() {
		//given, when
		ThrowingCallable throwingCallable = () ->
			StringDelimiterFinder.of(Pattern.compile("//(.)\n(.*)"), "1;2;3")
				.delimiter();

		//then
		assertThatIllegalStateException()
			.isThrownBy(throwingCallable)
			.withMessageContaining("has not delimiter pattern");
	}

	@Test
	@DisplayName("구분자 패턴 제거한 문자열")
	void targetWithoutDelimiter() {
		//given, when
		String targetWithoutDelimiterPattern = StringDelimiterFinder.of(Pattern.compile("//(.)\n(.*)"), "//;\n1;2;3")
			.targetWithoutDelimiterPattern();

		//then
		assertThat(targetWithoutDelimiterPattern)
			.isEqualTo("1;2;3");
	}
}
