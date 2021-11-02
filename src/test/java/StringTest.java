import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("문자열 분리 테스트")
	@Test
	public void splitTest() {
		// given
		String input = "1,2";
		String delimiter = ",";

		// when
		String[] result = input.split(delimiter);

		// then
		assertThat(result)
			.hasSize(2)
			.containsExactly("1", "2");
	}

	@DisplayName("구분자를 포함하지 않는 문자열 분리 테스트")
	@Test
	public void splitNotContainDelimilterTest() {
		// given
		String input = "1";
		String delimiter = ",";

		// when
		String[] result = input.split(delimiter);

		// then
		assertThat(result)
			.hasSize(1)
			.containsExactly("1");
	}
}
