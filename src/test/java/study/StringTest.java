package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

	private static final String CHARAT_TEST_STR = "abc";

	@Test
	public void split1Comma2Success() {
	    String[] result = "1,2".split(",");
	    assertThat(result).containsExactly("1","2");
	}

	@Test
	public void splitOnly1Success() {
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}
	
	@Test
	public void substringBracketSuccess() {
	    String str = "(1,2)";
		String result = str.substring(1, str.length() - 1);
		assertThat(result).isEqualTo("1,2");
	}
	
	@Test
	@DisplayName("'abc'의  첫번째 character인 'a'를 반환한다.")
	public void charAtAbcGetASuccess() {
	    assertThat(CHARAT_TEST_STR.charAt(0)).isEqualTo('a');
	}

	@Test
	@DisplayName("'abc'의  두번째 character인 'b'를 반환한다.")
	public void charAtAbcGetBSuccess() {
		assertThat(CHARAT_TEST_STR.charAt(1)).isEqualTo('b');
	}

	@Test
	@DisplayName("'abc'의  세번째 character인 'c'를 반환한다.")
	public void charAtAbcGetCSuccess() {
		assertThat(CHARAT_TEST_STR.charAt(2)).isEqualTo('c');
	}

	@DisplayName("parameterizedTest를 활용한 'abc' character 반환 성공.")
	@ParameterizedTest
	@CsvSource(value = {"0:a","1:b","2:c"}, delimiter = ':')
	public void charAtAbcGetSuccess(int index, char c) {
		assertThat(CHARAT_TEST_STR.charAt(index)).isEqualTo(c);
	}
	
	@Test
	@DisplayName("'abc'의 네번재 인덱스 선택 시 StringIndexOutOfBoundsException을 반환한다.")
	public void charAtAbcGet4IndexOutOfBoundExceptionFail() {
	    assertThatThrownBy(() -> CHARAT_TEST_STR.charAt(4))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}

	@Test
	@DisplayName("'abc'의 네번재 인덱스 선택 시 StringIndexOutOfBoundsException 반환을 확인하고 메세지를 확인한다.")
	public void charAtAbcGet4IndexOutOfBoundExceptionHasmessageFail() {
		assertThatThrownBy(() -> CHARAT_TEST_STR.charAt(4))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageMatching("String index out of range: \\d+");
	}

	@Test
	@DisplayName("StringIndexOutOfBoundsException을 type으로 확인한다.")
	public void charAtAbcGet4IndexOutOfBoundExceptionExceptionTypeFail() {
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> CHARAT_TEST_STR.charAt(4))
			.withMessageMatching("String index out of range: \\d+");
	}
}
