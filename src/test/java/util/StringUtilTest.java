package util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

	@Test
	@DisplayName("문자열을 [,]로 구분하여 배열로 반환하는 함수 테스트")
	public void splitComma_test() {
		assertThat(StringUtil.splitComma("1,2")).contains("1", "2");
		assertThat(StringUtil.splitComma("1")).containsExactly("1");
	}

	@Test
	@DisplayName("문자열 양끝에 괄호가 존재하는 경우 괄호를 제거한 문자열을 반환하는 함수 테스트")
	public void removeParentheses_test() {
		assertThat(StringUtil.removeParentheses("(1,2)")).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열에서 입력한 자릿수에 해당하는 문자를 반환하는 함수 테스트")
	public void findCharacter_test() {
		String value = "abc";

		assertAll(() -> assertThat(StringUtil.findCharacter(value, 0)).isEqualTo('a'),
				() -> assertThat(StringUtil.findCharacter(value, 1)).isEqualTo('b'),
				() -> assertThat(StringUtil.findCharacter(value, 2)).isEqualTo('c'), 
				() -> assertThatThrownBy(() -> {
					StringUtil.findCharacter(value, 3);
				}).isInstanceOf(StringIndexOutOfBoundsException.class)
						.hasMessageStartingWith("Index: 3, Value Length: 3"));
	}
}
