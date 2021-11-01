package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	private static final String CHARAT_TEST_STR = "abc";

	@Test
	public void split_1_comma_2_success() throws Exception {
	    String[] result = "1,2".split(",");
	    assertThat(result).containsExactly("1","2");
	}

	@Test
	public void split_only_1_success() throws Exception {
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}
	
	@Test
	public void substring_bracket_1_2_success() throws Exception {
	    String str = "(1,2)";
		String result = str.substring(1, str.length() - 1);
		assertThat(result).isEqualTo("1,2");
	}
	
	@Test
	@DisplayName("'abc'의  첫번째 character인 'a'를 반환한다.")
	public void charAt_abc_get_a_success() throws Exception {
	    assertThat(CHARAT_TEST_STR.charAt(0)).isEqualTo('a');
	}

	@Test
	@DisplayName("'abc'의  두번째 character인 'b'를 반환한다.")
	public void charAt_abc_get_b_success() throws Exception {
		assertThat(CHARAT_TEST_STR.charAt(1)).isEqualTo('b');
	}

	@Test
	@DisplayName("'abc'의  세번째 character인 'c'를 반환한다.")
	public void charAt_abc_get_c_success() throws Exception {
		assertThat(CHARAT_TEST_STR.charAt(2)).isEqualTo('c');
	}
	
	@Test
	@DisplayName("'abc'의 네번재 인덱스 선택 시 StringIndexOutOfBoundsException을 반환한다.")
	public void charAt_abc_get_4_indexOutOfBoundException_fail() throws Exception {
	    assertThatThrownBy(() -> CHARAT_TEST_STR.charAt(4))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}

	@Test
	@DisplayName("'abc'의 네번재 인덱스 선택 시 StringIndexOutOfBoundsException 반환을 확인하고 메세지를 확인한다.")
	public void charAt_abc_get_4_indexOutOfBoundException_hasmessage_fail() throws Exception {
		assertThatThrownBy(() -> CHARAT_TEST_STR.charAt(4))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageMatching("String index out of range: \\d+");
	}

	@Test
	@DisplayName("StringIndexOutOfBoundsException을 type으로 확인한다.")
	public void charAt_abc_get_4_indexOutOfBoundException_exception_type_fail() throws Exception {
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> CHARAT_TEST_STR.charAt(4))
			.withMessageMatching("String index out of range: \\d+");
	}
}
