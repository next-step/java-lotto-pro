import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("split 메소드로 문자열을 분리할 수 있다.")
	void testSplit() {
		String delimiter = ",";

		assertThat("1,2".split(delimiter)).contains("1");
		assertThat("1,2".split(delimiter)).contains("2");
		assertThat("1,2".split(delimiter)).containsExactly("1", "2");

		assertThat("1".split(delimiter)).containsExactly("1");
	}
}
