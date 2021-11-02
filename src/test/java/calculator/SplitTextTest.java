package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SplitTextTest {

	@ParameterizedTest
	@ValueSource(strings = { "1,2:3", "1,2,3", "1:2:3" })
	void split_문자분리(String text) {
		assertThat(SplitText.split(text)).containsExactly("1", "2", "3");
	}
}
