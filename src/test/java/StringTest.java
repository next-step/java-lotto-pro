import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void split() {
		String str = "1,2";
		String[] splittedStr = str.split(",");
		assertThat(splittedStr).contains("2", "1");
		assertThat(splittedStr).containsExactly("1", "2");
	}

	@Test
	void trimBracket() {
		String str = "(1,2)";
		String trimmedStr = str.substring(1, str.length() - 1);
		assertThat(trimmedStr).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt 동작 테스트 및 index 유효성 테스트")
	void charAt() {
		String str = "abc";

		assertThat(str.charAt(1)).isEqualTo('b');
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
			str.charAt(3);
		});
	}
}
