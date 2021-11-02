import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void split() {
		assertThat("1,2".split(",")).contains("1", "2");
		assertThat("1".split(",")).containsExactly("1");
	}

	@Test
	void substring() {
		final String s = "(1,2)";
		assertThat(s.substring(1, s.length() - 1)).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt(): If the index argument is invalid, throw StringIndexOutOfBoundsException")
	void charAt() {
		final String s = "abc";
		assertThat(s.charAt(0)).isEqualTo('a');
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> s.charAt(s.length()))
			.withMessageMatching("String index out of range: \\d+");
	}
}
