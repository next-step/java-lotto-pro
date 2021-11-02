package junit;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트\n")
class StringTest {

	@DisplayName(" '1,2'를 ,(콤마)로 split 했을 때, 잘 분리되는지 확인하는 테스트")
	@Test
	void splitCommaTest() {
		// given
		String string = "1,2";
		// when
		String[] stringArray = string.split(",");
		// then
		assertAll(
			() -> assertThat(stringArray).hasSize(2),
			() -> assertThat(stringArray[0]).isEqualTo("1"),
			() -> assertThat(stringArray[1]).isEqualTo("2")
		);
	}

	@DisplayName(" '1'를 ,(콤마)로 split 했을 때, 1만을 포함하는 배열이 반환되는지 확인하는 테스트")
	@Test
	void splitLastCommaTest() {
		// given
		String string = "1";
		// when
		String[] stringArray = string.split(",");
		// then
		assertAll(
			() -> assertThat(stringArray).hasSize(1),
			() -> assertThat(stringArray[0]).isEqualTo("1")
		);
	}

	@DisplayName(" '(1,2)를 subString() 메소드로 소괄호를 제거하고 '1,2'를 반환하는지 확인하는 테스트")
	@Test
	void removeParenthesesUsingSubstringTest() {
		// given
		String string = "(1,2)";
		// when
		String result = string.substring(1, string.length() - 1);
		// then
		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("'abc'를  charAt() 메소드로 특정위치의 문자를 가져오는 것과 위치 값을 벗어났을 때 Exception을 발생시키는지 확인하는 테스트")
	@Test
	void charAtTest() {
		// given // when
		String string = "abc";
		// then
		assertAll(
			() -> assertThat(string.charAt(0)).isEqualTo('a'),
			() -> assertThat(string.charAt(1)).isEqualTo('b'),
			() -> assertThat(string.charAt(2)).isEqualTo('c'),
			() -> assertThatThrownBy(() -> {
				string.charAt(3);
			}).isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: 3")
		);
	}
}
