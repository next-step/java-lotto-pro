package model.common.string.number;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.common.string.number.StringNumber;
import model.common.string.number.StringNumbers;

@DisplayName("문자열 숫자 컬렉션")
class StringNumbersTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> StringNumbers.from(Collections.singleton(StringNumber.of("1"))));
	}

	@Test
	@DisplayName("컬렉션 없이 객체화하면 IllegalArgumentException")
	void instance_nullCollection_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringNumbers.from(null));
	}

	@Test
	@DisplayName("문자열 숫자들 합")
	void sum() {
		//given, when
		int sum = StringNumbers.from(Arrays.asList(StringNumber.of("1"), StringNumber.of("2"), StringNumber.of("3")))
			.sum();

		//then
		assertThat(sum)
			.isEqualTo(6);
	}
}
