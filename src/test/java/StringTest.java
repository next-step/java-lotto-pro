import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void step1() {
		assertThat("1,2".split(",")).contains("1", "2");
		assertThat("1".split(",")).containsExactly("1");
	}

	@Test
	void step2() {
		final String s = "(1,2)";
		assertThat(s.substring(1, s.length() - 1)).isEqualTo("1,2");
	}
}
